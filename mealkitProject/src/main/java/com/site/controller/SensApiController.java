package com.site.controller;

import com.site.sms.sms.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sensApi")
public class SensApiController {

	@Autowired
	private SmsService smsService;

	@RequestMapping("/smsCerti")
	@ResponseBody
	public String sensApi(@RequestParam String tel) throws Exception {
		String code = getCreateKey();
		smsService.sendSms(tel, code);
		return code;
	}

//	랜덤 숫자 만들기
	public String getCreateKey() {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		String code = "";
		int idx = 0;
		for (int i = 0; i < 6; i++) {
			idx = (int) (charSet.length * Math.random());
			code += charSet[idx];
		}
		return code;
	}

}
