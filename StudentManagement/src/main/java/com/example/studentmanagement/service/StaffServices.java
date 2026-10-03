package com.example.studentmanagement.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanagement.dto.StaffDTO;
import com.example.studentmanagement.entity.Staff;
import com.example.studentmanagement.mapper.StaffMapper;
import com.example.studentmanagement.repoitory.StaffRepository;
@Service
public class StaffServices {
	
		
	@Autowired
	StaffRepository repo;
	
	@Autowired
	StaffMapper mapper;
	
	public List<StaffDTO> getB() {
		List<Staff> staffs=repo.findAll();
		return staffs.stream()
				.map(mapper::toDTO)
				.toList();
		
//		return repo.findAll();
	}
		
	
	public Staff add(Staff sta) {
		return repo.save(sta);
	}
	
	public String del(Long id) {
		repo.deleteById(id);
		return "deleted Sucessfully";
	}
	
	public Staff update(Long id,Staff stt) {
		Staff ss=repo.findById(id).orElseThrow ( ()->new RuntimeException("Staff Id not found"));
		ss.setName(stt.getName());
		ss.setEmail(stt.getEmail());
		ss.setPhono(stt.getPhono());
		return repo.save(ss);
		
	}



}
