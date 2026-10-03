package com.example.studentmanagement.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagement.dto.StaffDTO;
import com.example.studentmanagement.entity.Staff;
import com.example.studentmanagement.service.StaffServices;
@RestController
public class StaffController {

	@Autowired
	StaffServices serv;
	

	
	@GetMapping("/staff")
public List<StaffDTO> get() {
		return serv.getB();
	
}
	
	@PostMapping("/staff")
	
	public Staff add(@RequestBody Staff sta) {
		return serv.add(sta);
	}
	
	@DeleteMapping("/staff/{id}")
	
	public String del(@PathVariable Long id) {
		serv.del(id);
		return "deleted Sucessfully";
	}
	
	@PutMapping("/staff/{id}")
	public Staff update(@RequestBody Staff stt, @PathVariable Long id) {
		return serv.update(id,stt);
	}
}
