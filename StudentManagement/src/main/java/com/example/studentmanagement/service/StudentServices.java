package com.example.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.entity.Staff;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.mapper.StudentMapper;
import com.example.studentmanagement.repoitory.StaffRepository;
import com.example.studentmanagement.repoitory.StudentRepository;
@Service
public class StudentServices {
	
		
	@Autowired
	StudentRepository repo;
	
	@Autowired
	StaffRepository repos;
	
	@Autowired
	StudentMapper mapper;
	public List<StudentDTO> getA() {
		List<Student> students=repo.findAll();
		return students.stream()
				.map(mapper::toDTO)
				.toList();
	}
	
	public Student add(Student stu) {
		return repo.save(stu);
	}
	
	public Student saveStudent(Student stu, Long staffId) {
		Staff staff = repos.findById(staffId).orElse(null);
		if(staff == null) {
			return null;
		}
		stu.setStaff(staff);
		return repo.save(stu);
	}
	public String del(Long id) {
		repo.deleteById(id);
		return "deleted Sucessfully";
	}
	
	public Student update(Long id,Student st) {
		Student s=repo.findById(id).orElseThrow ( ()->new RuntimeException("Student Id not found"));
		s.setName(st.getName());
		s.setEmail(st.getEmail());
		s.setPhono(st.getPhono());
		return repo.save(s);
		
	
	}
	
	public List<String> findName(){
		 
		  return  repo.findNames();
	}
	
	
	public Student findEmail(String email) {
		return repo.findEmail(email);
	}
	
	public Page<Student> showall(){
	PageRequest pageRequest=PageRequest.of(0,2);

	
//	Page<Student> students=repo.findAll(pageRequest);
	return repo.findAll(pageRequest);	
	}
		
	}


