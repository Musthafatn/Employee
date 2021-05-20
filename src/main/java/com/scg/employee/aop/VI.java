package com.scg.employee.aop;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Primary
@Component("vi")
public class VI implements SMSProvider {

	@Override
	public String sendSMS() {

		log.info("vi");
		return "vi";
	}

}
