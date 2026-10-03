package com.example.studentcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentcourse.entity.Student;
import com.example.studentcourse.repository.StudentRepository;

@Service

public class StudentService {
	@Autowired
	StudentRepository Lib;
	public Student add(Student stu)
	{
		Lib.save(stu);
		return "Student data added sucessfull"; 
	}

   
}
