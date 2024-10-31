package com.switchon.diet.schedule.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.switchon.diet.member.vo.MemberVO;
import com.switchon.diet.schedule.dao.IScheduleDAO;
import com.switchon.diet.schedule.vo.DayVO;
import com.switchon.diet.schedule.vo.ScheduleVO;
import com.switchon.diet.schedule.vo.TimeVO;
import com.switchon.diet.schedule.vo.WeekVO;

@Service
public class ScheduleService {
	
	@Autowired
	IScheduleDAO dao;
	
	public ArrayList<WeekVO> schedList(MemberVO vo){
		
		ArrayList<WeekVO> scheduleList = new ArrayList<>();
		
		try {
			scheduleList = dao.schedList(vo);
			if(scheduleList == null || scheduleList.isEmpty()) {
				// 예를 들어, 데이터가 없을 경우 예외를 던질 수도 있습니다.
	            throw new RuntimeException("스케줄 정보가 없습니다.");
			}
		} catch(Exception e) {
			// 예외 발생 시 로그를 남기거나, 적절한 메시지와 함께 다시 예외를 던질 수 있습니다.
	        System.err.println("스케줄 목록을 가져오는 중 오류 발생: " + e.getMessage());
	        // 필요한 경우 로그를 남기는 코드 추가 가능 (e.g., logger 사용)
	        // 예외를 호출자에게 전달하려면 예외를 다시 던질 수도 있습니다.
	        throw new RuntimeException("스케줄을 불러오는 중 오류가 발생했습니다.", e);
		}
		
		return scheduleList;
	}
	
	public void callInsertSchedule(ScheduleVO scheduleVO) throws Exception {
	
		int result = dao.callInsertSchedule(scheduleVO);
		
		if(result == 0) {
			throw new Exception();
		}
	}
    
	@Transactional
	public void updateScheduleMethod(DayVO dayVO) {
        // DAO를 이용해 데이터베이스 업데이트 로직 실행
        // scheduleId와 schedDate를 기준으로 scheMethod 업데이트
		dao.updateScheduleMethod(dayVO);
    }
	
	@Transactional
	public void updateScheduleTime(TimeVO timeVO) {
        // DAO를 이용해 데이터베이스 업데이트 로직 실행
        // scheduleId와 scheSeq를 기준으로 schedTime 업데이트
		dao.updateScheduleTime(timeVO);
    }
	
	
	
}
