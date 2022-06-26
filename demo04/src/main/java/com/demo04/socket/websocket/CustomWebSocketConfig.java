package com.demo04.socket.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSocket
public class CustomWebSocketConfig implements WebSocketConfigurer {

    // @Override
    // public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    //     registry.addHandler(customHandler(), "/socketTest01")
    //         .addInterceptors(new HttpSessionHandshakeInterceptor())
    //         .setAllowedOrigins("http://localhost:8080")
    //         .withSockJS();      
    // }

    // @Bean
    // public WebSocketHandler customHandler() {
    //     return new CustomWebSocketHandler();
    // }
    private final CustomWebSocketHandler customWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(customWebSocketHandler, "/socketTest01")
            .setAllowedOrigins("*"); //CORS issue 때문에 * 로 설정
            // SockJS를 활용할 경우
            // .withSockJS();
    }

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(8192);
        container.setMaxBinaryMessageBufferSize(8192);
        return container;
    }

    
}
