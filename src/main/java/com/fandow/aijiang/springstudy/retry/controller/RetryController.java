package com.fandow.aijiang.springstudy.retry.controller;

import com.fandow.aijiang.springstudy.retry.service.RetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 重试测试控制器
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("retry")
public class RetryController {
	
	@Resource
	private RetryService retryService;
	
	@GetMapping("test")
	public void test() {
		retryService.retry();
	}

}
