package com.fandow.aijiang.springstudy.retry.service.impl;

import com.fandow.aijiang.springstudy.retry.service.RetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Retry 重试服务层实现类
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@Slf4j
@Service
public class RetryServiceImpl implements RetryService {
	
	@Override
	@Retryable(value = {RemoteAccessException.class}, maxAttempts = 4,
			backoff = @Backoff(delay = 1000L, multiplier = 2))
	public void retry() {
		log.info("抛出异常，即将重试，当前时间={}", new Date());
		throw new RemoteAccessException("网络请求发生了异常");
	}
	
	/**
	 * 重试失败后的逻辑
	 */
	@Recover
	public void recover(RemoteAccessException e) {
		log.error("重试结束", e);
	}
	
}
