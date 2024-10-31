package com.switchon.diet.schedule.vo;

public class TimeVO {
	
	private String schedTime;
	private int scheSeq ;
	private int scheduleId; // 추가된 필드
	
	public String getSchedTime() {
		return schedTime;
	}
	public void setSchedTime(String schedTime) {
		this.schedTime = schedTime;
	}
	public int getScheSeq() {
		return scheSeq;
	}
	public void setScheSeq(int scheSeq) {
		this.scheSeq = scheSeq;
	}
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	@Override
	public String toString() {
		return "TimeVO [schedTime=" + schedTime + ", scheSeq=" + scheSeq + ", scheduleId=" + scheduleId + "]";
	}
	
	
	
}
