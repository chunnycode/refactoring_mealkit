package com.site.admin.mapper;

import java.util.ArrayList;

import com.site.admin.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {


	int CountMemberList(AdminMemberRequestModel requestModel);
	ArrayList<MemberEntity> getMemberList(AdminMemberRequestModel requestModel);
	void DeleteMember(String id);

	ArrayList<OrderEntity> selectOrderList(AdminOrderRequestModel requestModel);
	ArrayList<StatisticsEntity> selectOrderStatistics(AdminOrderRequestModel requestModel);
	ArrayList<SummaryEntity> selectOrderSummary(AdminOrderRequestModel requestModel);


}
