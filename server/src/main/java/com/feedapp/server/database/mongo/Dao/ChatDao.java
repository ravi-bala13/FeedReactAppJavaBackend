package com.feedapp.server.database.mongo.Dao;

import com.feedapp.server.database.mongo.Entity.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatDao extends MongoRepository<Chat, String> {
}
