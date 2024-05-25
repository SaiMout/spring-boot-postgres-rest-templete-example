package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.springboot.dto.EmployeeDto;
import com.springboot.dto.MMnrcDto;
import com.springboot.dto.ResponseDto;
import com.springboot.model.Employee;
import com.springboot.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	private final RestTemplate restTemplate;
	private final IEmployeeRepository employeeRepository;

	public EmployeeServiceImpl(IEmployeeRepository employeeRepository, RestTemplate restTemplate) {
		this.employeeRepository = employeeRepository;
		this.restTemplate = restTemplate;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {

		Optional<Employee> employeeData = employeeRepository.findById(id);

		if (employeeData.isPresent()) {
			return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

//	@Override
//	public Employee getEmployeeById(Long id) {
//
//		return employeeRepository.getReferenceById(id);
//	}

	@Override
	public String updateEmployee(Employee employee, Long id) {

		if (employeeRepository.existsById(id)) {
			employee.setId(id);
			employeeRepository.save(employee);
			return "id : " + employee.getId() + " is updated.";
		} else {
			return id + " not exist";
		}

	}

	@Override
	public String deleteEmployee(Long id) {

		if (employeeRepository.existsById(id)) {
			employeeRepository.delete(employeeRepository.getReferenceById(id));
			return id + " deleted.";
		} else {
			return id + " not exist";
		}

	}

	@Override
	public String deleteAllEmployees() {
		if (employeeRepository.count() > 0) {
			employeeRepository.deleteAll();
			return "All data deleted!";
		} else {
			return "Table is empty, no data is deleted. ";
		}

	}

	@Override
	public ResponseDto getEmployee(Long employeeId) {

		ResponseDto responseDto = new ResponseDto();

		if (employeeRepository.existsById(employeeId)) {
			Employee employee = employeeRepository.findById(employeeId).get();
			EmployeeDto employeeDto = mapToEmployee(employee);

			ResponseEntity<MMnrcDto> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/api/mmnrcs/" + employee.getMmNrcId(), MMnrcDto.class);
			if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
				MMnrcDto mmnrcDto = responseEntity.getBody();

				System.out.println(responseEntity.getStatusCode());

				responseDto.setMmnrc(mmnrcDto);
			}

			responseDto.setEmployee(employeeDto);

			return responseDto;
		}
		else {
			return null;
		}
		

	}

	private EmployeeDto mapToEmployee(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setId(employee.getId());
		employeeDto.setName(employee.getName());
		employeeDto.setDepartment(employee.getDepartment());
		employeeDto.setRole(employee.getRole());
		employeeDto.setMmnrcId(employee.getMmNrcId());
		return employeeDto;
	}

}
