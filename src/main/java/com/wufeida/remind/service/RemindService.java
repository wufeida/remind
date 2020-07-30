package com.wufeida.remind.service;

import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import com.wufeida.remind.dao.RemindMapper;
import com.wufeida.remind.model.RemindCriteria;
import com.wufeida.remind.model.RemindWithBLOBs;
import com.wufeida.remind.utils.DingTalk;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class RemindService {
    @Resource
    RemindMapper remindMapper;
    @Resource
    DingTalk dingTalk;

    public List<RemindWithBLOBs> findUnRemind() {
        RemindCriteria remindCriteria = new RemindCriteria();
        remindCriteria.createCriteria()
                .andStatusEqualTo(1)
                .andRemindTimeLessThanOrEqualTo(new Date());
        return remindMapper.selectByExampleWithBLOBs(remindCriteria);
    }

    public void sendMsg() {
        List<RemindWithBLOBs> unRemindList = findUnRemind();
        if (unRemindList == null || unRemindList.size() == 0) {
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String now = sdf.format(new Date());
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
            String atMobileText = null;
            if (n.getMobile() != null && n.getMobile().contains(",")) {
                String[] split = StringUtils.split(n.getMobile(), ",");
                if (split != null) {
                    StringBuilder sb = new StringBuilder();
                    List<String> mobile = Arrays.asList(split);
                    mobile.forEach(m -> {
                        if (!StringUtils.isEmpty(m)) {
                            sb.append("@").append(m);
                        }
                    });
                    atMobileText = sb.toString();
                }
            } else if (n.getMobile() != null && !n.getMobile().contains(",")) {
                atMobileText = "@" + n.getMobile();
            }

            String text = "#### " + n.getTitle() + "\n" +
                    "> " + n.getContent() + "\n" +
                    "> ###### " + now + " 提醒\n" +
                    "> ###### " + atMobileText + "\n";
            Boolean isAtAll = n.getIsAtAll() > 0;
            try {
                OapiRobotSendResponse oapiRobotSendResponse = dingTalk.sendMarkdown( n.getTitle(), text, mobileList, isAtAll);
            } catch (ApiException e) {
                e.printStackTrace();
            }
            n.setStatus(0);
            remindMapper.updateByPrimaryKey(n);
        });
    }
}
