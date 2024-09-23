package com.arisglobal.msklambda;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class MSKUtilityService {

    private static final Logger logger = LoggerFactory.getLogger(MSKUtilityService.class);

    public static Map<String, Object> toMap(JSONObject jsonobj) {
        final Map<String, Object> map = new HashMap<>();
        for (final Object key : jsonobj.keySet()) {
            Object value = jsonobj.get(key);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key.toString(), value);
        }
        return map;
    }


    public static List<Object> toList(JSONArray array) {
        final List<Object> list = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            Object value = array.get(i);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }


    public static void jsonUtilities() {
        String originalInput = "test input";
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        System.out.println(encodedString);

        Gson gson = new Gson();
        String input = "{\n  \"body-json\": {\n    \"fname\": \"Aditya\",\n    \"lname\": \"Anand\",\n    \"age\": 28\n  },\n  \"params\": {\n    \"path\": {},\n    \"querystring\": {\n      \"userId\": \"Adi4736\",\n      \"userName\": \"Aditya Anand\"\n    },\n    \"header\": {\n      \"accept\": \"*/*\",\n      \"accept-encoding\": \"gzip, deflate, br\",\n      \"accept-language\": \"en-US,en;q\\u003d0.9\",\n      \"cache-control\": \"no-cache\",\n      \"content-type\": \"application/json\",\n      \"Host\": \"jmtngy9ce5.execute-api.us-east-1.amazonaws.com\",\n      \"keyaa\": \"AA444\",\n      \"keyxx\": \"XX999\",\n      \"origin\": \"chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop\",\n      \"postman-token\": \"6b981e58-6b3a-1d66-1abd-c88fe24d5172\",\n      \"sec-ch-ua\": \"\\\".Not/A)Brand\\\";v\\u003d\\\"99\\\", \\\"Google Chrome\\\";v\\u003d\\\"103\\\", \\\"Chromium\\\";v\\u003d\\\"103\\\"\",\n      \"sec-ch-ua-mobile\": \"?0\",\n      \"sec-ch-ua-platform\": \"\\\"Windows\\\"\",\n      \"sec-fetch-dest\": \"empty\",\n      \"sec-fetch-mode\": \"cors\",\n      \"sec-fetch-site\": \"none\",\n      \"User-Agent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36\",\n      \"X-Amzn-Trace-Id\": \"Root\\u003d1-62cd5282-073bf0642a01e22d5ef68987\",\n      \"X-Forwarded-For\": \"122.171.53.165\",\n      \"X-Forwarded-Port\": \"443\",\n      \"X-Forwarded-Proto\": \"https\"\n    }\n  },\n  \"stage-variables\": {},\n  \"context\": {\n    \"account-id\": \"\",\n    \"api-id\": \"jmtngy9ce5\",\n    \"api-key\": \"\",\n    \"authorizer-principal-id\": \"\",\n    \"caller\": \"\",\n    \"cognito-authentication-provider\": \"\",\n    \"cognito-authentication-type\": \"\",\n    \"cognito-identity-id\": \"\",\n    \"cognito-identity-pool-id\": \"\",\n    \"http-method\": \"POST\",\n    \"stage\": \"dev\",\n    \"source-ip\": \"122.171.53.165\",\n    \"user\": \"\",\n    \"user-agent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36\",\n    \"user-arn\": \"\",\n    \"request-id\": \"b6bd90b6-4410-412e-aa19-836c79a24c12\",\n    \"resource-id\": \"rzigci\",\n    \"resource-path\": \"/msklambda\"\n  }\n}";
        System.out.println(input);
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(input);
            Map inputMap = MSKUtilityService.toMap(jsonObject);
            System.out.println(inputMap);
            if (inputMap != null) {
                if (inputMap.get("body-json") != null) {
                    Map<String, Object> responseBody = (Map<String, Object>) inputMap.get("body-json");
                    String reponseBody = gson.toJson(responseBody);
                    System.out.println(reponseBody);
                    String encodedResponseBody = Base64.getEncoder().encodeToString(reponseBody.getBytes());
                    System.out.println(encodedResponseBody);
                    byte[] decodedResponseBytes = Base64.getDecoder().decode(encodedResponseBody);
                    String decodedResponseBody = new String(decodedResponseBytes);
                    System.out.println(decodedResponseBody);
                }
                if (inputMap.get("params") != null) {
                    Map<String, Object> params = (Map<String, Object>) inputMap.get("params");
                    if (params != null) {
                        if (params.get("header") != null) {
                            Map<String, Object> header = (Map<String, Object>) params.get("header");
                            System.out.println(header);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
