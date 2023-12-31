package com.feedapp.server.database.mongo.Dao;

import com.feedapp.server.database.mongo.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends MongoRepository<User, String> {
}
