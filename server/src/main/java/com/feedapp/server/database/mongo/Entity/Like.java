package com.feedapp.server.database.mongo.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document("Like")
public class Like {
    @Id
    private String id;
    @Field("user_id")
    private String userId;
    @Field("post_id")
    private String postId;
    @Field("created_at")
    private Date createdAt;
    @Field("updated_at")
    private Date updatedAt;
}
