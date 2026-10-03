package com.example.stu_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stu_management_system.entity.Teacher;



public interface TeacherRepository extends JpaRepository<Teacher,Long>{

}
