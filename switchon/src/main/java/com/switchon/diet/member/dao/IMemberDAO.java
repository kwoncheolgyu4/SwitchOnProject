package com.switchon.diet.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.switchon.diet.member.vo.MemberVO;



//Mybatis에서 Mapper 인터페이스임을 나타내는 어노테이션
//SQL 쿼리와 Java 객체 간의 매핑을 자동으로 처리함.
@Mapper   // mapper에 namespace와 매핑됨.
public interface IMemberDAO {
	// mapper xml 의  id와 매피오딤.
	public int registMember(MemberVO member);
	// 회원 조회
	public MemberVO loginMember(MemberVO vo);
	// 회원 수정
	public int updateMember(MemberVO member);
}
