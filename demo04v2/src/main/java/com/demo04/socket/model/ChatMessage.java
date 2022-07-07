package com.demo04.socket.model;

import lombok.Data;

@Data
public class ChatMessage {
    public enum MessageType {
        ENTER, TALK, QUIT
    }

    private MessageType messageType;
    private String roomId;
    private String sender;
    private String message;
}
