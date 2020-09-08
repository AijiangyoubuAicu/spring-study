package com.fandow.aijiang.springstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring 启动类
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@EnableRetry
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class SpringStudyApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringStudyApplication.class, args);
	}
	
}
