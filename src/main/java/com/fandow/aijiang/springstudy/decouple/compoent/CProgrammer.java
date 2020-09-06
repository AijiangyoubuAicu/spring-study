package com.fandow.aijiang.springstudy.decouple.compoent;

import com.fandow.aijiang.springstudy.decouple.Programmer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * C 程序员的实现
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@AllArgsConstructor
@Service
public class CProgrammer implements Programmer {
	
	private final GreenTea tea;
	
	/*public CProgrammer(GreenTea tea) {
		this.tea = tea;
	}*/
	
	@Override
	public void code() {
		System.err.println(tea);
		System.out.println("假扮的程序员");
	}
}
