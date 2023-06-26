package com.feedapp.server.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDetailsRequest {
    private String postId;
    private String userId;
    private String content;
}
