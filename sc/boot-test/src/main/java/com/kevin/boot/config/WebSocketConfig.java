package com.kevin.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * WebSocket配置类
 * Created by Administrator on 2016/12/27 0027.
 */
@Configuration
//注解开启使用STOMP协议来传输基于代理（message broker）的消息，
// 这是控制器支持使用@MessageMapping，类似于使用@RequestMapping
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * 注册STOMP协议的节点，并映射到指定的URL
     * @param stompEndpointRegistry
     */
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //注册一个STOMP的endpoint，并指定使用SockJS协议
        stompEndpointRegistry.addEndpoint("/endpointWisely").withSockJS();
        stompEndpointRegistry.addEndpoint("/endpointChat").withSockJS();
    }

    /**
     * 配置消息代理
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //广播式配置一个消息代理
        registry.enableSimpleBroker("/topic", "/queue");
    }
}