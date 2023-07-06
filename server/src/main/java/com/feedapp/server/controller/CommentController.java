package com.feedapp.server.controller;

import com.feedapp.server.request.PostDetailsRequest;
import com.feedapp.server.response.BaseResponse;
import com.feedapp.server.utils.BaseResponseUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/comments")
public class CommentController {

    /**
     * This api is used to create a comment for a post by a user
     */
    @PostMapping("/")
    public BaseResponse<Object> createComment(@RequestBody PostDetailsRequest postDetailsRequest){
        try {
            log.info("Received Request in createPost -{}", postDetailsRequest);

            return BaseResponseUtils.createSuccessBaseResponse();
        }catch (Exception e){
            log.error("Error in createPost", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }

}
