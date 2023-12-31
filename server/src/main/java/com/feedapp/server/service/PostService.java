package com.feedapp.server.service;

import com.feedapp.server.database.mongo.Dao.PostDao;
import com.feedapp.server.database.mongo.Entity.Post;
import com.feedapp.server.request.PostDetailsRequest;
import com.feedapp.server.response.BaseResponse;
import com.feedapp.server.utils.BaseResponseUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Log4j2
@Service
public class PostService {

    @Autowired
    PostDao postDao;

    @Autowired
    MongoTemplateService mongoTemplateService;

    @Async
    public void savePost(PostDetailsRequest postDetailsRequest){
        Post post = Post.builder()
                .userId(postDetailsRequest.getUserId())
                .content(postDetailsRequest.getContent())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        Post result = postDao.save(post);
        log.info("saving post - {}", result.getId());
    }

    public BaseResponse<Object> getAllPost(Integer offset, Integer limit){
        List<Post> postList;
        try {
            Pageable pageable = PageRequest.of(offset, limit);
            Page<Post> postPageable = postDao.findAll(pageable);
            postList = postPageable.toList();
            return BaseResponseUtils.createSuccessBaseResponse(postList);
        }catch (Exception e){
            log.error("Exception in getAllPost", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }

    public BaseResponse<Object> getAllPostForParticularUser(String loginUserId, Integer offset, Integer limit) {
        List<Post> postList;
        try {
            Pageable pageable = PageRequest.of(offset, limit);
            Page<Post> postPageable = postDao.findAllByUserId(loginUserId, pageable);
            postList = postPageable.toList();
            return BaseResponseUtils.createSuccessBaseResponse(postList);
        }catch (Exception e){
            log.error("Exception in getAllPost", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }
    @Async
    public void likePost(PostDetailsRequest postDetailsRequest) {
        mongoTemplateService.updatePostLike(postDetailsRequest.getPostId(), 1);
    }

    @Async
    public void dislikePost(PostDetailsRequest postDetailsRequest) {
        mongoTemplateService.updatePostLike(postDetailsRequest.getPostId(), -1);
    }
}
