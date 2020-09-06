package com.fandow.aijiang.springstudy.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;

/**
 * Spring-Data-Redis 测试
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@SpringBootTest
public class RedisTest {
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@Test
	public void jedisTest() {
		// Jedis池配置文件
		JedisPoolConfig config= new JedisPoolConfig();
		// 最大连接实例数
		config.setMaxTotal(1024);
		// 最大闲置实例数
		config.setMaxIdle(200);
		// 等待可用连接的最大时间
		config.setMaxWaitMillis(15000);
		JedisPool pool = new JedisPool(config);
		
		// 取出实例并调用数据库操作语句方法
		Jedis jedis = pool.getResource();
		jedis.set("Aijiangyou","Aicu");
		
		System.out.println(jedis.get("foo"));
		// 归还实例资源给连接池
		jedis.close();
	}
	
	@Test
	public void redisTemplateTest() {
		redisTemplate.opsForValue().set("Aicu", "Aijiangyou");
		System.err.println(redisTemplate.opsForValue().get("Aicu"));
	}
	
}
