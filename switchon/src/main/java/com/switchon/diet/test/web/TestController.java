package com.switchon.diet.test.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.switchon.diet.test.service.TestService;
import com.switchon.diet.test.vo.TestVO;

@Controller
public class TestController {
	
	@Autowired
	TestService testService;
	
	
	@RequestMapping("/test")
	public String testView() {
		return "test/test1";
	}
	
	
	@RequestMapping("/testDo")
	public String testDo(TestVO testVO) {
		
		System.out.println(testVO);
		
		try {
			testService.testMember(testVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/test";
	}
	
	@RequestMapping("/testlogin")
	public String testlogin() {
		return "test/testlogin";
	}
	
	@RequestMapping("/testloginDo")
	public String testloginDo(TestVO vo, HttpSession testsession) {
		
		try {
			TestVO testlogin = testService.loginTest(vo);
			testsession.setAttribute("testlogin", testlogin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("로그인 완료");
		
		return "redirect:/";
	}
	
	@RequestMapping("/testmypage")
	public String testmaypge(HttpSession testsession, TestVO vo) {
		
		
		if(testsession.getAttribute("testlogin") == null) {
			return "redirect:/testlogin";
		}
		
		
		return "test/testmypage";
	}
	
	
	
}
