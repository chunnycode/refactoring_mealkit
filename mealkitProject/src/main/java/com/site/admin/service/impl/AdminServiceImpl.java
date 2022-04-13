package com.site.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.site.admin.mapper.AdminMapper;
import com.site.admin.model.*;
import com.site.admin.service.AdminService;
import org.springframework.stereotype.Service;

import com.site.admin.model.MemberVo;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public int getMemberCount(AdminMemberRequestModel adminMemberRequestModel){
        return adminMapper.CountMemberList(
                adminMemberRequestModel.getCategory()
                , adminMemberRequestModel.getOrder()
                , adminMemberRequestModel.getSearchWord());
    }

    @Override
    public ArrayList<MemberVo> getMemberList(AdminMemberRequestModel adminMemberRequestModel) {
        return adminMapper.getMemberList(
                adminMemberRequestModel.getLimit()
                , adminMemberRequestModel.getOffset()
                , adminMemberRequestModel.getCategory()
                , adminMemberRequestModel.getOrder()
                , adminMemberRequestModel.getSearchWord());
    }

    //	회원정보 삭제
    @Override
    public void deleteMember(String id) {
        adminMapper.DeleteMember(id);
    }

    // 주문 목록 조회
    @Override
    public ArrayList<OrderVo> getOrderList(AdminOrderRequestModel requestModel) {
        return adminMapper.selectOrderList(requestModel.getStartDate(), requestModel.getEndDate());

    }

    // 통계 조회
    @Override
    public ArrayList<StatisticsVo> getOrderStatistics(AdminOrderRequestModel requestModel){
        return adminMapper.selectOrderStatistics(requestModel.getStartDate(), requestModel.getEndDate());
    }

    // 요약정보 조회
    @Override
    public ArrayList<SummaryVo> getOrderSummary(AdminOrderRequestModel requestModel){
        return adminMapper.selectOrderSummary(requestModel.getStartDate(), requestModel.getEndDate());
    }

}
