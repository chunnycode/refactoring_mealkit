package com.site.admin.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class SummaryEntity {

	//Summary & List 용
	private int refundAmount;
	private int refundPrice;
	
	private String name;
	private int totalAmount;
	private int totalPrice;
	
	private String refund_flag;

	private String month, year;
	
	private String product_name;
	private int amount; 
	private int quantity; 
	
	private int day;
	private int week;

}
