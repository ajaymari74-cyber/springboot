	package com.example.stu_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stu_management_system.dto.StudentDTO;
import com.example.stu_management_system.entity.Student;
import com.example.stu_management_system.mapper.StudentMapper;
import com.example.stu_management_system.repository.Student_repository;

@Service
public class Student_service {
	@Autowired
	Student_repository repo;
	
	@Autowired
	StudentMapper mapper;
	public List<StudentDTO> get() {
		List<Student> student = repo.findAll();
		return student.stream().map(mapper::toDTO).toList();
	}
	
	public Student add(Student stu) {
		return repo.save(stu);
	}
	
	public String del(Long id) {
		repo.deleteById(id);
		return "Deleted Succesfully";
	}
	public Student update(Long id, Student st) {
		Student s = repo.findById(id).orElseThrow(()-> new RuntimeException("Student Id Not Found"));
		s.setName(st.getName());
		s.setEmail(s.getEmail());
		s.setPhone(s.getPhone());
		return repo.save(s);
	}
	
	public List<String> findName(){
		return repo.findNames();
	}
}
