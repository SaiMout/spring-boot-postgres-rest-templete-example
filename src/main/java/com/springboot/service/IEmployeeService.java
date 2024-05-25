package com.springboot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.dto.ResponseDto;
import com.springboot.model.Employee;

@Service
public interface IEmployeeService {
    Employee saveEmployee(Employee employee);

    ResponseEntity<Employee> getEmployeeById(Long id);

    List<Employee> getAllEmployees();

//    Employee getEmployeeById(Long id);

    String updateEmployee(Employee employee, Long id);

    String deleteEmployee(Long id);

    String deleteAllEmployees();
    
    ResponseDto getEmployee(Long id);
    
}
