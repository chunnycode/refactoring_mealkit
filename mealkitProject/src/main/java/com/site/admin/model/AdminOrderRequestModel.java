package com.site.admin.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminOrderRequestModel {
    private int page;
    private String startDate;
    private String endDate;
    private String searchWord;

    private int limit = 20;
    private int offset;
    private int numLimit = 5;

}
