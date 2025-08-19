package com.ChatLet.chatlet.Controller;

import com.ChatLet.chatlet.Entity.Messages;
import com.ChatLet.chatlet.Repository.RoomRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController
{
    private RoomRepository roomRepository;
    @MessageMapping("/sendMessage/{roomid}")
    @SendTo("/topic/room/{roomid}")
    public Messages sendMessage()
    {
        return null;
    }
}
//Controller-