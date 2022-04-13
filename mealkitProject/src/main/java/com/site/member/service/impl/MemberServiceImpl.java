package com.site.member.service.impl;

import com.site.member.mapper.MemberMapper;
import com.site.member.service.MemberService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.site.member.model.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

	public MemberServiceImpl(MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
		this.memberMapper = memberMapper;
		this.passwordEncoder = passwordEncoder;
	}

	//	회원 로그인
    @Override
    public MemberVo login(String id, String pw) {
        MemberVo memberVo = memberMapper.selectId(id);
        if (passwordEncoder.matches(pw, memberVo.getPw())) { // login form의 pw와 db의 pw 비교
        } else { // pw가 같지 않을 경우
            memberVo = null;
        }
        return memberVo;
    }

    //	아이디 중복 체크
    @Override
    public boolean isDuplicatedId(String id) {
        return memberMapper.isDuplicatedId(id) > 0;
    }

    // 회원 등록
    @Override
    public MemberVo register(MemberVo memberVo) {
        memberVo.setPw(passwordEncoder.encode(memberVo.getPw())); // bcryt로 pw를 인코딩해서 db에 저장
        return memberMapper.register(memberVo);
    }

    // 회원 정보 조회
    @Override
    public MemberVo findMemberInfo(String id) {
        return memberMapper.selectId(id);
    }

    // 회원 정보 수정
    @Override
    public MemberVo updateMemberInfo(MemberVo memberVo) {
        memberVo.setPw(passwordEncoder.encode(memberVo.getPw())); // bcryt로 pw 인코딩
        return memberMapper.update(memberVo);
    }


}
