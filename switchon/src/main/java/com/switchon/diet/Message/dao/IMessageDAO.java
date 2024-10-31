package com.switchon.diet.Message.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.switchon.diet.Message.vo.AlramVO;
import com.switchon.diet.member.vo.MemberVO;


@Mapper
public interface IMessageDAO {
	
	ArrayList<AlramVO> timeList(MemberVO vo);
	
}
