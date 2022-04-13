package com.site.admin.mapper;

import java.util.ArrayList;

import com.site.admin.model.OrderVo;
import com.site.admin.model.StatisticsVo;
import com.site.admin.model.SummaryVo;
import org.apache.ibatis.annotations.Mapper;
import com.site.admin.model.MemberVo;

@Mapper
public interface AdminMapper {


	int CountMemberList(String category, String order, String searchWord);
	ArrayList<MemberVo> getMemberList(int startRow, int endRow, String category, String order, String searchWord);
	void DeleteMember(String id);

	ArrayList<OrderVo> selectOrderList(String datepicker1, String datepicker2);
	ArrayList<StatisticsVo> selectOrderStatistics(String datepicker1, String datepicker2);
	ArrayList<SummaryVo> selectOrderSummary(String datepicker1, String datepicker2);


}
