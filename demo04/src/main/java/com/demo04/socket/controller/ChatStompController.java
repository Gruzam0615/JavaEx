package com.demo04.socket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

import com.demo04.socket.model.Chat;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ChatStompController {

    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat/message")
    public void message(Chat chat) {
        if (Chat.MessageType.JOIN.equals(chat.getType()))
            chat.setMessage(chat.getSendPeople() + "님이 입장하셨습니다.");
        messagingTemplate.convertAndSend("/sub/chat/room/" + chat.getRoomId(), chat);
    }
}