package com.site.admin.service;

import com.site.admin.model.*;

import java.util.ArrayList;

public interface AdminService {

	int getMemberCount(AdminMemberRequestModel adminMemberRequestModel);
	ArrayList<MemberVo> getMemberList(AdminMemberRequestModel adminMemberRequestModel);
	void deleteMember(String id);

	ArrayList<OrderVo> getOrderList(String startDate, String endDate);
	ArrayList<StatisticsVo> getOrderStatistics(String startDate, String endDate);
	ArrayList<SummaryVo> getOrderSummary(String startDate, String endDate);

}
