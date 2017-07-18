package cn.gqxqd.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	@Before("execution(* cn.gqxqd.service.*.*(..))")
	public void beforeProcess() {
		System.out.println("before....");
	}

	@After("execution(* cn.gqxqd.service.*.*(..))")
	public void aferProcess() {
		System.out.println("after....");
	}

	@Around("execution(* cn.gqxqd.service.*.*(..))")
	public Object aroundProcess(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("----around-before----");
		Object object = joinPoint.proceed();
		System.out.println("-----around-after----");
		return object;
	}

	@AfterReturning("execution(* cn.gqxqd.service.*.*(..))")
	public void afterReturning() {
		System.out.println("----afterReturning----");
	}
}