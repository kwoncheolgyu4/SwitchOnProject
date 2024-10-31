package com.switchon.diet.schedule.vo;

import java.util.List;

public class DayVO {
	
	private String scheDay;
	private String schedDate;
	private String scheMethod;
	private List<TimeVO> times;
	private int scheduleId; // 추가된 필드
	
	public String getScheDay() {
		return scheDay;
	}
	public void setScheDay(String scheDay) {
		this.scheDay = scheDay;
	}
	public String getSchedDate() {
		return schedDate;
	}
	public void setSchedDate(String schedDate) {
		this.schedDate = schedDate;
	}
	public String getScheMethod() {
		return scheMethod;
	}
	public void setScheMethod(String scheMethod) {
		this.scheMethod = scheMethod;
	}
	public List<TimeVO> getTimes() {
		return times;
	}
	public void setTimes(List<TimeVO> times) {
		this.times = times;
	}
	
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	@Override
	public String toString() {
		return "DayVO [scheDay=" + scheDay + ", schedDate=" + schedDate + ", scheMethod=" + scheMethod + ", times="
				+ times + ", scheduleId=" + scheduleId + "]";
	}
	
	
}
