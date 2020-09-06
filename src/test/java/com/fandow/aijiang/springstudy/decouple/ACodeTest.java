package com.fandow.aijiang.springstudy.decouple;

import com.fandow.aijiang.springstudy.decouple.compoent.CProgrammer;
import com.fandow.aijiang.springstudy.decouple.compoent.DProgrammer;
import com.fandow.aijiang.springstudy.decouple.impl.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 开发任务测试
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@SpringBootTest
public class ACodeTest {
	
	@Resource
	private DProgrammer dProgrammer;
	@Resource
	private CProgrammer cProgrammer;
	
	/**
	 * 控制反转的测试
	 */
	@Test
	public void codingCDTest() {
		dProgrammer.code();
		cProgrammer.code();
	}
	
	/**
	 * 强耦合类与类的测试
	 */
	@Test
	public void codingATest() {
		AITLeader aitLeader = new AITLeader();
		aitLeader.task();
	}
	
	/**
	 * 面向接口编程的测试
	 */
	@Test
	public void codingBTest() {
	
//		Computer computer = new HuaweiComputer();
		Computer computer = new XiaomiComputer();
		
		//Programmer programmer = new BProgrammer(computer);
		Programmer programmer = new AProgrammer();
		
		BITLeader bitLeader = new BITLeader(programmer);
		bitLeader.task();
	}
	
	
	
}
