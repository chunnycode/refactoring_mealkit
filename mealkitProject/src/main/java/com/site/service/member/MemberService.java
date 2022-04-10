package com.site.service.member;

import com.site.vo.MemberVo;

public interface MemberService {

//	멤버 로그인
	MemberVo login(String id, String pw);
	
//	멤버 회원가입 아이디 체크
	int checkRegisterId(String id);

//	멤버 회원가입
	int register(MemberVo memberVo);

//	회원정보 수정페이지 이동
	MemberVo findMemberInfo(String id);

//	회원정보 수정
	int updateMemberInfo(MemberVo memberVo);

}
