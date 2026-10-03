package com.example.student_managent_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.student_managent_system.entity.Teacher;
import com.example.student_managent_system.repository.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository repo;

	public List<Teacher> getB() {
		return repo.findAll();
	}

	public Teacher add(Teacher teach) {
		return repo.save(teach);
	}

	public String del(Long id) {
		repo.deleteById(id);
		return "deleted Successfully";
	}
	
	public Teacher update(Long id, Teacher teach) {
		Teacher s = repo.findById(id).orElseThrow(() -> new RuntimeException("Teacher Id not found"));
		s.setName(teach.getName());
		s.setEmail(teach.getEmail());
		s.setPhone(teach.getPhone());
		return repo.save(s);
	}

	public Page<Teacher> fun1() {
		PageRequest pageRequest = PageRequest.of(0, 5);
		Page<Teacher> teacherPage = repo.findAll(pageRequest);
		return teacherPage;
	}
}
