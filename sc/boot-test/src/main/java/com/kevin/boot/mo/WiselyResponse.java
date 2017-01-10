package com.kevin.boot.mo;

/**
 * 服务端想浏览器发送的消息对象
 * Created by Administrator on 2016/12/27 0027.
 */
public class WiselyResponse {

    public String responseMessage;

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}