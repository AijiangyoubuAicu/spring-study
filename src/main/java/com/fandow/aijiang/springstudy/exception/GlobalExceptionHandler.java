package com.fandow.aijiang.springstudy.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局业务异常处理
 *
 * @author 梁业锦
 * @since 2020-08-15
 */
@Slf4j
@Component
@ControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * 全局空指针异常处理
	 */
	@ExceptionHandler(value = NullPointerException.class)
	public void nullPointerExceptionHandler() {
		System.err.println("=======");
		System.err.println("方法发生了空指针!!!!");
	}
	
}
