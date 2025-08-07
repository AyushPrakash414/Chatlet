package com.ChatLet.chatlet.Entity;

import java.time.LocalDateTime;

public class Messages
{
    private String sender;
    private String content;
    private LocalDateTime localDateTime;
    public Messages (String sender,String content)
    {
        this.sender=sender;
        this.content=content;
        this.localDateTime=LocalDateTime.now();
    }
}
