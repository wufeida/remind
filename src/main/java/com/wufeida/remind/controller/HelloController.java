package com.wufeida.remind.controller;

import com.wufeida.remind.dao.RemindMapper;
import com.wufeida.remind.model.Remind;
import com.wufeida.remind.model.RemindCriteria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@RestController
public class HelloController {
    @Resource
    RemindMapper remindMapper;

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/ce")
    public String ce() {
        Remind remind = new Remind();
        remind.setContent("ceshi");
        remind.setUserId(123);
        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
//        System.out.println("格式化输出：" + sdf.format(d));

//        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//        System.out.println("Asia/Shanghai:" + sdf.format(d));
        remind.setRemindTime(date);
        remind.setCreateAt(date);
        remind.setUpdateAt(date);
        remindMapper.insert(remind);
        return "添加成功";
    }
}
