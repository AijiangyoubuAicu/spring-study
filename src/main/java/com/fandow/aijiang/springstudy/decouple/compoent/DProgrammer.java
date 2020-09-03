package com.fandow.aijiang.springstudy.decouple.compoent;

import com.fandow.aijiang.springstudy.decouple.Programmer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * D 程序员实现
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@Service
public class DProgrammer implements Programmer {
	
	@Resource
	private DaierComputer computer;
	
	@Resource
	private GreenTea tea;
	
	@Override
	public void code() {
		tea.drink();
		computer.write();
	}
}
