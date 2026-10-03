package com.example.studentmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private long phono;
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;
	
	public Student()
	{
		
	}
	
	public Staff getStaff() {
		return staff;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhono() {
		return phono;
	}
	public void setPhono(long phono) {
		this.phono = phono;
	}

	public  void setStaff(Staff staff2) {
		// TODO Auto-generated method stub
		this.staff=staff2;
		
	}
	

}
