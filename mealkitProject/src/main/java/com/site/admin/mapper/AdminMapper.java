package com.site.admin.mapper;

import java.util.ArrayList;

import com.site.admin.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {


	int CountMemberList(AdminMemberRequestModel requestModel);
	ArrayList<MemberVo> getMemberList(AdminMemberRequestModel requestModel);
	void DeleteMember(String id);

	ArrayList<OrderVo> selectOrderList(AdminOrderRequestModel requestModel);
	ArrayList<StatisticsVo> selectOrderStatistics(AdminOrderRequestModel requestModel);
	ArrayList<SummaryVo> selectOrderSummary(AdminOrderRequestModel requestModel);


}
