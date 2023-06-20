package com.feedapp.server.database.mongo.Dao;

import com.feedapp.server.database.mongo.Entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDao extends MongoRepository<Post, String> {
}
