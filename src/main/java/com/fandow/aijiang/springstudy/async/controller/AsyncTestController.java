package com.fandow.aijiang.springstudy.async.controller;

import com.fandow.aijiang.springstudy.async.concurrent.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Spring 异步方法测试控制器
 *
 * @author Admin
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("async")
public class AsyncTestController {
	
	@Resource
	private AsyncService asyncService;
	
	/**
	 * 传统 Runnable 方法异步测试
	 */
	@GetMapping("runnable")
	public void runnable() {
		log.info("线程池任务开始执行了！");
		asyncService.runnable();
		log.info("此处不阻塞，说明方法已经异步化，等待三秒后输出的日志:");
	}
	
	/**
	 * Spring 异步注解 @Async 方法测试
	 */
	@GetMapping("async")
	public void async() {
		log.info("线程池任务开始执行了！");
		asyncService.async();
		log.info("此处不阻塞，说明方法已经异步化，等待三秒后输出的日志:");
	}
	
	/**
	 * Spring 提供的异步有返回值的方法
	 */
	@GetMapping("future")
	public void future() {
		log.info("线程池任务开始执行了！");
		final Future<String> future = asyncService.future();
		log.info("异步方法开始跑起来啦！此处没有阻塞并运行了过去~~~~");
		try {
			log.info("========这里阻塞等待完成的返回值:{}", future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		log.info("等待到了返回值，执行完毕！");
	}
	
}
