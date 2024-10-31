package com.switchon.diet.Message.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Service
public class KakaoService {

	public String getAccessToken (String authorize_code) {
		String access_Token = "";
		String refresh_Token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";

		try {
			URL url = new URL(reqURL);
            
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
            
			sb.append("&client_id=d304b0d6951e3b4f130b2898ef0e1acd"); //본인이 발급받은 key
			sb.append("&redirect_uri=http://localhost:8080/kakaologin"); // 본인이 설정한 주소
            
			sb.append("&code=" + authorize_code);
			sb.append("&scope=talk_message");
			bw.write(sb.toString());
			bw.flush();
            
			// 결과 코드가 200이라면 성공
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
            
			// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";
            
			while ((line = br.readLine()) != null) {
				result += line;
			}
			//System.out.println("response body : " + result);
            
			// Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
            
			access_Token = element.getAsJsonObject().get("access_token").getAsString();
			refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
            
			System.out.println("access_token : " + access_Token);
			System.out.println("refresh_token : " + refresh_Token);
            
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return access_Token;
	}
	
//	public String appLogout(String accessToken) throws IOException {
//        String reqURL = "https://kapi.kakao.com/v1/user/logout";
//        URL url = new URL(reqURL);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("POST");
//        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//        conn.setRequestProperty("Authorization", "Bearer " + accessToken);
//
//        int responseCode = conn.getResponseCode();
//        System.out.println("앱 로그아웃 코드 : " + responseCode);
//        BufferedReader br = new BufferedReader(new InputStreamReader(
//                responseCode == 200 ? conn.getInputStream() : conn.getErrorStream()
//        ));
//        
//        System.out.println("로그아웃 br :" + br.readLine());
//        StringBuilder result = new StringBuilder();
//        String line;
//        System.out.println("로그아웃 appresult :" + result);
//        while ((line = br.readLine()) != null) {
//            result.append(line);
//        }
//        br.close();
//
//        return result.toString();
//    }
//
//    public String accountLogout() throws IOException {
//        String reqURL = "https://kauth.kakao.com/oauth/logout?client_id=d304b0d6951e3b4f130b2898ef0e1acd&logout_redirect_uri=http://localhost:8080/kakaologout";
//        
//        URL url = new URL(reqURL);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//
//        int responseCode = conn.getResponseCode();
//        System.out.println("로그아웃 코드 : " + responseCode);
//        BufferedReader br = new BufferedReader(new InputStreamReader(
//        		(responseCode == 200 || responseCode == 302) ? conn.getInputStream() : conn.getErrorStream()
//        ));
//        
//        System.out.println("로그아웃 br :" + br.readLine());
//        StringBuilder result = new StringBuilder();
//        String line;
//        System.out.println("로그아웃 accountresult :" + result);
//        while ((line = br.readLine()) != null) {
//            result.append(line);
//        }
//        br.close();
//
//        return result.toString();
//    }
	
}
