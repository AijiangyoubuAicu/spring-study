package com.fandow.aijiang.springstudy.decouple.impl;

import com.fandow.aijiang.springstudy.decouple.Computer;

/**
 * MacBook 笔记本实现
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
public class MacBookComputer implements Computer {
	
	@Override
	public void write() {
		System.out.println("正在使用 MacBook 敲代码！");
	}
}
