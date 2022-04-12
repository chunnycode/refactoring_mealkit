package com.site.admin.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.site.admin.model.ChartVo;
import com.site.member.model.MemberVo;

@Mapper
public interface AdminMapper {

//	회원정보 리스트 카운트
	int CountMemberList(String category, String order, String searchWord);

//	회원정보 리스트 출력
	ArrayList<MemberVo> memberList(int startRow, int endRow, String category, String order, String searchWord);

//	회원정보 삭제
	int DeleteMember(String id);

//	챠트
	ArrayList<ChartVo> orderView();

//	합계 리스트
	ArrayList<ChartVo> tableList();

//	합계 서머리
	ArrayList<ChartVo> tableSummary();
	
//	검색부분
	//당일
	ArrayList<ChartVo> orderSelectView(String datepicker1, String datepicker2);
	ArrayList<ChartVo> tableSelectList(String datepicker1, String datepicker2);
	ArrayList<ChartVo> tableSelectSummary(String datepicker1, String datepicker2);

	//1주일
	ArrayList<ChartVo> orderSelectWeekView(String datepicker1, String datepicker2);

	//1개월
	ArrayList<ChartVo> orderSelectOmonthView(String datepicker1, String datepicker2);

	//3개월
	ArrayList<ChartVo> orderSelectTmonthView(String datepicker1, String datepicker2);

	//12개월
	ArrayList<ChartVo> orderSelectTwsmonthView(String datepicker1, String datepicker2);
}
