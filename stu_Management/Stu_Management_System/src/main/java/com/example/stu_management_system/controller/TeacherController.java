package com.example.stu_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stu_management_system.dto.TeacherDTO;
import com.example.stu_management_system.entity.Teacher;
import com.example.stu_management_system.service.TeacherService;

@RequestMapping("/Teachers")
@RestController
public class TeacherController {
	@Autowired
	TeacherService serv;
	@GetMapping("/")
	public List<TeacherDTO> Get() {
		
		return serv.get();
	}
	
	@PostMapping("/")
	public Teacher add(@RequestBody Teacher teach) {
		return serv.add(teach);
	}
	@DeleteMapping("/Teacher/{id}")
	public String del(@PathVariable Long id) {
		serv.del(id);
		return "Deleted Succesfully";
	}

}



