package com.switchon.diet.weight.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.switchon.diet.weight.service.WeightService;
import com.switchon.diet.weight.vo.WeightVO;

@Controller
public class WeightController {

	
	@Autowired
	WeightService weightService;
	
	@RequestMapping("/weightView")
	public String weightView() {
		return "weight/weightbase";
	}
	
	@RequestMapping("/weightschedule")
	public String weightschedule() {
		return "weight/weightschedule";
	}
	
	@RequestMapping("/weightDo")
	public String weightDo(WeightVO vo) {
		
		System.out.println(vo);
		
		try {
			weightService.insertWeight(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/weightschedule";
	}
	
	@RequestMapping("/getWeightData")
	@ResponseBody
	public List<WeightVO> getWeightData(@RequestParam("memId") String memId){
		
		List<WeightVO> weightData = null;
		try {
		weightData = weightService.getWeightData(memId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return weightData;
		
	}
	
}
