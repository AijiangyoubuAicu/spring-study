package com.fandow.aijiang.springstudy.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 后置通知切面
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@Slf4j
@Component
@Aspect
public class BeforeAspect {
	
	/**
	 * 为包下的每个方法定义切入点
	 */
	@Pointcut("execution(public * com.fandow.aijiang.springstudy.aop.controller.*.*(..))")
	public void pointcut() {}
	
	/**
	 * 切面方法
	 */
	@After("pointcut()")
	public void after() {
		log.info("后置方法运行！");
	}
	
}
