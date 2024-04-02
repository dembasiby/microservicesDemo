package com.dembasiby.employeeservice.mapper;

import com.dembasiby.employeeservice.dto.EmployeeDto;
import com.dembasiby.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);
    EmployeeDto employeeToDto(Employee employee);
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);
}
