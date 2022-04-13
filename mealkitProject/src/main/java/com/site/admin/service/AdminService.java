package com.site.admin.service;

import com.site.admin.model.*;

import java.util.ArrayList;

public interface AdminService {

	int getMemberCount(AdminMemberRequestModel requestModel);
	ArrayList<MemberVo> getMemberList(AdminMemberRequestModel requestModel);
	void deleteMember(String id);

	ArrayList<OrderVo> getOrderList(AdminOrderRequestModel requestModel);
	ArrayList<StatisticsVo> getOrderStatistics(AdminOrderRequestModel requestModel);
	ArrayList<SummaryVo> getOrderSummary(AdminOrderRequestModel requestModel);

}
