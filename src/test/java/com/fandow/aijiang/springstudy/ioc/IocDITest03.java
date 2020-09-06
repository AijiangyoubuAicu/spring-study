package com.fandow.aijiang.springstudy.ioc;

import com.fandow.aijiang.springstudy.decouple.compoent.CProgrammer;
import com.fandow.aijiang.springstudy.decouple.compoent.DProgrammer;
import lombok.Setter;
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
public class IocDITest03 {
	
	@Resource
	private CProgrammer cProgrammer;
	
	@Test
	public void test() {
		cProgrammer.code();
	}
	
}
