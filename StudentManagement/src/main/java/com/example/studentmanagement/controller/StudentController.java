package com.example.studentmanagement.controller;

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

import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentServices;

@RestController
public class StudentController {
	@Autowired
	StudentServices serv;
	

	
	@GetMapping("/student")
public List<StudentDTO> get() {
		return serv.getA();
	
}
	@PostMapping("/student")
	
	public Student add(@RequestBody Student stu) {
		return serv.add(stu);
	}
	
	@DeleteMapping("/student/{id}")
	
	public String del(@PathVariable Long id) {
		serv.del(id);
		return "deleted Sucessfully";
	}
	
	@PutMapping("/student/{id}")
	public Student update(@RequestBody Student st, @PathVariable Long id) {
		return serv.update(id,st);
	}
	

	@GetMapping("/find")

	public List<String> names(){
	return serv.findName();
	}
			
	@GetMapping("/student/email/{email}")
	public Student findEmail(@PathVariable String email){
		
		return serv.findEmail(email);
	}
	
	@GetMapping("/show")
	public Page<Student> showall(){
		return serv.showall();
	}
	@PostMapping("/student/{staffId}")
	public Student addStudent(
			@PathVariable Long staffId,@RequestBody Student stu) {
		return serv.saveStudent(stu, staffId);
	}
}
