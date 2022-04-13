package com.site.admin.controller;

import java.util.Map;

import com.site.admin.service.AdminService;
import com.site.admin.model.AdminMemberListVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.site.member.service.MemberService;
import com.site.member.model.MemberVo;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private final AdminService adminService;
	private final MemberService memberService;

	public AdminController(AdminService adminService, MemberService memberService) {
		this.adminService = adminService;
		this.memberService = memberService;
	}

	// 멤버 목록 페이지
	@GetMapping("/member/list")
	public String memberList() {
		return "/admin/member/list";
	}

	// 멤버 목록 조회
	@PostMapping("/member/list")
	@ResponseBody
	public void memberList(AdminMemberListVo memberListVo, Model model) {
		model.addAttribute("memberListMap", adminService.memberList(memberListVo));
	}

	// 멤버 수정 페이지
	@GetMapping("/member/modify")
	public String updateMember(@RequestParam String id, Model model) {
		MemberVo memberVo = memberService.findMemberInfo(id);
		model.addAttribute(memberVo);
		return "/admin/member/modify";
	}

	// 멤버 수정
	@PostMapping("/member/modify")
	@ResponseBody
	public MemberVo updateMember(MemberVo memberVo) {
		return memberService.updateMemberInfo(memberVo);
	}

	// 멤버 아이디 중복검사
	// 중복일시 true 아닐시 false 반환
	@RequestMapping("/member/isDuplicatedId")
	@ResponseBody
	public boolean isDuplicatedMemberId(@RequestParam String id) {
		return memberService.isDuplicatedId(id);
	}

	// 멤버 삭제
	@RequestMapping("/member/delete")
	public String deleteMember(@RequestParam String id) {
		adminService.deleteMember(id);
		return "/admin/member/list";
	}

	// 주문 조회 //검색과 따로인것을 하나로 합침
	@GetMapping("/order/list")
	public String orderList(@RequestParam String datepicker1, @RequestParam String datepicker2, Model model) {
		Map<String, Object> orderView = adminService.orderSelectView(datepicker1,datepicker2);
		model.addAttribute("orderView", orderView);

		if(datepicker1.isEmpty() && datepicker2.isEmpty()) {
			model.addAttribute("datepicker1", datepicker1);
			model.addAttribute("datepicker2", datepicker2);
		}

		return "/admin/order/list";
	}
}
