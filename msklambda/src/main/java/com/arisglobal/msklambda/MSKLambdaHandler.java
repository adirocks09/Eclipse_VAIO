package com.arisglobal.msklambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;
import java.util.Map;
import java.util.UUID;

public class MSKLambdaHandler implements RequestHandler<Map<String,Object>, LambdaResponse> {
    private static final Logger logger = LoggerFactory.getLogger(MSKLambdaHandler.class);
    Gson gson = new Gson();

    @Override
    public LambdaResponse handleRequest(Map<String, Object> inputMap, Context context) {
        LambdaResponse lambdaResponse = new LambdaResponse();
        Message message = new Message();
        lambdaResponse.setMessage(message);
        try{
            UUID uuid = UUID.randomUUID();
            lambdaResponse.setUuid(uuid.toString());
            message.setUuid(uuid.toString());
            if (inputMap != null) {
                if (inputMap.get("body-json") != null) {
                    String requestBodyMap = (String) inputMap.get("body-json");
                    String requestBody = gson.toJson(requestBodyMap);
                    String encodedRequestBody = Base64.getEncoder().encodeToString(requestBody.getBytes());
                    message.setRequestBody(encodedRequestBody);
                }
                if (inputMap.get("params") != null) {
                    Map<String, Object> params = (Map<String, Object>) inputMap.get("params");
                    if (params != null) {
                        if (params.get("header") != null) {
                            Map<String, Object> header = (Map<String, Object>) params.get("header");
                            message.setRequestHeaders(header);
                        }if (params.get("querystring") != null){
                            Map<String, Object> querystring = (Map<String, Object>) params.get("querystring");
                            message.setRequestParams(querystring);
                        }if (params.get("path") != null){
                            Map<String, Object> path = (Map<String, Object>) params.get("path");
                            message.setRequestPath(path);
                        }
                    }
                } if (inputMap.get("context") != null){
                    Map<String, Object> requestContext = (Map<String, Object>) inputMap.get("context");
                    message.setRequestContext(requestContext);
                }
            }
            lambdaResponse.setStatus(200);
        }catch (Exception e){
            logger.error("Exception occurred in handleRequest : " , e);
            lambdaResponse.setStatus(500);
        }
        return lambdaResponse;
    }
}
