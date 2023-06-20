package com.feedapp.server.database.mongo.Dao;

import com.feedapp.server.database.mongo.Entity.Like;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDao extends MongoRepository<Like, String> {
}
