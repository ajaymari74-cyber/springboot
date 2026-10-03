package com.example.student_managent_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_managent_system.entity.Teacher;
import com.example.student_managent_system.service.TeacherService;
@RestController
public class TeacherController {
	@Autowired
	TeacherService serv;
	
	@GetMapping("/teacher")
	public List<Teacher> get() {
		return serv.getB();
	}
	@PostMapping("/teacher")

	public Teacher add(@RequestBody Teacher teach) {
		return serv.add(teach);
	}
	@DeleteMapping("teacher/{id}")
	public String del(@PathVariable Long id) {
		serv.del(id);
		return "deleted Sucessfully";
	}
	@PutMapping("/teacher/{id}")
	public Teacher update(@RequestBody Teacher teach, @PathVariable Long id) {
		return serv.update(id,teach);
	
	
	}
	@GetMapping("/teacher/page")
	public Page<Teacher> getTeacherPage() {
		return serv.fun1();
	}
}

