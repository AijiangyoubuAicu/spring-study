package com.fandow.aijiang.springstudy.decouple.impl;

import com.fandow.aijiang.springstudy.decouple.ITLeader;

/**
 * IT 开发部 Leader 的 A 实现
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
public class AITLeader implements ITLeader {
	
	private final AProgrammer aProgrammer;
	
	public AITLeader() {
		aProgrammer = new AProgrammer();
	}
	
	@Override
	public void task() {
		aProgrammer.code();
	}
}
