package com.arisglobal.msklambda;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class Message {
    private String uuid;
    private String requestBody ;
    private Map<String,Object> requestHeaders;
    private Map<String,Object> requestContext;
    private Map<String,Object> requestPath;
    private Map<String,Object> requestParams;
}
