package com.site.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class SmsRequestDto {
	
	private String type, contentType, countryCode, from, content;
	private List<MessagesRequestDto> messages;

}
