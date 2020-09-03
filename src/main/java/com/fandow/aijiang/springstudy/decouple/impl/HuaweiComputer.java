package com.fandow.aijiang.springstudy.decouple.impl;

import com.fandow.aijiang.springstudy.decouple.Computer;

/**
 * 华为笔记本实现
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
public class HuaweiComputer implements Computer {
	
	@Override
	public void write() {
		System.out.println("正在使用华为笔记本编程！");
	}
}
