package com.demo04.socket.model;

import lombok.Data;

@Data
public class Chat {

    // 메시지 타입: 입장, 채팅
    public enum MessageType {
        ENTER, TALK, JOIN
    }

    private MessageType type;
    private String roomId;
    private String sendPeople;
    private String message;
    
}
