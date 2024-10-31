package com.switchon.diet.member.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.switchon.diet.common.exception.BizException;
import com.switchon.diet.common.valid.Login;
import com.switchon.diet.common.valid.Regist;
import com.switchon.diet.common.vo.MessageVO;
import com.switchon.diet.member.service.MemberService;
import com.switchon.diet.member.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	// 모든 요청에 대해 기본적으로 member 객체를 모델에 추가
    @ModelAttribute("member")
    public MemberVO setUpMemberForm() {
        return new MemberVO(); // 빈 MemberVO 객체를 반환하여 모델에 추가
    }
	
    @ModelAttribute("memberVO")
    public MemberVO setUpMemberVOForm() {
        return new MemberVO(); // 빈 MemberVO 객체를 반환하여 모델에 추가
    }
    
	@RequestMapping("/")
	public String registView(Model model) {
		model.addAttribute("member", new MemberVO());
		return "home";
	}
	
	@RequestMapping("/Do")
	public String registDo(@Validated(Regist.class) @ModelAttribute("member") MemberVO member
			             , BindingResult result
			             , Model model) {
		
		
		if(result.hasErrors()) {
			// @Validated의 member의 전달받음 매개변수가 조건에 맞지 않으면 hasErrors True
			return "/home";
		}
		
		
		try {
			member.setMemPw(passwordEncoder.encode(member.getMemPw()));
			memberService.registMember(member);
		} catch (DuplicateKeyException e) {
			MessageVO messageVO = new MessageVO(false, "회원가입","중복 아이디입니다!","/","회원가입");
			model.addAttribute("messageVO", messageVO);
			return "/home";
		} catch (DataAccessException e) {
			MessageVO messageVO = new MessageVO(false, "회원가입","잘못된 입력입니다.","/","회원가입");
			model.addAttribute("messageVO", messageVO);
			return "/home";
		} catch (BizException e) {
			MessageVO messageVO = new MessageVO(false, "회원가입","회원가입 안됨!","/","회원가입");
			model.addAttribute("messageVO", messageVO);
			return "/home";
		}
		
		MessageVO messageVO = new MessageVO(true, "회원가입","회원가입 성공!","/","로그인");
		// 리다이렉트시 데이터 전달
		model.addAttribute("messageVO", messageVO);
		
		return "forward:/";
	}
	
	@RequestMapping("/loginDo")
	public String loginDo(@Validated(Login.class) @ModelAttribute("memberVO") MemberVO member
						, BindingResult result
			            , HttpSession session
			            , HttpServletResponse response
			            , boolean remember, Model model) throws Exception {
		
		if(result.hasErrors()) {
			return "/home";
		}
		
		System.out.println(member);
		MemberVO login = memberService.loginMember(member);
		
		// 입력한 비밀번호와 db의 암호화된 비번 비교 일치하면 true, 그렇지 않으면 false 반환
		boolean match = passwordEncoder.matches(member.getMemPw(), login.getMemPw());
		
		if(login == null || !match) {
			model.addAttribute("errorMessage", "아이디 또는 비밀번호가 일치하지 않습니다.");
			return "redirect:/";
		}
		
		session.setAttribute("login", login);
		
		if(remember) {
			// 쿠키생성
			Cookie cookie = new Cookie("rememberId", login.getMemId());
			response.addCookie(cookie);
		} else {
			// 쿠키 삭제
			// 동일한 key 값을 가지는 쿠키의 유효시간을 0으로
			Cookie cookie = new Cookie("rememberId", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/logoutDo")
	public String logoutDo(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	@RequestMapping("/updateMember")
	public String updateMember(MemberVO vo, HttpSession session) {
		// 세션에서 로그인된 사용자 정보 가져오기
		MemberVO sessionMember = (MemberVO) session.getAttribute("login");
		System.out.println("세션에서 가져온 로그인 정보:" + sessionMember);
		if(sessionMember == null) {
			System.out.println("로그인 정보가 없습니다.");
			return "redirect:/";
		}
		
		// 세션에 있는 사용자 ID로 수정할 수 있도록 설정
		vo.setMemId(sessionMember.getMemId());
		
		try {
			memberService.updateMember(vo);
			session.setAttribute("login", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
	
}
