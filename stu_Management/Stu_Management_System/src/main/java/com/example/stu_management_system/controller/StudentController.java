package com.example.stu_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stu_management_system.dto.StudentDTO;
import com.example.stu_management_system.entity.Student;
import com.example.stu_management_system.service.Student_service;


@RequestMapping("/Student")
@RestController
public class StudentController {
	@Autowired
	Student_service serv;
	@GetMapping("/")
	public List<StudentDTO> Get() {
		
		return serv.get();
	}
	
	@PostMapping("/Student")
	public Student add(@RequestBody Student stu) {
		return serv.add(stu);
	}
	@DeleteMapping("/Student/{id}")
	public String del(@PathVariable Long id) {
		serv.del(id);
		return "Deleted Succesfully";
	}
	
	@PutMapping("Student/{id}")
	public Student update(@RequestBody Student st,@PathVariable Long id) {
		return serv.update(id, st);
	}
	
	@GetMapping("/names")
	public List<String> ShowName(){
		return serv.findName();
	}

}
