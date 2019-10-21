package com.zut.lcy.util;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("环绕通知，调用环绕方法前...");
		Object object=invocation.proceed();
		System.out.println("环绕通知，调用环绕方法后...");
		return null;
	}

}
