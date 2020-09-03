package com.fandow.aijiang.springstudy.decouple.impl;

import com.fandow.aijiang.springstudy.decouple.Computer;

/**
 * 小米笔记本电脑的实现
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
public class XiaomiComputer implements Computer {
	
	@Override
	public void write() {
		System.out.println("正在使用小米笔记本编程！");
	}
}
