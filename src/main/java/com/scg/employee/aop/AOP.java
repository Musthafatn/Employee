package com.scg.employee.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class AOP {

	@Before("execution(public String getSMS())")
	public void beforeSendSMS() {

		log.info("Sending SMS");

	}

	@After("execution(public String getSMS())")
	public void afterSendSMS() {

		log.info("SMS send");

	}

}
