package com.switchon.diet.schedule.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.switchon.diet.member.vo.MemberVO;
import com.switchon.diet.schedule.vo.DayVO;
import com.switchon.diet.schedule.vo.ScheduleVO;
import com.switchon.diet.schedule.vo.TimeVO;
import com.switchon.diet.schedule.vo.WeekVO;

@Mapper
public interface IScheduleDAO {
	
	public ArrayList<WeekVO> schedList(MemberVO vo);
	
	public int callInsertSchedule(ScheduleVO scheduleVO);
	
	public int updateSchedule(WeekVO weekVO);
	
	// 식사/단식 방법 업데이트 쿼리
	public int updateScheduleMethod(DayVO dayVO);
	// 스케줄 시간 업데이트 쿼리
	public int updateScheduleTime(TimeVO timeVO);
	
}
