package com.site.admin.model;

import lombok.Getter;

@Getter
public class MemberVo {
    private int id;
    private String memberId;
    private String memberName;
    private String nickName;
    private String dob;
    private String gender;
    private String addr;
    private String addr1;
    private String email;
    private String tel;
    private int smsAgree;
    private int emailAgree;
    private int point;
    private int rank;
    private String pictureUrl;
}
