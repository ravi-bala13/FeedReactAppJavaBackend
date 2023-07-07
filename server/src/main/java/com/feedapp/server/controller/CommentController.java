package com.feedapp.server.controller;

import com.feedapp.server.request.PostDetailsRequest;
import com.feedapp.server.response.BaseResponse;
import com.feedapp.server.service.CommentService;
import com.feedapp.server.utils.BaseResponseUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    /**
     * This api is used to create a comment for a post by a user
     */
    @PostMapping("/")
    public BaseResponse<Object> createComment(@RequestBody PostDetailsRequest postDetailsRequest){
        try {
            log.info("Received Request in createPost -{}", postDetailsRequest);
            commentService.saveComment(postDetailsRequest);
            return BaseResponseUtils.createSuccessBaseResponse();
        }catch (Exception e){
            log.error("Error in createPost", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }

    /**
     * This api is used to fetch all comments for a particular post in paginated manner which are recently commented
     */
    @GetMapping("/")
    public BaseResponse<Object> getAllPosts(@RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit){
        try {
            offset = (offset == null || offset <= 0) ? 0 : offset-1;
            limit = (limit == null || limit > 5) ? 5 : limit;
            return commentService.getAllPost(offset, limit);
        }catch (Exception e){
            log.error("Error in createPost", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }

}
