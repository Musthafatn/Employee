package com.scg.employee.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AOPController {

	@Autowired
	@Qualifier("airtel")
	private SMSProvider smsProvider;

	@GetMapping("/sms")
	public String getSMS() {

		return smsProvider.sendSMS();

	}

}
