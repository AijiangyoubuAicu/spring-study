package com.fandow.aijiang.springstudy.validation.annotation;

import com.fandow.aijiang.springstudy.validation.validator.PhoneValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义手机号校验注解
 *
 * @Constraint(validatedBy = MyConstraintValidator.class) 指明这是一个校验的注解
 * validatedBy = MyConstraintValidator.class 指定由 MyConstraintValidator 类去校验
 *
 * 必须定义三个成员  message，groups，payload
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {PhoneValidation.class})
public @interface Phone {
	
	String message() default "{手机号格式不正确！}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default { };
	
}
