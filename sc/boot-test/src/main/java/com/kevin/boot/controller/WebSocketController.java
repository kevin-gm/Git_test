package com.kevin.boot.controller;

import com.kevin.boot.mo.WiselyMessage;
import com.kevin.boot.mo.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by Administrator on 2016/12/27 0027.
 */
@Controller
//@RequestMapping(value = "/ws")
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping(value = "/welcome")
    @SendTo(value = "/topic/getResponse")
    public WiselyResponse say(WiselyMessage msg) throws InterruptedException {
        Thread.sleep(3000);
        return new WiselyResponse("Welcome," + msg.getName() );
    }

    @MessageMapping(value = "/chat")
    public void handleChat(Principal principal, String msg) {
        if (principal.getName().equals("kevin")) {
            messagingTemplate.convertAndSendToUser("any", "/queue/notifications", principal.getName() + "--send:" + msg);
        } else {
            messagingTemplate.convertAndSendToUser("kevin", "/queue/notifications", principal.getName() + "--send:" + msg);
        }
    }
}