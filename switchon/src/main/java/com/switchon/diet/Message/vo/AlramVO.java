package com.switchon.diet.Message.vo;

import java.time.LocalDateTime;

public class AlramVO {
	
	private LocalDateTime schedDate;
	private String scheMethod;
	
	public LocalDateTime getSchedDate() {
		return schedDate;
	}
	public void setSchedDate(LocalDateTime schedDate) {
		this.schedDate = schedDate;
	}
	public String getScheMethod() {
		return scheMethod;
	}
	public void setScheMethod(String scheMethod) {
		this.scheMethod = scheMethod;
	}
	@Override
	public String toString() {
		return "AlramVO [schedDate=" + schedDate + ", scheMethod=" + scheMethod + "]";
	}
	
}
