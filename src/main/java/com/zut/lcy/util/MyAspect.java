package com.zut.lcy.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect  //表示当前类为切面
public class MyAspect {
	
	//定义了一个切入点，叫doThirdPointcut()
	@Pointcut("execution(* *..ConferenceServiceImpl.conference(..))")
	public void doThirdPointcut(){}
	
	@Before("execution(* *..ConferenceServiceImpl.conference(..))")
	public void doBefore(JoinPoint joinPoint){
		System.out.println("前置通知");
	}
	
	@After("execution(* *..ConferenceServiceImpl.conference(..))")
	public void doAfter(JoinPoint joinPoint){
		System.out.println("后置通知");
	}
	
	@Around("execution(* *..ConferenceServiceImpl.conference(..))")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("环绕通知，调用环绕方法前...");
		//核心逻辑
		Object retval=pjp.proceed();
		System.out.println("环绕通知，调用环绕方法后...");
		return retval;
	}
	
	@AfterThrowing(value="execution(* *..ConferenceServiceImpl.conference(..))", throwing="e")
	public void doThrowing(JoinPoint joinPoint,Exception e){
		System.out.println("异常通知");  
        System.out.println(" 错误信息："+e.getMessage());    
	}

}
