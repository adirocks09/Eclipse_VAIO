package com.arisglobal.msklambda;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MSKHandler implements RequestHandler <Map<String,Object>, LambdaResponse> {

    private static final Logger logger = LoggerFactory.getLogger(MSKHandler.class);
    Gson gson = new Gson();
    // private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /*
    @Override
    public Object handleRequest(Map<String, Object> input, Context context) {
        Map<String,Object> responseMap = new HashMap<>();

        String inputJSON = gson.toJson(input);
        logger.error(" INPUT  :  " + inputJSON);
        responseMap.put("Input", JsonParser.parseString(inputJSON).getAsJsonObject());

        String contextJSON = gson.toJson(context);
        logger.error(" CONTEXT  :  " + contextJSON);
        responseMap.put("Context", JsonParser.parseString(contextJSON).getAsJsonObject());

        UUID uuid = UUID.randomUUID();
        responseMap.put("UUID",uuid.toString());

        responseMap.put("Message ","AWS API Gateway -> Lambda -> MSK Integration");

        logger.error(" OUTPUT  :  " + gson.toJson(responseMap));
        return responseMap;

    }
    */

    @Override
    public LambdaResponse handleRequest(Map<String, Object> inputMap, Context context) {
        LambdaResponse lambdaResponse = new LambdaResponse();
        Message message = new Message();
        lambdaResponse.setMessage(message);
        try{
            UUID uuid = UUID.randomUUID();
            lambdaResponse.setUuid(uuid.toString());
            if (inputMap != null) {
                if (inputMap.get("body-json") != null) {
                    Map<String, Object> requestBodyMap = (Map<String, Object>) inputMap.get("body-json");
                    String requestBody = gson.toJson(requestBodyMap);
                    //System.out.println(requestBody);
                    String encodedRequestBody = Base64.getEncoder().encodeToString(requestBody.getBytes());
                    //System.out.println(encodedRequestBody);
                    //byte[] decodedRequestBytes = Base64.getDecoder().decode(encodedRequestBody);
                    //String decodedRequestBody = new String(decodedRequestBytes);
                    //System.out.println(decodedRequestBody);
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
