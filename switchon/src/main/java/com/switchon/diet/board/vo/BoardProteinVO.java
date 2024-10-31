package com.switchon.diet.board.vo;

public class BoardProteinVO {
	
	private int rankNum;
	private String proteinTitle;
	private int proteinPrice;
	private String proteinUrl;
	
	public int getRankNum() {
		return rankNum;
	}
	public void setRankNum(int rankNum) {
		this.rankNum = rankNum;
	}
	
	public int getProteinPrice() {
		return proteinPrice;
	}
	public void setProteinPrice(int proteinPrice) {
		this.proteinPrice = proteinPrice;
	}
	public String getProteinUrl() {
		return proteinUrl;
	}
	public void setProteinUrl(String proteinUrl) {
		this.proteinUrl = proteinUrl;
	}
	public String getProteinTitle() {
		return proteinTitle;
	}
	public void setProteinTitle(String proteinTitle) {
		this.proteinTitle = proteinTitle;
	}
	@Override
	public String toString() {
		return "BoardProteinVO [rankNum=" + rankNum + ", proteinTitle=" + proteinTitle + ", proteinPrice="
				+ proteinPrice + ", proteinUrl=" + proteinUrl + "]";
	}
	
	
}
