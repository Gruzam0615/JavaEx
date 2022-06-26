package com.demo04.socket.model;

import java.util.UUID;

import lombok.Data;

/**
 * pub/sub방식을 이용하면 구독자 관리가 자동으로 되기때문에 웹소켓 세션 관리가 필요 없어진다.
 * 또한 송신도 자동으로 구현되므로 ChatRoom.java의 방식과 비교하면 간소해진다.
 */
@Data
public class ChatRoomStomp {

    private String roomId;
    private String roomName;

    public static ChatRoomStomp createChatRoom(String roomName) {
        ChatRoomStomp chatRoomStomp = new ChatRoomStomp();
        chatRoomStomp.roomId = UUID.randomUUID().toString();
        chatRoomStomp.roomName = roomName;
        
        return chatRoomStomp;
    }

}