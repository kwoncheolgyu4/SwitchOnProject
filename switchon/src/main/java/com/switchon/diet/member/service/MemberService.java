package com.switchon.diet.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.switchon.diet.common.exception.BizException;
import com.switchon.diet.member.dao.IMemberDAO;
import com.switchon.diet.member.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	IMemberDAO dao;
	
	public void registMember(MemberVO member) throws DuplicateKeyException
	                                               , DataAccessException
	                                               , BizException{
		
		int result = dao.registMember(member);
		
		if(result == 0) {
			throw new BizException();
		}
	}
	
	public MemberVO loginMember(MemberVO vo) throws Exception {
		
		MemberVO user = dao.loginMember(vo);
		if(user == null) {
			throw new Exception();
		}
		return user;
	}
	
	public void updateMember(MemberVO member) throws Exception {
		
		int result = dao.updateMember(member);
		
		if(result == 0) {
			throw new Exception();
		}
	}
}
