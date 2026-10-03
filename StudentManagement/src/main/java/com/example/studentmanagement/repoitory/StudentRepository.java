package com.example.studentmanagement.repoitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.studentmanagement.entity.Student;

public interface StudentRepository extends 	JpaRepository<Student,Long>{
	@Query("select s.name from Student s")
	List<String> findNames();
	
	@Query("select s from Student s where s.email=:email")
	public Student findEmail(@Param("email")String email);
}
