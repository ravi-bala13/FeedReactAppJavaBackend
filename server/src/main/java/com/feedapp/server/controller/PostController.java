package com.feedapp.server.controller;

import com.feedapp.server.request.PostDetailsRequest;
import com.feedapp.server.response.BaseResponse;
import com.feedapp.server.service.PostService;
import com.feedapp.server.utils.BaseResponseUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/")
    public BaseResponse<Object> createPost(@RequestBody PostDetailsRequest postDetailsRequest){
        try {
            log.info("Received Request in createPost -{}", postDetailsRequest);
            postService.savePost(postDetailsRequest);
            return BaseResponseUtils.createSuccessBaseResponse();
        }catch (Exception e){
            log.error("Error in createPost", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }

    @GetMapping("/")
    public BaseResponse<Object> getAllPosts(@RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit){
        try {
            offset = (offset == null || offset <= 0) ? 0 : offset-1;
            limit = (limit == null || limit > 5) ? 5 : limit;
            return postService.getAllPost(offset, limit);
        }catch (Exception e){
            log.error("Error in createPost", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }

    @GetMapping("/self")
    public BaseResponse<Object> getPostForParticularUser(@RequestParam("loginUserId") String loginUserId, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit){
        try {
            offset = (offset == null || offset <= 0) ? 0 : offset-1;
            limit = (limit == null || limit > 5) ? 5 : limit;
            return postService.getAllPostForParticularUser(loginUserId, offset, limit);
        }catch (Exception e){
            log.error("Error in getPostForParticularUser", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }

    @PostMapping("/like")
    public BaseResponse<Object> likePost(@RequestBody PostDetailsRequest postDetailsRequest){
        try {
            postService.likePost(postDetailsRequest);
            return BaseResponseUtils.createSuccessBaseResponse();
        }catch (Exception e){
            log.error("Error in likePost", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }
}
