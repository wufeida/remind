package com.wufeida.remind.service;

import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import com.wufeida.remind.dao.RemindMapper;
import com.wufeida.remind.model.Remind;
import com.wufeida.remind.model.RemindCriteria;
import com.wufeida.remind.utils.DingTalk;
import com.wufeida.remind.utils.Tools;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RemindService {
    @Resource
    RemindMapper remindMapper;
    @Resource
    DingTalk dingTalk;

    public List<Remind> findUnRemind() {
        RemindCriteria remindCriteria = new RemindCriteria();
        remindCriteria.createCriteria()
                .andStatusEqualTo(1)
                .andRemindTimeLessThanOrEqualTo(new Date());
        return remindMapper.selectByExampleWithBLOBs(remindCriteria);
    }

    public void sendMsg() {
        List<Remind> unRemindList = findUnRemind();
        if (unRemindList == null || unRemindList.size() == 0) {
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String now = sdf.format(date);
        List<String> mobileList = new ArrayList<>();
        unRemindList.forEach(n -> {
            if (n.getMobile() != null && n.getMobile().contains(",")) {
                String[] split = StringUtils.split(n.getMobile(), ",");
                if (split != null) {
                    mobileList.addAll(Arrays.asList(split));
                }
            } else if (n.getMobile() != null && !n.getMobile().contains(",")) {
                mobileList.add(n.getMobile());
            }
//            String atMobileText = null;
//            if (n.getMobile() != null && n.getMobile().contains(",")) {
//                String[] split = StringUtils.split(n.getMobile(), ",");
//                if (split != null) {
//                    StringBuilder sb = new StringBuilder();
//                    List<String> mobile = Arrays.asList(split);
//                    mobile.forEach(m -> {
//                        if (!StringUtils.isEmpty(m)) {
//                            sb.append("@").append(m);
//                        }
//                    });
//                    atMobileText = sb.toString();
//                }
//            } else if (n.getMobile() != null && !n.getMobile().contains(",")) {
//                atMobileText = "@" + n.getMobile();
//            }

            String text = "#### " + n.getTitle() + "\n" +
                    "> " + n.getContent() + "\n" +
                    "> ###### " + now + " 提醒\n";
            if (Tools.intEquals(1, n.getNotifyType())) {
                Date nextTime = getNextTime(n.getTimeUnit(), date, n.getIntervalTime());
                String format = sdf.format(nextTime);
                text += "> ###### 预计下次提醒时间：" + format;
            } else if (Tools.intEquals(2, n.getNotifyType())) {
                text += "> ###### 仅提醒一次，请注意";
            }
            Boolean isAtAll = n.getIsAtAll() > 0;
            try {
                OapiRobotSendResponse oapiRobotSendResponse = dingTalk.sendMarkdown(n.getTitle(), text, mobileList, isAtAll);
            } catch (ApiException e) {
                e.printStackTrace();
            }

            after(n, date);
        });
    }

    public void after(Remind remind, Date now) {
        Integer notifyType = remind.getNotifyType();
        if (Tools.intEquals(1, notifyType)) {
            Date nextTime = getNextTime(remind.getTimeUnit(), now, remind.getIntervalTime());
            remind.setRemindTime(nextTime);
            remind.setUpdateAt(now);
        } else if (Tools.intEquals(2, notifyType)) {
            remind.setStatus(0);
        }
        remindMapper.updateByPrimaryKey(remind);
    }

    public Date getNextTime(String timeUnit, Date date, Integer intervalTime) {
        Date nextTime = null;
        if (Strings.isBlank(timeUnit) || Objects.isNull(date) || Objects.isNull(intervalTime)) {
            return nextTime;
        }
        timeUnit = timeUnit.toLowerCase();
        switch (timeUnit) {
            case "h":
                nextTime = DateUtils.addHours(date, intervalTime);
                break;
            case "m":
                nextTime = DateUtils.addMinutes(date, intervalTime);
                break;
            case "s":
                nextTime = DateUtils.addSeconds(date, intervalTime);
                break;
        }
        return nextTime;
    }
}
