package com.feedapp.server.database.mongo.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document("Post")
public class Post {
    @Id
    private String id;
    @Field("user_id")
    private String userId;
    private String content;
    @Field("comment_sec")
    private Boolean commentSec = false;
    private Integer likes = 0;
    @Field("created_at")
    private Date createdAt;
    @Field("updated_at")
    private Date updatedAt;
}
