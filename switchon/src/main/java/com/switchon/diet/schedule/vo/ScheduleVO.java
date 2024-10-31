package com.switchon.diet.schedule.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ScheduleVO {
	
	private String memId;     // 사용자 ID
    private int scheduleId;   // 스케줄 ID
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDt;    // 생성 날짜
    private String useYn;     // 사용 여부 (Y: 사용, N: 미사용)
    
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public Date getCreateDt() {
		return createDt;
	}
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	@Override
	public String toString() {
		return "ScheduleVO [memId=" + memId + ", scheduleId=" + scheduleId + ", createDt=" + createDt + ", useYn="
				+ useYn + "]";
	}
    
}
