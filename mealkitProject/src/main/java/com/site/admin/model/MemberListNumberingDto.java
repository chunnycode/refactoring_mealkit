package com.site.admin.model;

import lombok.Getter;

@Getter
public class MemberListNumberingDto {
    private AdminMemberListVo memberListVo;
    private int listCount;
    private int limit;
    private int numLimit;
    private int maxPage;
    private int startPage;
    private int endPage;
    private int startRow;
    private int endRow;

    public MemberListNumberingDto(AdminMemberListVo memberListVo, int listCount, int limit, int numLimit) {
        this.memberListVo = memberListVo;
        this.listCount = listCount;
        this.limit = limit;
        this.numLimit = numLimit;

        maxPage = (int)((double)listCount/limit + 0.9);
        startPage = (((int)((double)memberListVo.getPage() / numLimit+0.9999)) - 1) * numLimit + 1;
        endPage = startPage+numLimit-1;

        if (endPage>maxPage){
            endPage = maxPage;
        }

        startRow = (memberListVo.getPage()-1) * limit + 1;
        endRow = startRow + limit - 1;
    }
}
