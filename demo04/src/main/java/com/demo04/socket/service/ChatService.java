package com.demo04.socket.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.demo04.socket.model.ChatRoom;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RequiredArgsConstructor
@Service
public class ChatService {
    
    private final ObjectMapper objectMapper;
    /** 채팅방들을 담을 Map객체 */
    private Map<String, ChatRoom> chatRooms;

    @PostConstruct
    private void init() {
        chatRooms = new LinkedHashMap<>();
    }

    /**
     * 채팅방을 생성하는 메서드
     * @param name
     * @return
     */
    public ChatRoom createRoom(String name) {
        String randomId = UUID.randomUUID().toString();
        ChatRoom chatRoom = ChatRoom.builder()
            .roomId(randomId)
            .chatRoomName(name)
            .build();
        chatRooms.put(randomId, chatRoom);
        return chatRoom;
    }

    public List<ChatRoom> findAllRoom() {
        return new ArrayList<>(chatRooms.values());
    }

    public ChatRoom findRoomById(String roomId) {
        return chatRooms.get(roomId);
    }

    /**
     * 지정된 세션에 메시지를 보냄
     * @param <T>
     * @param session
     * @param message
     */
    public <T> void sendMessage(WebSocketSession session, T message) {
        try {
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
        }
        catch(IOException e) {
            System.out.println("ERROR: " + e.getMessage() + "\n" + e);
        }
    }

}
