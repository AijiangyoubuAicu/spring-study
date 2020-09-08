package com.fandow.aijiang.springstudy.async.concurrent;

import com.fandow.aijiang.springstudy.async.pool.GlobalThreadPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * Spring 提供的异步编程方法
 *
 * @author Admin
 * @version 1.0
 */
@Slf4j
@Service
public class AsyncService {
	
	/**
	 * 注入全局线程池并使用
	 */
	@Resource
	private GlobalThreadPool globalThreadPool;
	
	/**
	 * 使用 @Async 将方法执行异步化
	 */
	@Async
	public void async() {
		log.info("==========异步方法 async() 开始执行===========");
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("---------异步方法 async() 执行完毕------------");
	}
	
	/**
	 * 声明 Future<> 返回值，可用于阻塞等待异步方法执行完毕
	 *
	 * @return 返回值
	 */
	@Async
	public Future<String> future() {
		log.info("==========异步方法 future() 开始执行===========");
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("---------异步方法 future() 执行完毕------------");
		return new AsyncResult<>("异步方法执行完了啦！！");
	}
	
	/**
	 * 使用传统的 Runnable 接口实现异步逻辑，并将有全局线程池运行
	 */
	public void runnable() {
		log.info("==========异步方法 runnable() 已执行==========");
		Runnable runnable = () -> {
			try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			log.info("---------异步方法 runnable() 已执行---------");
		};
		globalThreadPool.asyncExecutor().execute(runnable);
	}
	
}
