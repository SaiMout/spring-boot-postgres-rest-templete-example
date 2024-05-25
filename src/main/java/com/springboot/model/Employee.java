package com.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;
    private String role;
    private Long mmNrcId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getMmNrcId() {
		return mmNrcId;
	}
	public void setMmNrcId(Long mmNrcId) {
		this.mmNrcId = mmNrcId;
	}
	public Employee(String name, String department, String role, Long mmNrcId) {
		super();
		this.name = name;
		this.department = department;
		this.role = role;
		this.mmNrcId = mmNrcId;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
 
}
