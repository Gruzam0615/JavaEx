package com.demo04.socket.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo04.socket.model.ChatRoom;
import com.demo04.socket.service.ChatService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {
    
    private final ChatService chatService;

    /**
     * 채팅 리스트를 보여주는 VIEW
     * @param model
     * @return
     */
    @GetMapping("/room")
    public String rooms(Model model) {
        return "/chat/room";
    }

    /**
     * 모든 채팅방을 목록으로 반환
     * @return
     */
    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom> room() {
        return chatService.findAllRoom();
    }

    /**
     * 채팅방 생성
     * @param name
     * @return
     */
    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name) {
        return chatService.createRoom(name);
    }

    /**
     * 채팅방 입장을 위한 VIEW
     * @param model
     * @param roomId
     * @return
     */
    @GetMapping("/room/enter/{roomId}")
    public String roomDetail(Model model, @PathVariable String roomId) {
        model.addAttribute("roomId", roomId);
        return "/chat/roomdetail";
    }

    /**
     * 특정 roomId를 갖는 채팅방 조회
     * @param roomId
     * @return
     */
    @GetMapping("/room/{roomId}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String roomId) {
        return chatService.findById(roomId);
    }

}
