package com.feedapp.server.service;

import com.feedapp.server.database.mongo.Dao.CommentDao;
import com.feedapp.server.database.mongo.Entity.Comment;
import com.feedapp.server.request.PostDetailsRequest;
import com.feedapp.server.response.BaseResponse;
import com.feedapp.server.utils.BaseResponseUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    public BaseResponse<Object> getAllPost(Integer offset, Integer limit) {
        List<Comment> commentList;
        try {
            Pageable pageable = PageRequest.of(offset, limit);
            Page<Comment> postPageable = commentDao.findAll(pageable);
            commentList = postPageable.toList();
            return BaseResponseUtils.createSuccessBaseResponse(commentList);
        }catch (Exception e){
            log.error("Exception in getAllPost", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }
}
