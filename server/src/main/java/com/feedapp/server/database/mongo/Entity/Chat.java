package com.feedapp.server.database.mongo.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document("Chat")
public class Chat {
    @Id
    private String id;
    @Field("chat_id")    // Bala_hema, Anbu_bala
    private String chatId;
    private String author;
    private String recipient;
    private String message;
    private String time;
    @Field("created_at")
    private Date createdAt;
    @Field("updated_at")
    private Date updatedAt;
}
