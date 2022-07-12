package com.demo04.socket.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo04.socket.model.ChatRoom;
import com.demo04.socket.repository.ChatRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChatService implements ChatRepository {    

    private Map<String, ChatRoom> chatRooms;
        
    @PostConstruct
    private void init() {
        chatRooms = new LinkedHashMap<>();
    }

    @Autowired
    private ChatRepository chatRepository;

    /**
     * 모든 채팅방 목록보기
     * @return
    */
    public List<ChatRoom> findAllRoom() {
        List<ChatRoom> result = new ArrayList<>(chatRooms.values());
        Collections.reverse(result);
        return result;
    }

    /**
     * roomId를 갖는 채팅방 찾기
     * @param roomId
     * @return
     */
    public ChatRoom findById(String roomId) {
        return chatRooms.get(roomId);
    }    

    public ChatRoom createRoom(String roomName, Long usersIdx) {
        ChatRoom chatRoom = ChatRoom.create(roomName, usersIdx);
        chatRooms.put(chatRoom.getRoomId(), chatRoom);
        chatRepository.createChatRoom(chatRoom);
        return chatRoom;
    }

}
