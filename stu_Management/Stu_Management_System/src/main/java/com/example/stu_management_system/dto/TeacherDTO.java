package com.example.stu_management_system.dto;

public class TeacherDTO {
	private Long t_id;
	private String t_name;
	private String t_phone;
	public Long getT_id() {
		return t_id;
	}
	public void setT_id(Long t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_phone() {
		return t_phone;
	}
	public void setT_phone(String t_phone) {
		this.t_phone = t_phone;
	}
}
