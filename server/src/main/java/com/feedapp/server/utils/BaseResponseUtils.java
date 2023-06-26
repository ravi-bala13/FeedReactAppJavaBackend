package com.feedapp.server.utils;

import com.feedapp.server.response.BaseResponse;
import org.springframework.stereotype.Service;

@Service
public class BaseResponseUtils {

    public static <T> BaseResponse<T> createSuccessBaseResponse(T result) {
        return BaseResponse.<T>builder()
                .es(0)
                .message("Success")
                .status(200)
                .time(System.currentTimeMillis())
                .result(result)
                .build();
    }


    public static BaseResponse<Object> createSuccessBaseResponse() {
        return BaseResponse.builder()
                .es(0)
                .message("Success")
                .status(200)
                .time(System.currentTimeMillis())
                .build();
    }

    public static BaseResponse<Object> createErrorBaseResponse() {
        return BaseResponse.builder()
                .es(1)
                .message("Failed!")
                .status(400)
                .time(System.currentTimeMillis())
                .build();
    }

    public static BaseResponse<Object> createErrorBaseResponse(String message) {
        return BaseResponse.builder()
                .es(1)
                .message(message)
                .status(400)
                .time(System.currentTimeMillis())
                .build();
    }

    public static BaseResponse<Object> createNoDataBaseResponse() {
        return BaseResponse.builder()
                .es(2)
                .message("No data found!")
                .status(300)
                .time(System.currentTimeMillis())
                .build();
    }

}
