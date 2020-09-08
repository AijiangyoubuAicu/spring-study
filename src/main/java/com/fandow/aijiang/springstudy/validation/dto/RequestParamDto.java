package com.fandow.aijiang.springstudy.validation.dto;

import com.fandow.aijiang.springstudy.validation.annotation.Phone;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 校验器测试请求实体 DTO
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
public class RequestParamDto {
	
	@NotEmpty(message = "id 不能未空！")
	private String id;
	
	@Size(max = 3, message = "名称必填，且最多为3个汉字！")
	private String nickname;
	
	@Phone
	private String phone;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
