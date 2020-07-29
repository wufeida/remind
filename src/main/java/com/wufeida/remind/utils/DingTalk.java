package com.wufeida.remind.utils;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import com.wufeida.remind.config.DingConf;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DingTalk {
    @Resource
    private DingConf dingConf;

    public OapiRobotSendResponse sendText(String content, List<String> mobiles, Boolean isAtAll) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(dingConf.dingUrl);
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent(dingConf.keyword + content);
        request.setText(text);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setAtMobiles(mobiles);
        // isAtAll类型如果不为Boolean，请升级至最新SDK
        at.setIsAtAll(isAtAll);
        request.setAt(at);
        return client.execute(request);
    }

    public OapiRobotSendResponse sendLink(String url, String title, String text, String picUrl, List<String> mobiles, Boolean isAtAll) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(dingConf.dingUrl);
        OapiRobotSendRequest request = new OapiRobotSendRequest();

        request.setMsgtype("link");
        OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
        link.setMessageUrl(url);
        link.setPicUrl(picUrl);
        link.setTitle(dingConf.keyword + title);
        link.setText(text);
        request.setLink(link);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setAtMobiles(mobiles);
        // isAtAll类型如果不为Boolean，请升级至最新SDK
        at.setIsAtAll(isAtAll);
        request.setAt(at);
        return client.execute(request);
    }

    public OapiRobotSendResponse sendMarkdown(String title, String text, List<String> mobiles, Boolean isAtAll) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(dingConf.dingUrl);
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("markdown");
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle(dingConf.keyword + title);
        markdown.setText(text);
//        markdown.setText("#### 杭州天气 @156xxxx8827\n" +
//                "> 9度，西北风1级，空气良89，相对温度73%\n\n" +
//                "> ![screenshot](https://gw.alicdn.com/tfs/TB1ut3xxbsrBKNjSZFpXXcXhFXa-846-786.png)\n"  +
//                "> ###### 10点20分发布 [天气](http://www.thinkpage.cn/) \n");
        request.setMarkdown(markdown);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setAtMobiles(mobiles);
        // isAtAll类型如果不为Boolean，请升级至最新SDK
        at.setIsAtAll(isAtAll);
        request.setAt(at);
        return client.execute(request);
    }
}
