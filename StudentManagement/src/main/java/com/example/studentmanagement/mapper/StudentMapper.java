package com.example.studentmanagement.mapper;

import org.mapstruct.Mapper;

import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.entity.Student;

@Mapper(componentModel ="spring", uses = StaffMapper.class)
public interface StudentMapper {
	StudentDTO toDTO(Student Student);
	Student toEntity(StudentDTO dto);

}
