package com.ChatLet.chatlet.Repository;

import com.ChatLet.chatlet.Entity.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<ChatRoom,String>
{
        ChatRoom findByroomId(String id);
}
