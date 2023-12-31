package com.feedapp.server.database.mongo.Dao;

import com.feedapp.server.database.mongo.Entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao extends MongoRepository<Comment, String> {
}
