package com.example.studentmanagement.mapper;

import org.mapstruct.Mapper;

import com.example.studentmanagement.dto.StaffDTO;
import com.example.studentmanagement.entity.Staff;

@Mapper(componentModel ="spring")
public interface StaffMapper {
	StaffDTO toDTO(Staff staff);
	Staff toEntity(StaffDTO dto);

}


