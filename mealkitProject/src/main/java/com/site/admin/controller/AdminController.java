package com.site.admin.controller;

import java.util.Map;

import com.site.admin.service.AdminService;
import com.site.admin.model.AdminMemberListVo;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private MemberService memberService;
	
//	회원정보리스트
	@GetMapping("/memberList")
	public String memberList() {
		return "/admin/member_list";
	}
	
	@PostMapping("/memberList")
	@ResponseBody
	public void memberList(AdminMemberListVo memberListVo, Model model){
		model.addAttribute("memberListMap", adminService.memberList(memberListVo));
	}
//	회원정보 수정
	@GetMapping("/memberUpdate")
	public String updateMember(@RequestParam String id, Model model) {
		MemberVo memberVo = memberService.findMemberInfo(id);
		model.addAttribute(memberVo);
		return "/admin/memberUpdate";
	}
	
	@PostMapping("/memberUpdate")
	@ResponseBody
	public int updateMember(MemberVo memberVo) {
		return memberService.updateMemberInfo(memberVo);
	}
	
//	회원정보 수정 아이디 체크
	@RequestMapping("/memberCheckId")
	@ResponseBody
	public int checkMemberId(@RequestParam String id) {
		return memberService.checkRegisterId(id);
	}
	
//	회원정보 삭제
	@RequestMapping("/memberDelete")
	public String deleteMember(@RequestParam String id) {
		adminService.deleteMember(id);
		return "/admin/memberList";
	}

//	챠트
	@GetMapping("/chart")
	public String chart(Model model) {
		Map<String, Object> orderView = adminService.orderView();
		model.addAttribute("orderView", orderView);
		return "/admin/chart";
	}
//	검색부분
	@PostMapping("/Search")
	public String Search(@RequestParam String datepicker1,
						@RequestParam String datepicker2,
						Model model) {
		Map<String, Object> orderView = adminService.orderSelectView(datepicker1,datepicker2);
		model.addAttribute("orderView", orderView);
		model.addAttribute("datepicker1",datepicker1);
		model.addAttribute("datepicker2",datepicker2);
		
		return "/admin/chart";
	}
}
