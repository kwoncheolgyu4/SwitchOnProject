package com.switchon.diet.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.switchon.diet.board.dao.IBoardDAO;
import com.switchon.diet.board.vo.BoardProteinVO;
import com.switchon.diet.board.vo.BoardKetonVO;

@Service
public class BoardKetonService {
	
	@Autowired
	private IBoardDAO dao;
	
	public ArrayList<BoardKetonVO> getKetonList(){
		
		ArrayList<BoardKetonVO> getKetonList = dao.getKetonList();
		
		return getKetonList;
		
	}
	
	public ArrayList<BoardProteinVO> getProteinList(){
		
		ArrayList<BoardProteinVO> getProteinList = dao.getProteinList();
		
		return getProteinList;
		
	}
	
}
