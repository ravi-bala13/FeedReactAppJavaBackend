package com.feedapp.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class MongoTemplateService {

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * This function used to increment or decrement post's like count using mongo template query
     * @param postId id of post to update
     * @param incrementValue (-1-> dislike or 1-> like)
     */
    public void updatePostLike(String postId, int incrementValue){
        Query query = new Query(Criteria.where("_id").is(postId));
        Update update = new Update().inc("likes", incrementValue);
        mongoTemplate.updateFirst(query, update, "Post");
    }

}
