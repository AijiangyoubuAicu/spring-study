package com.fandow.aijiang.springstudy.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 前置通知切面
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@Component
@Slf4j
@Aspect
public class AfterAspect {
	
	/**
	 * 以注解的方式定义切入点
	 */
	@Pointcut("@annotation(com.fandow.aijiang.springstudy.aop.annotations.Before)")
	public void pointcut() {}
	
	/**
	 * 以前置的方式执行切面方法
	 */
	@Before("pointcut()")
	public void method() {
		log.info("前置通知了！！！！！");
	}
	
}
