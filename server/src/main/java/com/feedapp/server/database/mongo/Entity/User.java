package com.feedapp.server.database.mongo.Entity;

import com.feedapp.server.enums.UserRoles;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

import static com.feedapp.server.enums.UserRoles.USER;

@Document("User")
public class User {

    @Id
    private String id;
    @Field("user_name")
    private String userName;
    @Field("first_name")
    private String firstName;
    @Field("last_name")
    private String lastName;
    private String email;
    private String password;
    private Enum<UserRoles> role = USER;
    @Field("created_at")
    private Date createdAt;
    @Field("updated_at")
    private Date updatedAt;
}
