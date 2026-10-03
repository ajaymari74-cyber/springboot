package com.example.studentmanagement.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagement.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff,Long>{

}