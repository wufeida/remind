package com.wufeida.remind.service;

import com.taobao.api.ApiException;
import com.wufeida.remind.dao.RemindMapper;
import com.wufeida.remind.model.Remind;
import com.wufeida.remind.model.RemindCriteria;
import com.wufeida.remind.model.RemindWithBLOBs;
import com.wufeida.remind.utils.DingTalk;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Array;
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
                String text = "#### " + n.getTitle() + "\n" +
            "> " + n.getContent() + "\n" +
            "> ###### " + now + "提醒\n";

            String[] mobiles = StringUtils.split(n.getMobile(), ",");
            System.out.println(mobiles.length);
            if (mobiles != null) {
                mobileList.addAll(Arrays.asList(mobiles));
                mobileList.forEach(System.out::println);
            }
//            try {
//                dingTalk.sendText(n.getContent(), mobileList, false);
////                dingTalk.sendMarkdown(n.getTitle(), text, mobileList, false);
//            } catch (ApiException e) {
//                e.printStackTrace();
//            }

            n.setStatus(0);
            remindMapper.updateByPrimaryKey(n);
        });
    }
}
