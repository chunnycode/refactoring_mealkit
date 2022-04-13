package com.site.admin.service;

import com.site.admin.model.*;

import java.util.ArrayList;

public interface AdminService {

	int getMemberCount(AdminMemberRequestModel requestModel);
	ArrayList<MemberEntity> getMemberList(AdminMemberRequestModel requestModel);
	boolean deleteMember(AdminMemberRequestModel requestModel);

	ArrayList<OrderEntity> getOrderList(AdminOrderRequestModel requestModel);
	ArrayList<StatisticsEntity> getOrderStatistics(AdminOrderRequestModel requestModel);
	ArrayList<SummaryEntity> getOrderSummary(AdminOrderRequestModel requestModel);

}
