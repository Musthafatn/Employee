package com.scg.employee.aop;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("airtel")
public class Airtel implements SMSProvider {

	@Override
	public String sendSMS() {
		log.info("Airtel");
		return "Airtel";
	}

}
