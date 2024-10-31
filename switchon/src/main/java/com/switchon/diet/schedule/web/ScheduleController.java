package com.switchon.diet.schedule.web;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.switchon.diet.member.vo.MemberVO;
import com.switchon.diet.schedule.service.ScheduleService;
import com.switchon.diet.schedule.vo.DayVO;
import com.switchon.diet.schedule.vo.ScheduleVO;
import com.switchon.diet.schedule.vo.TimeVO;
import com.switchon.diet.schedule.vo.WeekVO;



@Controller
public class ScheduleController {
	
	@Autowired
	ScheduleService scheduleService;
	
	
	@RequestMapping("/scheduleView")
	public String scheduleView() {
		
		return "schedule/schbase";
	}
	
	@RequestMapping("/scheduleViewDo")
	public String scheduleNew(ScheduleVO scheduleVO, HttpSession session, RedirectAttributes redirectAttributes) {
		
		// 세션에서 로그인 정보를 확인
	    MemberVO loginUser = (MemberVO) session.getAttribute("login");
	    if (loginUser == null) {
	        redirectAttributes.addFlashAttribute("errorMessage", "로그인이 필요합니다.");
	        return "redirect:/login";  // 로그인 페이지로 리다이렉트
	    }
		
		try {
			scheduleService.callInsertSchedule(scheduleVO);
			redirectAttributes.addFlashAttribute("message", "스케쥴이 성공적으로 생성되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("errorMessage", "스케쥴 생성 중 오류가 발생했습니다.");
	        return "redirect:/";
		}
		
		return "redirect:/scheduleView";
	}
	
	
	@RequestMapping("/schWeekOne")
	public String schWeekOne(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
		MemberVO vo =  (MemberVO) session.getAttribute("login");
		
		if (vo == null) {
	        // 로그인 정보가 없으면 로그인 페이지로 리다이렉트
	        redirectAttributes.addFlashAttribute("errorMessage", "로그인이 필요합니다.");
	        return "redirect:/";
	    }
		
		try {
		
			ArrayList<WeekVO> schedList =  scheduleService.schedList(vo);
			
			// 스케줄 리스트가 비었거나 없을 경우 예외 처리
	        if (schedList == null || schedList.isEmpty()) {
	            redirectAttributes.addFlashAttribute("errorMessage", "스케쥴 정보가 없습니다. 스케쥴을 생성해 주세요.");
	            return "redirect:/scheduleView";
	        }
	        
			WeekVO week1 = schedList.get(0);
			//WeekVO week2 = schedList.get(1);
			//WeekVO week3 = schedList.get(2);
			//WeekVO week4 = schedList.get(3);
			model.addAttribute("schedList", schedList);
			model.addAttribute("week1", week1);
			
			//System.out.println("week1" + week1);
			//System.out.println("schedList" + schedList);
		
		} catch (Exception e) {
	        // 예외 발생 시 /scheduleView로 리다이렉트
	        e.printStackTrace();
	        redirectAttributes.addFlashAttribute("errorMessage", "스케쥴을 불러오는 중 오류가 발생했습니다.");
	        return "redirect:/scheduleView";
	    }
		
		return "schedule/schweekone";
	} 
	
	@RequestMapping("/schWeekTwo")
	public String schWeekTwo(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
		
		MemberVO vo =  (MemberVO) session.getAttribute("login");
		
		if (vo == null) {
	        // 로그인 정보가 없으면 로그인 페이지로 리다이렉트
	        redirectAttributes.addFlashAttribute("errorMessage", "로그인이 필요합니다.");
	        return "redirect:/";
	    }
		
		try {
		
			ArrayList<WeekVO> schedList =  scheduleService.schedList(vo);
			
			// 스케줄 리스트가 비었거나 없을 경우 예외 처리
	        if (schedList == null || schedList.isEmpty()) {
	            redirectAttributes.addFlashAttribute("errorMessage", "스케쥴 정보가 없습니다. 스케쥴을 생성해 주세요.");
	            return "redirect:/scheduleView";
	        }
	        
			WeekVO week2 = schedList.get(1);
			model.addAttribute("schedList", schedList);
			model.addAttribute("week2", week2);
			
			//System.out.println("week1" + week1);
			//System.out.println("schedList" + schedList);
		
		} catch (Exception e) {
	        // 예외 발생 시 /scheduleView로 리다이렉트
	        e.printStackTrace();
	        redirectAttributes.addFlashAttribute("errorMessage", "스케쥴을 불러오는 중 오류가 발생했습니다.");
	        return "redirect:/scheduleView";
	    }
		
		return "schedule/schweektwo";
	}
	
	
	
	@RequestMapping("/schWeekThree")
	public String schWeekThree(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
		
		MemberVO vo =  (MemberVO) session.getAttribute("login");
		
		if (vo == null) {
	        // 로그인 정보가 없으면 로그인 페이지로 리다이렉트
	        redirectAttributes.addFlashAttribute("errorMessage", "로그인이 필요합니다.");
	        return "redirect:/";
	    }
		
		try {
		
			ArrayList<WeekVO> schedList =  scheduleService.schedList(vo);
			
			// 스케줄 리스트가 비었거나 없을 경우 예외 처리
	        if (schedList == null || schedList.isEmpty()) {
	            redirectAttributes.addFlashAttribute("errorMessage", "스케쥴 정보가 없습니다. 스케쥴을 생성해 주세요.");
	            return "redirect:/scheduleView";
	        }
	        
			WeekVO week3 = schedList.get(2);
			model.addAttribute("schedList", schedList);
			model.addAttribute("week3", week3);
			
			//System.out.println("week1" + week1);
			//System.out.println("schedList" + schedList);
		
		} catch (Exception e) {
	        // 예외 발생 시 /scheduleView로 리다이렉트
	        e.printStackTrace();
	        redirectAttributes.addFlashAttribute("errorMessage", "스케쥴을 불러오는 중 오류가 발생했습니다.");
	        return "redirect:/scheduleView";
	    }
		
		
		
		return "schedule/schweekthree";
	}
	
	@RequestMapping("/schWeekFour")
	public String schWeekFour(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
		
		MemberVO vo =  (MemberVO) session.getAttribute("login");
		
		if (vo == null) {
	        // 로그인 정보가 없으면 로그인 페이지로 리다이렉트
	        redirectAttributes.addFlashAttribute("errorMessage", "로그인이 필요합니다.");
	        return "redirect:/";
	    }
		
		try {
		
			ArrayList<WeekVO> schedList =  scheduleService.schedList(vo);
			
			// 스케줄 리스트가 비었거나 없을 경우 예외 처리
	        if (schedList == null || schedList.isEmpty()) {
	            redirectAttributes.addFlashAttribute("errorMessage", "스케쥴 정보가 없습니다. 스케쥴을 생성해 주세요.");
	            return "redirect:/scheduleView";
	        }
	        
			WeekVO week4 = schedList.get(3);
			model.addAttribute("schedList", schedList);
			model.addAttribute("week4", week4);
			
			//System.out.println("week1" + week1);
			//System.out.println("schedList" + schedList);
		
		} catch (Exception e) {
	        // 예외 발생 시 /scheduleView로 리다이렉트
	        e.printStackTrace();
	        redirectAttributes.addFlashAttribute("errorMessage", "스케쥴을 불러오는 중 오류가 발생했습니다.");
	        return "redirect:/scheduleView";
	    }
		
		
		return "schedule/schweekfour";
	}
	
	@PostMapping("/updateScheduleMethod")
	@ResponseBody
	public String updateScheduleMethod(@RequestBody DayVO dayVO) {
		
		// VO에서 데이터를 받아 처리
		System.out.println("scheduleId:" + dayVO.getScheduleId());
		System.out.println("schedDate:" + dayVO.getSchedDate());
		System.out.println("schedMethod:" + dayVO.getScheMethod());
		
		// DB 업데이트 로직
		scheduleService.updateScheduleMethod(dayVO);
		
		
		return "Method updated successfully";
	}
	
	@PostMapping("/updateScheduleTime")
	@ResponseBody
	public String updateScheduleTime(@RequestBody TimeVO timeVO) {
	    // VO에서 데이터를 받아 처리
	    System.out.println("scheduleId: " + timeVO.getScheduleId());
	    System.out.println("scheSeq: " + timeVO.getScheSeq());
	    System.out.println("schedTime: " + timeVO.getSchedTime());

	    // DB 업데이트 로직
	    scheduleService.updateScheduleTime(timeVO);

	    return "Time updated successfully";
	}
	
}
