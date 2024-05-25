package com.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private EmployeeDto employee;
    private MMnrcDto mmnrc;
	public EmployeeDto getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}
	public MMnrcDto getMmnrc() {
		return mmnrc;
	}
	public void setMmnrc(MMnrcDto mmnrc) {
		this.mmnrc = mmnrc;
	}
	public ResponseDto(EmployeeDto employee, MMnrcDto mmnrc) {
		super();
		this.employee = employee;
		this.mmnrc = mmnrc;
	}
	public ResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}

