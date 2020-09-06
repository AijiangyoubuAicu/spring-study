package com.fandow.aijiang.springstudy.aop.controller;

import com.fandow.aijiang.springstudy.aop.annotations.Before;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AOP 测试
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("aop")
public class AopController {
	
	@Before
	@GetMapping("before")
	public void beforeTest() {
		log.info("在注解的输出执行之前----");
	}
	
	@GetMapping("after")
	public void afterTest() {
		log.info("在注解的输出执行之后=====");
	}
	
}
