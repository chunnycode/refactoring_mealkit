package com.site.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class SendSmsResponseDto {
	
	private String statusCode, statusName, requestId;
	private Timestamp requestTime;

}
