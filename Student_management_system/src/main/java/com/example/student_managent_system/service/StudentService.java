package com.example.student_managent_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.student_managent_system.entity.Student;
import com.example.student_managent_system.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;           
	
	public List<Student> getA() {         
		return repo.findAll();
	}
	
	public Student add(Student stu) {
		return repo.save(stu);
	}
	
	public String del(Long id) {
		repo.deleteById(id);
		return "deleted Successfully";
	}
	
	// Fixed: Corrected method name spelling, exception name spelling, and closing parenthesis
	public Student update(Long id, Student stu) {
		Student s = repo.findById(id).orElseThrow(() -> new RuntimeException("Student id is not Found"));
		s.setName(stu.getName());
		s.setEmail(stu.getEmail());
		s.setPhone(stu.getPhone());
		return repo.save(s);
	}
	
	// Fixed: Renamed the duplicate 'pageRequest' variable to 'studentPage'
	public Page<Student> fun1() {
		PageRequest pageRequest = PageRequest.of(0, 3);
		Page<Student> studentPage = repo.findAll(pageRequest);
		return studentPage;
	}
}
