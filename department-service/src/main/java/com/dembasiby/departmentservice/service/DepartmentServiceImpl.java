package com.dembasiby.departmentservice.service;

import com.dembasiby.departmentservice.mapper.DepartmentMapper;
import com.dembasiby.departmentservice.dto.DepartmentDto;
import com.dembasiby.departmentservice.entity.Department;
import com.dembasiby.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.MAPPER
                .departmentDtoToDepartment(departmentDto);
        departmentRepository.save(department);

//        return modeMapper.map(department, DepartmentDto.class);
        return DepartmentMapper.MAPPER.departmentToDto(department);

    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository
                .findDepartmentByDepartmentCode(departmentCode)
                .orElseThrow(() -> new RuntimeException("Department Not Found!"));

//        return modeMapper.map(department, DepartmentDto.class);
        return DepartmentMapper.MAPPER.departmentToDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        return departmentRepository.findAll().stream()
//                .map((department) -> modelMapper.map(department, DepartmentDto.class))
                .map(DepartmentMapper.MAPPER::departmentToDto)
                .collect(Collectors.toList());

    }
}
