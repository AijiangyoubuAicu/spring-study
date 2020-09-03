package com.fandow.aijiang.springstudy.decouple.compoent;

import com.fandow.aijiang.springstudy.decouple.Tea;
import org.springframework.stereotype.Component;

/**
 * 绿茶，一种茶的实现
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@Component
public class GreenTea implements Tea {
	
	@Override
	public void drink() {
		System.out.println("绿茶真好喝!");
	}
}
