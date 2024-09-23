package com.arisglobal.msklambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class MSKRequestStreamHandler implements RequestStreamHandler {

    private static final Logger logger = LoggerFactory.getLogger(MSKRequestStreamHandler.class);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        JSONParser parser = new JSONParser();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        JSONObject responseJson = new JSONObject();
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        try {
            JSONObject event = (JSONObject) parser.parse(reader);
            logger.error("INPUT : " + event.toJSONString());

            String contextJSON = gson.toJson(context);
            logger.error(" CONTEXT  :  " + contextJSON);

            JSONObject responseBody = new JSONObject();
            responseBody.put("message", "New item created");
            responseBody.put("input", event.toJSONString());

            JSONObject headerJson = new JSONObject();
            headerJson.put("x-custom-header", "my custom header value");

            responseJson.put("statusCode", 200);
            responseJson.put("headers", headerJson);
            responseJson.put("body", responseBody.toString());

        } catch (Exception e) {
            responseJson.put("statusCode", 400);
            responseJson.put("exception", e);
        } finally {
            writer.write(responseJson.toString());
            writer.close();
        }

    }
}
