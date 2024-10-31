package com.switchon.diet.Message.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoMessageService {
	
	private final RestTemplate restTemplate;
    
    public KakaoMessageService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> sendKakaoMessage(String accessToken, String text) {
        String url = "https://kapi.kakao.com/v2/api/talk/memo/default/send";

        // 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Bearer " + accessToken);
        
        System.out.println("메세지용 : " + accessToken);
        
        // 템플릿 데이터 설정
        String templateObject = "{"
                + "\"object_type\": \"text\","
                + "\"text\": \"" + text + "\","
                + "\"link\": {"
                + "    \"web_url\": \"https://www.naver.com\","
                + "    \"mobile_web_url\": \"https://www.naver.com\""
                + "},"
                + "\"button_title\": \"HomePage\""
                + "}";

        HttpEntity<String> entity = new HttpEntity<>("template_object=" + templateObject, headers);

        // POST 요청 보내기
        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                String.class
        );
    }
	
	
}
