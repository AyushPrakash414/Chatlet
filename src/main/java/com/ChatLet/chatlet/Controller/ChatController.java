package com.ChatLet.chatlet.Controller;

import com.ChatLet.chatlet.Entity.ChatRoom;
import com.ChatLet.chatlet.Entity.MessageRequest;
import com.ChatLet.chatlet.Entity.Messages;
import com.ChatLet.chatlet.Repository.RoomRepository;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
public class ChatController
{
    private RoomRepository roomRepository;
    @MessageMapping("/sendMessage/{roomid}")
    @SendTo("/topic/room/{roomid}")
    public Messages sendMessage(

            @DestinationVariable String roomid,
            @RequestBody MessageRequest request

    )
    {
        ChatRoom room=roomRepository.findByRoomId(request.getRoomId());
        Messages messages=new Messages();
        messages.setContent(request.getContent());
        messages.setSender(request.getSender());
        messages.setLocalDateTime(LocalDateTime.now());
        if (room!=null)
        {
            room.getMessages().add(messages);
            roomRepository.save(room);
        }
        return messages;
    }
}
//Controller-