package com.example.stu_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.stu_management_system.entity.Student;

public interface Student_repository extends JpaRepository<Student,Long>{
@Query("select  s.name from Student s")
List<String> findNames();
}
