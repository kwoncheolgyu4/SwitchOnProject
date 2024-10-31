package com.switchon.diet.member.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.switchon.diet.common.valid.Login;
import com.switchon.diet.common.valid.Regist;

public class MemberVO {
	
	@NotEmpty(message="아이디 필수!!", groups={Login.class, Regist.class})
	private String memId;
	// \\w -> [a~zA~Z0~9]
	@Pattern(regexp="^\\w{4,10}$", message="패스워드는 영문 숫자 4 ~ 10로 입력!", groups={Login.class, Regist.class})
	private String memPw;
	@Size(min=1, max=20, message="이름은 20자 이내로 입력!!", groups={Regist.class})
	private String memNm;
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemNm() {
		return memNm;
	}
	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}
	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPw=" + memPw + ", memNm=" + memNm + "]";
	}

	
	
}
