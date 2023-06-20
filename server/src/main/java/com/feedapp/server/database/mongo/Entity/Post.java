package com.feedapp.server.database.mongo.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("Post")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post {
    @Id
    private String id;

    @Field("user_id")
    private String userId;

    private String content;

    @Builder.Default
    @Field("comment_sec")
    private Boolean commentSec = false;

    @Builder.Default
    private Integer likes = 0;

    @Field("created_at")
    private Date createdAt;

    @Field("updated_at")
    private Date updatedAt;
}
