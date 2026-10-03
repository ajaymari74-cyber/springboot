package com.example.stu_management_system.mapper;

import org.mapstruct.Mapper;

import com.example.stu_management_system.dto.StudentDTO;
import com.example.stu_management_system.entity.Student;

@Mapper(componentModel="spring")
public interface StudentMapper {
	StudentDTO toDTO(Student student);
	Student toEntity(StudentDTO dto);
}
