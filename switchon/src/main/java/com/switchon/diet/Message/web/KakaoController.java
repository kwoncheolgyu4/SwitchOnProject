package com.switchon.diet.Message.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.switchon.diet.Message.service.KakaoService;

@Controller
public class KakaoController {

	@Autowired
	private KakaoService ks;
	
	
	@RequestMapping(value="/kakaologin", method=RequestMethod.GET)
	public String kakaoLogin(@RequestParam(value = "code", required = false) String code, HttpSession session) throws Exception {
		//System.out.println("#########" + code);
		
		String access_Token = ks.getAccessToken(code);
		System.out.println("###access_Token#### : " + access_Token);
		
		session.setAttribute("access_token", access_Token);
		
		return "schedule/schbase";
		
		/*
		 * 리턴값의 testPage는 아무 페이지로 대체해도 괜찮습니다.
		 * 없는 페이지를 넣어도 무방합니다.
		 * 404가 떠도 제일 중요한건 #########인증코드 가 잘 출력이 되는지가 중요하므로 너무 신경 안쓰셔도 됩니다.
		 */
    	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        String accessToken = (String) session.getAttribute("access_token");
        
        if (accessToken != null) {
//            try {
//            	String appLogoutResult = ks.appLogout(accessToken);
//                String accountLogoutResult = ks.accountLogout();
//                System.out.println("appLogout result: " + appLogoutResult);
//                System.out.println("Logout result: " + accountLogoutResult);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            session.removeAttribute("access_token");  // 세션에서 access_token 제거
            System.out.println("accessToken 확인용" + accessToken);
        }
        // 내부 세션 관련 작업 처리 후 카카오 로그아웃 URL로 리다이렉트
        
        String kakaoLogoutUrl = "https://kauth.kakao.com/oauth/logout?client_id=d304b0d6951e3b4f130b2898ef0e1acd&logout_redirect_uri=http://localhost:8080/scheduleView";
        return "redirect:" + kakaoLogoutUrl;
        
    }
	
}
