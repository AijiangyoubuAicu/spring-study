package com.fandow.aijiang.springstudy.decouple.impl;

import com.fandow.aijiang.springstudy.decouple.Programmer;

/**
 * A程序员，一个只使用 MacBook 的程序员
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
public class AProgrammer implements Programmer {
	
	private final MacBookComputer macBookComputer;
	
	public AProgrammer() {
		this.macBookComputer = new MacBookComputer();
	}
	
	@Override
	public void code() {
		macBookComputer.write();
	}
}
