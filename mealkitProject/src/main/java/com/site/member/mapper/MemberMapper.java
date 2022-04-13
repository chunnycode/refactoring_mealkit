package com.site.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.site.member.model.MemberVo;

@Mapper
public interface MemberMapper {

    //	멤버 로그인
    MemberVo selectId(String id);

    //	멤버 회원가입 아이디 체크
    int isDuplicatedId(String id);

    //	멤버 회원가입
    MemberVo register(MemberVo memberVo);

    //	회원정보 수정
	MemberVo update(MemberVo memberVo);


}
