package com.site.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.site.admin.dao.AdminDao;
import com.site.admin.model.MemberListNumberingDto;
import com.site.admin.model.AdminMemberListVo;
import com.site.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.admin.model.ChartVo;
import com.site.member.model.MemberVo;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public Map<String, Object> memberList(AdminMemberListVo adminMemberListVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int listCount = adminDao.CountMemberList(
				adminMemberListVo.getCategory()
				,adminMemberListVo.getOrder()
				,adminMemberListVo.getSearchWord());

		MemberListNumberingDto numberingDto = new MemberListNumberingDto(
				adminMemberListVo
				,listCount
				,20
				,5);
		
		ArrayList<MemberVo> list = adminDao.memberList(
				numberingDto.getStartRow()
				,numberingDto.getEndRow()
				,adminMemberListVo.getCategory()
				,adminMemberListVo.getOrder()
				,adminMemberListVo.getSearchWord());

		if(list.isEmpty()) {
			map.put("flag", 1);
		}

		map.put("listCount", listCount);
		map.put("page", adminMemberListVo.getPage());
		map.put("maxPage", numberingDto.getMaxPage());
		map.put("startPage", numberingDto.getStartPage());
		map.put("endPage", numberingDto.getEndPage());
		map.put("list", list);
		map.put("category", adminMemberListVo.getCategory());
		map.put("order", adminMemberListVo.getOrder());
		map.put("searchWord", adminMemberListVo.getSearchWord());
		
		return map;
	}

