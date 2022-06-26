package com.demo04.socket.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.WebSocketSession;

import com.demo04.socket.service.ChatService;

import lombok.Builder;
import lombok.Data;

@Data
public class ChatRoom {
    
    private String roomId;
    private String chatRoomName;
    private Set<WebSocketSession> sessions = new HashSet();

    @Builder
    public ChatRoom(String roomId, String chatRoomName) {
        this.roomId = roomId;
        this.chatRoomName = chatRoomName;
    }

    public void handleActions(WebSocketSession session, Chat chat, ChatService chatService) {
        if(chat.getType().equals(Chat.MessageType.ENTER)) {
            sessions.add(session);
            chat.setMessage(chat.getSendPeople() + "가 입장했습니다.");
        }
        sendMessage(chat, chatService);
    }

    public <T> void sendMessage(T message, ChatService chatService) {
        sessions.parallelStream().forEach(session -> chatService.sendMessage(session, message));
    }


}
