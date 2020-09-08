package com.fandow.aijiang.springstudy.validation.controller;

import com.fandow.aijiang.springstudy.validation.dto.RequestParamDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 校验器测试控制器
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("validator")
public class ValidatorController {
	
	@GetMapping("test")
	public void test(@Validated RequestParamDto requestParamDto) {
	
	}
	
}
