package com.example.student_managent_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student_managent_system.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
