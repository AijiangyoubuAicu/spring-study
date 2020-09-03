package com.fandow.aijiang.springstudy.decouple.impl;

import com.fandow.aijiang.springstudy.decouple.ITLeader;
import com.fandow.aijiang.springstudy.decouple.Programmer;

/**
 * IT 开发部 Leader 的 B 实现
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
public class BITLeader implements ITLeader {
	
	private final Programmer programmer;
	
	public BITLeader(Programmer programmer) {
		this.programmer = programmer;
	}
	
	@Override
	public void task() {
		programmer.code();
	}
}
