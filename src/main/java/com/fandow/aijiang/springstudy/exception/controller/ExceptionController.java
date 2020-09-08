package com.fandow.aijiang.springstudy.exception.controller;

import com.fandow.aijiang.springstudy.async.pool.SubThreadPool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常控制器测试
 *
 * @author Admin
 * @version 1.0
 */
@RestController
@RequestMapping("exception")
public class ExceptionController {
	
	private SubThreadPool schedulingAndAsync;
	
	@GetMapping("test")
	public void exceptionHandler() {
		System.out.println(schedulingAndAsync);
		schedulingAndAsync.toString();
		schedulingAndAsync.asyncExecutor();
	}
}
