package com.site.admin.controller;

import com.site.admin.model.AdminOrderRequestModel;
import com.site.admin.service.AdminService;
import com.site.admin.model.AdminMemberRequestModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.site.member.service.MemberService;
import com.site.member.model.MemberVo;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private final AdminService adminService;
	private final MemberService memberService;

	public AdminController(AdminService adminService, MemberService memberService) {
		this.adminService = adminService;
		this.memberService = memberService;
	}

	// 멤버 목록 조회
	@GetMapping("/member/list")
	public ModelAndView getMemberList(AdminMemberRequestModel requestModel) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/member/list");
		mav.addObject("memberList", adminService.getMemberList(requestModel));
		mav.addObject("memberCount", adminService.getMemberCount(requestModel));
		mav.addObject("adminMemberRequestModel", requestModel);
		return mav;
	}

	// 멤버 수정 페이지
	@GetMapping("/member/modify")
	public ModelAndView updateMember(@RequestParam String id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/member/modify");
		mav.addObject(memberService.findMemberInfo(id));
		return mav;
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

	// 주문 조회
	@GetMapping("/order/list")
	public ModelAndView orderList(AdminOrderRequestModel requestModel) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/order/list");
		mav.addObject("orderList", adminService.getOrderList(requestModel));
		mav.addObject("statistics", adminService.getOrderStatistics(requestModel));
		mav.addObject("summaryList", adminService.getOrderSummary(requestModel));
		mav.addObject("adminOrderRequestModel", requestModel);
		return mav;

	}
}
