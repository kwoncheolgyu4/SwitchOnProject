package com.switchon.diet.schedule.vo;

import java.util.List;

public class WeekVO {
	
	private int scheWeek;
	private int scheduleId;
	private List<DayVO> days;
	
	public int getScheWeek() {
		return scheWeek;
	}
	public void setScheWeek(int scheWeek) {
		this.scheWeek = scheWeek;
	}
	public List<DayVO> getDays() {
		return days;
	}
	public void setDays(List<DayVO> days) {
		this.days = days;
	}
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	@Override
	public String toString() {
		return "WeekVO [scheWeek=" + scheWeek + ", scheduleId=" + scheduleId + ", days=" + days + "]";
	}
	
	
}
