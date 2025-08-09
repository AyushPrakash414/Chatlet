package com.ChatLet.chatlet.Controller;

import com.ChatLet.chatlet.Entity.ChatRoom;
import com.ChatLet.chatlet.Entity.Messages;
import com.ChatLet.chatlet.Repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roomControl")
public class RoomController
{
    //create Room
    //get Room
    //join the room
    //get Messages of the Room
    private RoomRepository roomRepo;
    public ResponseEntity<?> createRoom(String userRoomId)
    {
        if (roomRepo.findByroomId(userRoomId)!=null)
        {
            return ResponseEntity.badRequest().body("Room is Already Exist");
        }
        else {

            ChatRoom room=new ChatRoom();
            room.setRoomId(userRoomId);
            roomRepo.save(room);
            return ResponseEntity.status(HttpStatus.CREATED).body(room);

        }
    }
    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(
            @PathVariable String roomId
    )

    {
        ChatRoom room=roomRepo.findByroomId(roomId);
        if (room!=null)
        {
             return ResponseEntity.ok(room);
        }
        return ResponseEntity.badRequest().body("Room not found!!");
    }

    @GetMapping ("/{roomId}")
    public ResponseEntity<List<Messages>> getMessages(
            @PathVariable String roomId
    )
    {
        ChatRoom room=roomRepo.findByroomId(roomId);
        if (room==null)
        {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(room.getMessages());
    }

}
