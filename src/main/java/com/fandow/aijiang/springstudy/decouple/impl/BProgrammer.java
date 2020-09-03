package com.fandow.aijiang.springstudy.decouple.impl;

import com.fandow.aijiang.springstudy.decouple.Computer;
import com.fandow.aijiang.springstudy.decouple.Programmer;

/**
 * B程序员，可接受任何电脑
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
public class BProgrammer implements Programmer {
	
	private final Computer computer;
	
	public BProgrammer(Computer computer) {
		this.computer = computer;
	}
	
	@Override
	public void code() {
		computer.write();
	}
}
