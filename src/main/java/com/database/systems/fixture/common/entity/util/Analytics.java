package com.database.systems.fixture.common.entity.util;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by chris on 2/28/18.
 */
public class Analytics {

    private static String logstashURL = "http://log:31311";

    public static String sendJson(String json){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
        return restTemplate.postForObject(logstashURL, httpEntity, String.class);
    }

    /*public static void main(String[] args) {
        Analytics.sendJson("{\"user\":\"gino\"}");
    }*/

}


