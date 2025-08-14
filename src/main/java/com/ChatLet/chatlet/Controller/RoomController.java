package com.ChatLet.chatlet.Controller;

import com.ChatLet.chatlet.Entity.ChatRoom;
import com.ChatLet.chatlet.Entity.Messages;
import com.ChatLet.chatlet.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roomControl")
public class RoomController
{
    //create Room
    //get Room
    //join the room
    //get Messages of the Room.
    @Autowired
    private RoomRepository roomRepo;
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody  String userRoomId)
    {
        if (roomRepo.findByRoomId(userRoomId)!=null)
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
    @GetMapping("joinRoom/{roomId}")
    public ResponseEntity<?> joinRoom(
            @PathVariable String roomId
    )

    {
        ChatRoom room=roomRepo.findByRoomId(roomId);
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
        ChatRoom room=roomRepo.findByRoomId(roomId);
        if (room==null)
        {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(room.getMessages());
    }

}
