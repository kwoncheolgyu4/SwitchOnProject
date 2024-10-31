package com.switchon.diet.board.vo;

public class BoardKetonVO {
	
	private int rankNum;
	private String ketonName;
	private int ketonPrice;
	private String ketonUrl;
	
	public int getRankNum() {
		return rankNum;
	}
	public void setRankNum(int rankNum) {
		this.rankNum = rankNum;
	}
	public String getKetonName() {
		return ketonName;
	}
	public void setKetonName(String ketonName) {
		this.ketonName = ketonName;
	}
	public int getKetonPrice() {
		return ketonPrice;
	}
	public void setKetonPrice(int ketonPrice) {
		this.ketonPrice = ketonPrice;
	}
	public String getKetonUrl() {
		return ketonUrl;
	}
	public void setKetonUrl(String ketonUrl) {
		this.ketonUrl = ketonUrl;
	}
	@Override
	public String toString() {
		return "boardKetonVO [rankNum=" + rankNum + ", ketonName=" + ketonName + ", ketonPrice=" + ketonPrice
				+ ", ketonUrl=" + ketonUrl + "]";
	}
	
}
