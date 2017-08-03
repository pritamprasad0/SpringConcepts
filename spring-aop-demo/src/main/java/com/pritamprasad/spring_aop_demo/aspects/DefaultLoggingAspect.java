package com.pritamprasad.spring_aop_demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DefaultLoggingAspect {

	/**
	 * Following is the definition for a PointCut to select all the methods
	 * available. So advice will be called for all the methods.
	 */
	@Pointcut("execution(* com.pritamprasad.spring_aop_demo.service.*.*(..))")
	private void selectAll() {
	}

	// /**
	// * This is the method which I would like to execute before a selected method
	// * execution.
	// */
	// @Before("selectAll()")
	// public void beforeAdvice2() {
	// System.out.println("******* Before advice being called");
	// }
	//
	// @After("selectAll()")
	// public void afterAdvice2() {
	// System.out.println("******* After advice being called");
	// }

	@Around("selectAll()")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("Around advice");
		Object[] args = proceedingJoinPoint.getArgs();
		if (args.length > 0) {
			System.out.println("Arguments passed: ");
			for (int i = 0; i < args.length; i++) {
				System.out.println("arg " + (i + 1) + ": " + args[i]);
			}
		}

		Object result = proceedingJoinPoint.proceed(args);
		System.out.println("Returning " + result);
		return result;
	}

	/**
	 * This is the method which I would like to execute before a selected method
	 * execution.
	 */
	public void beforeAdvice() {
		System.out.println("Going to execute method");
	}

	/**
	 * This is the method which I would like to execute after a selected method
	 * execution.
	 */
	public void afterAdvice() {
		System.out.println("Method executed");
	}

	/**
	 * This is the method which I would like to execute when any method returns.
	 */
	public void afterReturningAdvice(Object retVal) {
		System.out.println("Returning:" + retVal.toString());
	}

	/**
	 * This is the method which I would like to execute if there is an exception
	 * raised.
	 */
	public void AfterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("There has been an exception: " + ex.toString());
	}
}
