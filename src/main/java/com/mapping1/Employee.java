package com.mapping1;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	private int empId;

	@Column(name = "Employee_Name")
	private String name;

	@ManyToMany
	@JoinTable(name = "Emp_Proj",
			   joinColumns = {@JoinColumn (name="Emp_Id")},
			   inverseJoinColumns = {@JoinColumn(name="Project_Id")})
	private List<Project> project;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String name, List<Project> project) {
		super();
		this.empId = empId;
		this.name = name;
		this.project = project;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

}
