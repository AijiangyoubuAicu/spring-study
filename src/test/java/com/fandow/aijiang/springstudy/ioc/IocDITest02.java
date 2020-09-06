package com.fandow.aijiang.springstudy.ioc;

import com.fandow.aijiang.springstudy.decouple.compoent.DProgrammer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 依赖注入测试
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@SpringBootTest
public class IocDITest02 {
	
	@Autowired
	private DProgrammer dProgrammer;
	
	@Test
	public void test() {
		System.out.println(dProgrammer);
	}
	
}
