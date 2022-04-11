package com.site.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.site.member.model.MemberVo;

@Mapper
public interface MemberDao {

//	멤버 로그인
	MemberVo selectId(String id);
	
//	멤버 회원가입 아이디 체크
	int registerCheckId(String id);
	
//	멤버 회원가입
	int register(MemberVo memberVo);

//	회원정보 수정
	int update(MemberVo memberVo);


}
