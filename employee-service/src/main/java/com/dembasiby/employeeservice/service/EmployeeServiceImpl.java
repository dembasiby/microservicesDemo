package com.dembasiby.employeeservice.service;

import com.dembasiby.employeeservice.dto.EmployeeDto;
import com.dembasiby.employeeservice.entity.Employee;
import com.dembasiby.employeeservice.mapper.EmployeeMapper;
import com.dembasiby.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
//        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee employee = EmployeeMapper.MAPPER.employeeDtoToEmployee(employeeDto);
        employeeRepository.save(employee);
        return EmployeeMapper.MAPPER.employeeToDto(employee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(
                        () -> new RuntimeException("Employee Not Found!")
                );
        return EmployeeMapper.MAPPER.employeeToDto(employee);
//        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(EmployeeMapper.MAPPER::employeeToDto)
//                .map((employee) -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }
}
