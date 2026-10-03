package com.example.student_managent_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_managent_system.entity.Student;
import com.example.student_managent_system.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService serv;
	
	@GetMapping("/students")
	public List<Student> get() {
		return serv.getA();
	}
	@PostMapping("/student")

	public Student add(@RequestBody Student stu) {
		return serv.add(stu);
	}
	@DeleteMapping("Student/{id}")
	public String del(@PathVariable Long id) {
		serv.del(id);
		return "deleted Sucessfully";
	}

}
