package com.scg.employee.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
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

	@Around("@annotation(ExecutionTime)")
	public Object computeExecutionTime(final ProceedingJoinPoint joinPoint) throws Throwable {
//		StopWatch s=new StopWatch();
//		s.start();
		final long start = System.currentTimeMillis();
		final Object proceed = joinPoint.proceed();
		final long executionTime = System.currentTimeMillis() - start;
		final String message = joinPoint.getSignature().getName() + " executed in " + executionTime + " ms";
//		s.stop();
//		s.getTotalTimeMillis();
		log.info(message);
		return proceed;
	}

}
