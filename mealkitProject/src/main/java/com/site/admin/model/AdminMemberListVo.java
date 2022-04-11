package com.site.admin.model;

import lombok.Getter;

@Getter
public class AdminMemberListVo {
    private int page;
    private String category;
    private String order;
    private String searchWord;
}
