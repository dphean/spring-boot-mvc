package com.dmp.demo.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ControllerMonitor {
	private final static Log log = LogFactory.getLog(ControllerMonitor.class);
	
	@AfterReturning("execution(* com.dmp..*Controller.*(..))")
	public void logControllerAccess(JoinPoint joinPoint) {
		log.info("Completed: " + joinPoint);
	}

}
