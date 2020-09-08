package com.fandow.aijiang.springstudy.validation.validator;

import com.fandow.aijiang.springstudy.validation.annotation.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 手机号校验器实现
 *
 * @author 梁业锦
 * @version 1.0
 */
public class PhoneValidation implements ConstraintValidator<Phone, String> {
	
	String phonePattern;
	Pattern compile;
	
	/**
	 * 初始化
	 */
	@Override
	public void initialize(Phone constraintAnnotation) {
		phonePattern = "1[3456789]\\d{9}";
		compile = Pattern.compile(phonePattern);
	}
	
	/**
	 * 校验方法
	 *
	 * @param value 传递过来的参数值
	 * @param context 提供的上下文操作
	 * @return false 则返回注解当中的 message 信息并抛出异常
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return compile.matcher(value).matches();
	}
}
