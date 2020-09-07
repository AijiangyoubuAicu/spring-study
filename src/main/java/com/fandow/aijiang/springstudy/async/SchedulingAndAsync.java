package com.fandow.aijiang.springstudy.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * Spring 异步编程模型
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@Slf4j
@Component
@EnableAsync
@EnableScheduling
public class SchedulingAndAsync {
	
	/**
	 * 注入全局线程池 bean 实例
	 */
	@Bean(name = "global-executor")
	public ThreadPoolTaskExecutor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(50);
		executor.setMaxPoolSize(100);
		executor.setQueueCapacity(1000);
		executor.setKeepAliveSeconds(10);
		executor.initialize();
		log.info("全局线程池 global-executor 初始化完毕！");
		return executor;
	}

}
