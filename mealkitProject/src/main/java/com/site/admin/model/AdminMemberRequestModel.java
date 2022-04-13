package com.site.admin.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminMemberRequestModel {
    private int page;
    private String category;
    private String order;
    private String searchWord;

    private String id;

    private int limit = 20;
    private int offset;
    private int numLimit = 5;

}
