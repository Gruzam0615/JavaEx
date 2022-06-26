package com.demo04.socket.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo04.socket.model.ChatRoom;
import com.demo04.socket.service.ChatService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {
    
    private final ChatService chatService;

    @PostMapping
    public ChatRoom createRoom(@RequestParam(value="chatRoomName") String chatRoomName) {
        return chatService.createRoom(chatRoomName);
    }

    @GetMapping
    public List<ChatRoom> findAllRoom() {
        return chatService.findAllRoom();
    }

}
