package com.ChatLet.chatlet.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "chatRooms")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoom
{
    @Id
    private String id;
    private String roomId;
    private List<Messages>messages=new ArrayList<>();
}
