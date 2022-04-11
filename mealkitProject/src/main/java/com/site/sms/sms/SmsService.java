package com.site.sms.sms;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.site.dto.MessagesRequestDto;
import com.site.dto.SendSmsResponseDto;
import com.site.dto.SmsRequestDto;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SmsService {

	public SendSmsResponseDto sendSms(String recipientPhoneNumber, String content) throws Exception {
		
		Long time = new Date().getTime();
		List<MessagesRequestDto> messages = new ArrayList<>();
		
		messages.add(new MessagesRequestDto(recipientPhoneNumber, content));
		
		SmsRequestDto smsRequestDto = new SmsRequestDto("SMS", "COMM", "82", "", "MangoLtd", messages);
		
//		ObjectMapper objectMapper = new ObjectMapper();
//		String jsonBody = objectMapper.writeValueAsString(smsRequestDto);
		String jsonBody = smsRequestDto.toString();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("x-ncp-apigw-timestamp", time.toString());
		headers.set("x-ncp-iam-access-key", "l7rO1H27iskRil8waplE");
		
		String sig = makeSignature(time);
		headers.set("x-ncp-apigw-signature-v2", sig);
		
		HttpEntity<String> body = new HttpEntity<String>(jsonBody, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		SendSmsResponseDto sendSmsResponseDto = restTemplate.postForObject(new URI("https://sens.apigw.ntruss.com/sms/v2/services/ncp:sms:kr:270824078609:smscerti/messages"), body, SendSmsResponseDto.class);
		
		return sendSmsResponseDto;
	}
	
	public String makeSignature(Long time) throws Exception {
		String space = " ";					// one space
		String newLine = "\n";					// new line
		String method = "POST";					// method
		String url = "/sms/v2/services/ncp:sms:kr:270824078609:smscerti/messages";	// url (include query string)
		String timestamp = time.toString();			// current timestamp (epoch)
		String accessKey = "l7rO1H27iskRil8waplE";			// access key id (from portal or sub account)
		String secretKey = "mv1Ad2fyfKogDDHvEQ9yka61tkAO1eFvWmgLLQ7Y";

		String message = new StringBuilder()
			.append(method)
			.append(space)
			.append(url)
			.append(newLine)
			.append(timestamp)
			.append(newLine)
			.append(accessKey)
			.toString();

		SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(signingKey);

		byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
		String encodeBase64String = Base64.encodeBase64String(rawHmac);

	  return encodeBase64String;
	}


}
