package com.switchon.diet.Message.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.switchon.diet.Message.service.MessageService;
import com.switchon.diet.member.vo.MemberVO;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	
	@RequestMapping("/startAlarm")
	public String startAlarm(HttpSession session, RedirectAttributes redirectAttributes) {
		
		MemberVO vo = (MemberVO) session.getAttribute("login");
		String accessToken = (String) session.getAttribute("access_token");
		
		
		// 알람 시작
		// 메시지 전송
        if (accessToken != null && vo != null) {
            messageService.startAlarm(vo, accessToken);
        } else {
            System.out.println("accessToken이 없습니다.");
            redirectAttributes.addFlashAttribute("alertMessage", "카카오 로그인 정보가 없습니다. 로그인해주세요");
        }
		
		return "redirect:/scheduleView";
	}
	
	@RequestMapping("/stopAlarm")
    public String stopAlarm() {
        // 알람 중지
        messageService.stopAlarm();

        return "redirect:/scheduleView";
    }
	
}
