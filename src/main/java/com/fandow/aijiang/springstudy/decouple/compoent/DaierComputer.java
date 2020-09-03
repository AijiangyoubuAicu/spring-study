package com.fandow.aijiang.springstudy.decouple.compoent;

import com.fandow.aijiang.springstudy.decouple.Computer;
import org.springframework.stereotype.Service;

/**
 * 戴尔的电脑实现
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@Service
public class DaierComputer implements Computer {
	
	@Override
	public void write() {
		System.out.println("正在使用戴尔笔记本编程");
	}
}
