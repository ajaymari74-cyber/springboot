package com.example.studentcourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentcourse.entity.Student;
import com.example.studentcourse.service.StudentService;

@RestController
public class StudentContreller {
	@Autowired
	StudentService serv;
	
	@GetMapping("/student")
	public List<Student> get() {
		return serv.getA();
	}
	@PostMapping("/student")

	public Student add(@RequestBody Student teach) {
		return serv.add(teach);
	}
	@DeleteMapping("student/{id}")
	public String del(@PathVariable Long id) {
		serv.del(id);
		return "deleted Sucessfully";
	}
//	@UpdateMapping("/Student/{id}")
//	public Teacher upd(@PathVariable Long id) {
//		sev.upd(id);
//		return "Updated Sucessfully";
//	}

}


