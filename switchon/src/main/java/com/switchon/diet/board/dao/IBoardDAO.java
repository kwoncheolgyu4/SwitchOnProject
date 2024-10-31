package com.switchon.diet.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.switchon.diet.board.vo.BoardProteinVO;
import com.switchon.diet.board.vo.BoardKetonVO;

@Mapper
public interface IBoardDAO {
	
	// 저탄수 도시락 리스트
	// keton_choice 테이블에서 keton 정보를 가져오는 메서드
    ArrayList<BoardKetonVO> getKetonList();
	
    ArrayList<BoardProteinVO> getProteinList();
}
