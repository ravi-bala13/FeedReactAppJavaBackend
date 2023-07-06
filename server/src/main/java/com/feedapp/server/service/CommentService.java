package com.feedapp.server.service;

import com.feedapp.server.database.mongo.Dao.CommentDao;
import com.feedapp.server.database.mongo.Entity.Comment;
import com.feedapp.server.database.mongo.Entity.Post;
import com.feedapp.server.request.PostDetailsRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

@Log4j2
@Service
public class CommentService {

    @Autowired
    CommentDao commentDao;

    @Async
    public void saveComment(PostDetailsRequest postDetailsRequest){
        Comment comment = Comment.builder()
                .userId(postDetailsRequest.getUserId())
                .content(postDetailsRequest.getContent())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        Comment result = commentDao.save(comment);
        log.info("saving post - {}", result.getId());
    }

}