//	회원정보 삭제
	@Override
	public int deleteMember(String id) {
		int result = adminDao.DeleteMember(id);
		return result;
	} 
	//차트
	@Override
	public Map<String, Object> orderView() {
		Map<String, Object> orderView = new HashMap<String, Object>();
		ArrayList<ChartVo> list = adminDao.orderView();
		ArrayList<ChartVo> tableList = adminDao.tableList();
		ArrayList<ChartVo> tableSummary = adminDao.tableSummary();
		orderView.put("list", list);
		orderView.put("tableList", tableList);
		orderView.put("tableSummary", tableSummary);
		return orderView;
	}
	//검색부분
	@Override
	public Map<String, Object> orderSelectView(String datepicker1, String datepicker2) {
		Map<String, Object> orderView = new HashMap<String, Object>();
		//비교해야해서 int형으로 바꿔줌
		int a = Integer.parseInt(datepicker1);
		int b = Integer.parseInt(datepicker2);
		//당일 ㄱㄱ
		if(a == b) {
			//비교했으니 다시 String 으로 바꿔줌
			datepicker1 = String.valueOf(a);
			datepicker2 = String.valueOf(b);
			//바꿔줬으니 다시 날짜중간에 - 넣음 
			datepicker1 = datepicker1.substring(0,4)+"-"+datepicker1.substring(4,datepicker1.length());
			datepicker1 = datepicker1.substring(0,7)+"-"+datepicker1.substring(7,datepicker1.length());
			datepicker2 = datepicker2.substring(0,4)+"-"+datepicker2.substring(4,datepicker2.length());
			datepicker2 = datepicker2.substring(0,7)+"-"+datepicker2.substring(7,datepicker2.length());
			//당일
			ArrayList<ChartVo> list = adminDao.orderSelectView(datepicker1,datepicker2);
			ArrayList<ChartVo> tableList = adminDao.tableSelectList(datepicker1,datepicker2);
			ArrayList<ChartVo> tableSummary = adminDao.tableSelectSummary(datepicker1,datepicker2);
			orderView.put("list", list);
			orderView.put("tableList", tableList);
			orderView.put("tableSummary", tableSummary);
			System.out.println("당일까지의 매출");
			return orderView;
			}//if
		
		//1주일 ㄱㄱ
		if(b-a <= 7 && b-a > 0){
			//비교했으니 다시 String 으로 바꿔줌
			datepicker1 = String.valueOf(a);
			datepicker2 = String.valueOf(b);
			//바꿔줬으니 다시 날짜중간에 - 넣음 
			datepicker1 = datepicker1.substring(0,4)+"-"+datepicker1.substring(4,datepicker1.length());
			datepicker1 = datepicker1.substring(0,7)+"-"+datepicker1.substring(7,datepicker1.length());
			datepicker2 = datepicker2.substring(0,4)+"-"+datepicker2.substring(4,datepicker2.length());
			datepicker2 = datepicker2.substring(0,7)+"-"+datepicker2.substring(7,datepicker2.length());
			//1주일
			ArrayList<ChartVo> list = adminDao.orderSelectWeekView(datepicker1,datepicker2);
			ArrayList<ChartVo> tableList = adminDao.tableSelectList(datepicker1,datepicker2);
			ArrayList<ChartVo> tableSummary = adminDao.tableSelectSummary(datepicker1,datepicker2);
			orderView.put("list", list);
			orderView.put("tableList", tableList);
			orderView.put("tableSummary", tableSummary);
			System.out.println("최근1주일까지의 매출");
			return orderView;
		//1개월 ㄱㄱ
		}if(b-a <= 100 && b-a > 7) {
			//비교했으니 다시 String 으로 바꿔줌
			datepicker1 = String.valueOf(a);
			datepicker2 = String.valueOf(b);
			//바꿔줬으니 다시 날짜중간에 - 넣음 
			datepicker1 = datepicker1.substring(0,4)+"-"+datepicker1.substring(4,datepicker1.length());
			datepicker1 = datepicker1.substring(0,7)+"-"+datepicker1.substring(7,datepicker1.length());
			datepicker2 = datepicker2.substring(0,4)+"-"+datepicker2.substring(4,datepicker2.length());
			datepicker2 = datepicker2.substring(0,7)+"-"+datepicker2.substring(7,datepicker2.length());
			//1개월
			ArrayList<ChartVo> list = adminDao.orderSelectOmonthView(datepicker1,datepicker2);
			ArrayList<ChartVo> tableList = adminDao.tableSelectList(datepicker1,datepicker2);
			ArrayList<ChartVo> tableSummary = adminDao.tableSelectSummary(datepicker1,datepicker2);
			orderView.put("list", list);
			orderView.put("tableList", tableList);
			orderView.put("tableSummary", tableSummary);
			System.out.println("최근1개월까지의 매출");
			return orderView;
		//3개월 ㄱㄱ
		}if(b-a <= 300 && b-a > 100) {
			//비교했으니 다시 String 으로 바꿔줌
			datepicker1 = String.valueOf(a);
			datepicker2 = String.valueOf(b);
			//바꿔줬으니 다시 날짜중간에 - 넣음 
			datepicker1 = datepicker1.substring(0,4)+"-"+datepicker1.substring(4,datepicker1.length());
			datepicker1 = datepicker1.substring(0,7)+"-"+datepicker1.substring(7,datepicker1.length());
			datepicker2 = datepicker2.substring(0,4)+"-"+datepicker2.substring(4,datepicker2.length());
			datepicker2 = datepicker2.substring(0,7)+"-"+datepicker2.substring(7,datepicker2.length());
			//3개월
			ArrayList<ChartVo> list = adminDao.orderSelectTmonthView(datepicker1,datepicker2);
			ArrayList<ChartVo> tableList = adminDao.tableSelectList(datepicker1,datepicker2);
			ArrayList<ChartVo> tableSummary = adminDao.tableSelectSummary(datepicker1,datepicker2);
			orderView.put("list", list);
			orderView.put("tableList", tableList);
			orderView.put("tableSummary", tableSummary);
			System.out.println("최근3개월까지의 매출");
			return orderView;
		//12개월 ㄱㄱ
		}if(b-a <= 10000 && b-a > 300) {
			//비교했으니 다시 String 으로 바꿔줌
			datepicker1 = String.valueOf(a);
			datepicker2 = String.valueOf(b);
			//바꿔줬으니 다시 날짜중간에 - 넣음 
			datepicker1 = datepicker1.substring(0,4)+"-"+datepicker1.substring(4,datepicker1.length());
			datepicker1 = datepicker1.substring(0,7)+"-"+datepicker1.substring(7,datepicker1.length());
			datepicker2 = datepicker2.substring(0,4)+"-"+datepicker2.substring(4,datepicker2.length());
			datepicker2 = datepicker2.substring(0,7)+"-"+datepicker2.substring(7,datepicker2.length());
			//12개월
			ArrayList<ChartVo> list = adminDao.orderSelectTwsmonthView(datepicker1,datepicker2);
			ArrayList<ChartVo> tableList = adminDao.tableSelectList(datepicker1,datepicker2);
			ArrayList<ChartVo> tableSummary = adminDao.tableSelectSummary(datepicker1,datepicker2);
			orderView.put("list", list);
			orderView.put("tableList", tableList);
			orderView.put("tableSummary", tableSummary);
			System.out.println("최근12개월까지의 매출");
			return orderView;
		}
		return orderView;
	}//Map public

}
