package com.switchon.diet.weight.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.switchon.diet.weight.vo.WeightVO;

@Mapper
public interface IWeightDAO {
	
	public int insertWeight(WeightVO weightVO);
	
	public List<WeightVO> getWeightData(String memId);
}
