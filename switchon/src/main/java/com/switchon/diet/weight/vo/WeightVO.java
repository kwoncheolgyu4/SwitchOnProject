package com.switchon.diet.weight.vo;

public class WeightVO {

	private int weightNo;              /* 게시글 번호*/
	private String memId;              /* 작성자 아이디*/
	private String weightNum;          /* 체중*/
	private String createDt;           /* 생성 일자*/
	
	public int getWeightNo() {
		return weightNo;
	}
	public void setWeightNo(int weightNo) {
		this.weightNo = weightNo;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getWeightNum() {
		return weightNum;
	}
	public void setWeightNum(String weightNum) {
		this.weightNum = weightNum;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	@Override
	public String toString() {
		return "WeightVO [weightNo=" + weightNo + ", memId=" + memId + ", weightNum=" + weightNum + ", createDt="
				+ createDt + "]";
	}
	
	
}
