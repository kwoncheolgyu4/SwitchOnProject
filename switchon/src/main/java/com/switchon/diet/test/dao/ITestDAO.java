package com.switchon.diet.test.dao;

import org.apache.ibatis.annotations.Mapper;

import com.switchon.diet.test.vo.TestVO;


@Mapper
public interface ITestDAO {
	
	public int testMember(TestVO testVO);
	
	public TestVO loginTest(TestVO testVO);
	
}
