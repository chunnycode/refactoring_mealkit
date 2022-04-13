package com.site.member.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.site.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.site.oneboard.service.OneBoardService;
import com.site.order.service.OrderService;
import com.site.member.model.MemberVo;
import com.site.oneboard.model.OneBoardVo;

@Controller
@RequestMapping("/member")
public class MemberController {

	private final MemberService memberService;
	private final OneBoardService one_boardService;
	private final OrderService orderService;

	public MemberController(MemberService memberService, OneBoardService one_boardService, OrderService orderService) {
		this.memberService = memberService;
		this.one_boardService = one_boardService;
		this.orderService = orderService;
	}

	//	멤버 로그인
	@PostMapping("/login")
	@ResponseBody
	public int login(@RequestParam String id, @RequestParam String pw, HttpSession session) {
		int result = 0; // 로그인 실패 시
		MemberVo memberVo = memberService.login(id, pw);
		if (memberVo != null) {
			session.setAttribute("session_nickname", memberVo.getNickname());
			session.setAttribute("session_id", id);
			session.setAttribute("session_flag", "success");
			session.setAttribute("session_user", "member");
			session.setAttribute("session_rank", memberVo.getRank());
			result = 1; // 로그인 성공 시
		}
		return result;
	}

//	멤버 회원가입 아이디 체크
	@PostMapping("/registerCheckId")
	@ResponseBody
	public boolean registerCheckId(@RequestParam String id) {
		return memberService.isDuplicatedId(id);
	}
	
//	멤버 회원가입
	@PostMapping("/register")
	@ResponseBody
	public MemberVo register(MemberVo memberVo) {
		return memberService.register(memberVo);
	}

//○○○○○○○○○○○○○○○○○○○○○○○○○○○시원○○○○○○○○○○○○○○○○○○○○○○○○○○○
//	배송조회 팝업
	@GetMapping("/popup")
	public String popup(@RequestParam String delivery_num,Model model) {
		model.addAttribute("delivey_num", delivery_num);
		return "popup/popup";
	}

//  마이페이지
	@RequestMapping("/mypage")
	public String mypage(HttpSession session,Model model) {
		String id = (String)session.getAttribute("session_id");
		// 주문리스트 출력 db 접근
		Map<String, Object> order_map = orderService.selectOrderList(id);
		
		// 게시판리스트 출력 db 접근
		ArrayList<OneBoardVo> list = one_boardService.MemberBoardList(id);
		
		model.addAttribute("mbList", list);
		model.addAttribute("order_map", order_map);
		return "/member/mypage";
	}
//○○○○○○○○○○○○○○○○○○○○○○○○○○○끝○○○○○○○○○○○○○○○○○○○○○○○○○○○○

//★★★★★★★★★★★★★★★★★★★★★명수★★★★★★★★★★★★★★★★★★★★★
//	회원정보 수정페이지 이동
	@GetMapping("/update")
	public String update(HttpSession session, Model model) {
		String id = (String) session.getAttribute("session_id");
		MemberVo memberVo = memberService.findMemberInfo(id);
		model.addAttribute("memberVo", memberVo);
		return "member/update";
	}

//	회원정보 수정
	@PostMapping("/update")
	@ResponseBody
	public MemberVo update(MemberVo memberVo) {
		return memberService.updateMemberInfo(memberVo);
	}
//★★★★★★★★★★★★★★★★★★★★★끝★★★★★★★★★★★★★★★★★★★★★★

}
