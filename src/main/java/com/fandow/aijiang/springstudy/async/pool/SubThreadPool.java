package com.fandow.aijiang.springstudy.async.pool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * 全局线程池
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@Slf4j
@Component
public class SubThreadPool {
	
	/**
	 * 注入全局线程池 bean 实例
	 */
	@Bean(name = "sub-executor")
	public ThreadPoolTaskExecutor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(50);
		executor.setMaxPoolSize(100);
		executor.setQueueCapacity(1000);
		executor.setKeepAliveSeconds(10);
		executor.initialize();
		log.info("全局线程池 sub-executor 初始化完毕！");
		return executor;
	}
	
}
