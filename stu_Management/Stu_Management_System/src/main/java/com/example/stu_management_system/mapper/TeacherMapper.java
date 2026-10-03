package com.example.stu_management_system.mapper;

import com.example.stu_management_system.dto.TeacherDTO;
import com.example.stu_management_system.entity.Teacher;

public interface TeacherMapper {
	TeacherDTO toDTO(Teacher teacher);
	Teacher toEntity(TeacherDTO dto);

}
