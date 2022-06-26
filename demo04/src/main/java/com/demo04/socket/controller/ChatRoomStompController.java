package com.demo04.socket.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo04.socket.model.ChatRoomStomp;
import com.demo04.socket.repository.ChatRoomStompRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RequiredArgsConstructor
@RestController
@RequestMapping("/chatStomp")
public class ChatRoomStompController {

    private final ChatRoomStompRepository chatRoomStompRepository;
   
    // 채팅 리스트 화면
    @GetMapping("/room")
    public String room(Model model) {
        return "/chat/room";
    }

    // 모든 채팅방 목록 출력
    @GetMapping("/rooms")
    public List<ChatRoomStomp> rooms() {
        return chatRoomStompRepository.findAllRoom();
    }

    // 채팅방 생성
    @PostMapping("/room")
    @ResponseBody
    public ChatRoomStomp roomCreate(@RequestParam String roomName) {
        return chatRoomStompRepository.createChatRoomStomp(roomName);
    }

    // 채팅방 입장 화면
    @GetMapping("/room/enter/{roomId}")
    public String roomEnter(@PathVariable(value="roomId") String roomId) {
        return "/chat/roomEnter";
    }

    // 특정 채팅방 조회
    @GetMapping("/room/{roomId}")
    public ChatRoomStomp roomInfo(@PathVariable("roomId") String roomId) {
        return chatRoomStompRepository.findRoomStompById(roomId);
    }
    
    
}
