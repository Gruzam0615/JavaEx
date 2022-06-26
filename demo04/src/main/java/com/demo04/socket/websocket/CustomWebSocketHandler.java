package com.demo04.socket.websocket;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.demo04.socket.model.Chat;
import com.demo04.socket.model.ChatRoom;
import com.demo04.socket.service.ChatService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CustomWebSocketHandler extends TextWebSocketHandler {

    private final ObjectMapper objectMapper;
    private final ChatService chatService;
    
    @Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        // v0.1
        // String userName = session.getRemoteAddress().getHostString();
        // String userName = session.getId();
        // String payload = message.getPayload();
        // System.out.printf(">> %s : %s \n",userName, payload);
        // TextMessage textMessage = new TextMessage("MJ Chatting Server");
        // session.sendMessage(textMessage);
        
        // v0.2
        String userName = session.getId();
        String payload = message.getPayload();
        System.out.printf(">> %s : %s \n",userName, payload);
        Chat chat = objectMapper.readValue(payload, Chat.class);
        ChatRoom room = chatService.findRoomById(chat.getRoomId());
        room.handleActions(session, chat, chatService);
		
        // @Override 초기 상태
        // try {
		// 	session.close(CloseStatus.NOT_ACCEPTABLE.withReason("Binary messages not supported"));
		// }
		// catch (IOException ex) {
		// 	// ignore
		// }
	}

}
