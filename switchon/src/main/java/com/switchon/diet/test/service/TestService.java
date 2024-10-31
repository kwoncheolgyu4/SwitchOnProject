package com.switchon.diet.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.switchon.diet.test.dao.ITestDAO;
import com.switchon.diet.test.vo.TestVO;

@Service
public class TestService {
	
	@Autowired
	ITestDAO dao;
		
	public void testMember(TestVO testVO) throws Exception {
		
		int result = dao.testMember(testVO);
		
		if(result == 0) {
			throw new Exception();
		}
		
	}
	
	public TestVO loginTest(TestVO vo) throws Exception {
		
		TestVO user = dao.loginTest(vo);
		if(user == null) {
			throw new Exception();
		}
		
		return user;
	}
}
