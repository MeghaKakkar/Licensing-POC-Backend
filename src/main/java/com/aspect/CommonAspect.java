package com.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;



/**
 * @author suraj.kumar2
 *
 */
@Aspect
@Component
public class CommonAspect {
	
	// advice for all the rest api calls 
	@Before("execution(public * com.controller.*.*(..))")
	public void beforeControllerAdvice(JoinPoint joinPoint) {
		System.out.println("user :- " + SecurityContextHolder.getContext().getAuthentication().getName() + "\n");
		System.out.println("executed method :- " + joinPoint + "\n");	
		Arrays.stream(joinPoint.getArgs()).forEach(arg -> System.out.println(arg.toString()));
	}
	
	// advice for all the services and repository 
	@Pointcut("execution(public * com.service.*.*(..)) || execution(public * com.repository.*.*(..))")
	public void beforeAdvice() {
		//noop
	}

	@Before("beforeAdvice()")
	public void beforeServiceAdvice(JoinPoint joinPoint) {
		System.out.println("executed method :- " + joinPoint + "\n");		
		
	}

}