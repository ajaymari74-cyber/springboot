package com.example.studentmanagement.dto;

import com.example.studentmanagement.entity.Staff;

public class StudentDTO {
private Long id;
private String name;
private long phono;
private Staff staff;

public Staff getStaff() {
	return staff;
}

public void setStaff(Staff staff) {
	this.staff = staff;
}

public StudentDTO() {
	
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getPhono() {
	return phono;
}
public void setPhono(long phono) {
	this.phono = phono;
}

}
