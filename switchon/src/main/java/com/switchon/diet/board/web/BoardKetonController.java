package com.switchon.diet.board.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.switchon.diet.board.service.BoardKetonService;
import com.switchon.diet.board.vo.BoardProteinVO;
import com.switchon.diet.board.vo.BoardKetonVO;

@Controller
public class BoardKetonController {
	
	@Autowired
    private BoardKetonService boardKeService;
	
	@RequestMapping("/boardView")
	public String boardView() {
		return "board/boardbase";
	}
	
	@GetMapping("/boardKetonView")
	public String getKetonList(Model model) {
		
		// 서비스 계층에서 keton 리스트 가져오기
        ArrayList<BoardKetonVO> ketonList = boardKeService.getKetonList();
        // JSP로 데이터 전달
        model.addAttribute("ketonList", ketonList);
		
		return "board/boardketon";
	}
	
	@GetMapping("/boardproteinView")
	public String getProteinList(Model model) {
		
		// 서비스 계층에서 keton 리스트 가져오기
        ArrayList<BoardProteinVO> proteinList = boardKeService.getProteinList();
        // JSP로 데이터 전달
        model.addAttribute("proteinList", proteinList);
		
		return "board/boardprotein";
	}
	
	
	
	
	
}
