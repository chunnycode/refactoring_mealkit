package com.site.noticeboard.model;


import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeBoardVo {
	private int id;
	private String ntitle;
	private String ncontent;
	private Timestamp ndate;
	private String nupload;
	private int nhit;
	private String sdate; // 이벤트 개시일
	private String edate; // 이벤트 종료일
	
}
