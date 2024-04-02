package com.dembasiby.departmentservice.mapper;

import com.dembasiby.departmentservice.dto.DepartmentDto;
import com.dembasiby.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);
    DepartmentDto departmentToDto(Department department);
    Department departmentDtoToDepartment(DepartmentDto departmentDto);
}
