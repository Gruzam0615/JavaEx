package com.demo04.socket.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.demo04.socket.model.ChatRoomStomp;

@Repository
public class ChatRoomStompRepository {
    
    private Map<String, ChatRoomStomp> chatRoomStompMap;

    @PostConstruct
    private void init() {
        chatRoomStompMap = new LinkedHashMap<>();
    }

    public List<ChatRoomStomp> findAllRoom() {
        //채팅방을 최근 생성된 순서대로 반환
        List chatRooms = new ArrayList<>();
        Collections.reverse(chatRooms);
        return chatRooms;
    }

    public ChatRoomStomp findRoomStompById(String roomId) {
        return chatRoomStompMap.get(roomId);
    }

    public ChatRoomStomp createChatRoomStomp(String roomName) {
        ChatRoomStomp chatRoomStomp = ChatRoomStomp.createChatRoom(roomName);
        chatRoomStompMap.put(chatRoomStomp.getRoomId(), chatRoomStomp);
        return chatRoomStomp;
    }

}
