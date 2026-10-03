package com.example.stu_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stu_management_system.entity.Teacher;
import com.example.stu_management_system.mapper.TeacherMapper;
import com.example.stu_management_system.repository.TeacherRepository;

@Service
public class TeacherService {
	@Autowired
	TeacherRepository repo;
	
	@Autowired
	TeacherMapper mapper;
	public List<Teacher> get() {
	 return repo.findAll();
	}
	
	public Teacher add(Teacher teach) {
		return repo.save(teach);
	}
	
	public String del(Long id) {
		repo.deleteById(id);
		return "Deleted Succesfully";
	}

}
