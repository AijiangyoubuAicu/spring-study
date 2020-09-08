package com.fandow.aijiang.springstudy.properties.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Admin
 * @version 1.0
 */
@Component
@ConfigurationProperties(prefix = "aijiang")
public class AijiangProperties {
	
	private String name;
	
	private String gender;
	
	private String department;
	
	private String phone;
}
