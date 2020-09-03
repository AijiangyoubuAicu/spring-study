package com.fandow.aijiang.springstudy.decouple.compoent;

import com.fandow.aijiang.springstudy.decouple.Programmer;
import org.springframework.stereotype.Service;

/**
 * C 程序员的实现
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@Service
public class CProgrammer implements Programmer {
	
	@Override
	public void code() {
		System.out.println("假扮的程序员");
	}
}
