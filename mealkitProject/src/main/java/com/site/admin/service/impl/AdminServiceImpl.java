package com.site.admin.service.impl;

import java.util.ArrayList;

import com.site.admin.mapper.AdminMapper;
import com.site.admin.model.*;
import com.site.admin.service.AdminService;
import org.springframework.stereotype.Service;

import com.site.admin.model.MemberEntity;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public int getMemberCount(AdminMemberRequestModel adminMemberRequestModel){
        return adminMapper.CountMemberList(adminMemberRequestModel);
    }

    @Override
    public ArrayList<MemberEntity> getMemberList(AdminMemberRequestModel adminMemberRequestModel) {
        return adminMapper.getMemberList(adminMemberRequestModel);
    }

    //	회원정보 삭제
    @Override
    public boolean deleteMember(AdminMemberRequestModel requestModel) {
        try {
            adminMapper.DeleteMember(requestModel.getId()); // TODO xml 에서 update로 바꾸고 삭제관련 데이터 삽입
            return true;
        } catch (Exception e){
            return false;
        }
    }

    // 주문 목록 조회
    @Override
    public ArrayList<OrderEntity> getOrderList(AdminOrderRequestModel requestModel) {
        return adminMapper.selectOrderList(requestModel);

    }

    // 통계 조회
    @Override
    public ArrayList<StatisticsEntity> getOrderStatistics(AdminOrderRequestModel requestModel){
        return adminMapper.selectOrderStatistics(requestModel);
    }

    // 요약정보 조회
    @Override
    public ArrayList<SummaryEntity> getOrderSummary(AdminOrderRequestModel requestModel){
        return adminMapper.selectOrderSummary(requestModel);
    }

}
