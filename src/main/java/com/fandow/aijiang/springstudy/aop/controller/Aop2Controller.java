package com.fandow.aijiang.springstudy.aop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("aop2")
public class Aop2Controller {
	
	@GetMapping("test")
	public void test() {
		log.info("这只是一个 aop 的测试方法，检测是否已扫描到所有的包！");
	}
}
