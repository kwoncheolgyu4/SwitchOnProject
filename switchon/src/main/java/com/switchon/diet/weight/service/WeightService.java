package com.switchon.diet.weight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.switchon.diet.weight.dao.IWeightDAO;
import com.switchon.diet.weight.vo.WeightVO;

@Service
public class WeightService {
	
	@Autowired
	IWeightDAO dao;
	
	public void insertWeight(WeightVO vo) throws Exception {
		
		int result = dao.insertWeight(vo);
		
		if(result == 0) {
			throw new Exception();
		}
		
	}
	
	public List<WeightVO> getWeightData(String memId){
		return dao.getWeightData(memId);
	}
	
}
