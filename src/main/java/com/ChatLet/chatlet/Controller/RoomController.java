package com.ChatLet.chatlet.Controller;

import com.ChatLet.chatlet.Entity.ChatRoom;
import com.ChatLet.chatlet.Repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roomControl")
public class RoomController
{
    //create Room
    //get Room
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

}
