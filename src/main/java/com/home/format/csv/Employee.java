package com.home.format;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * This is DTO
 * @author spark
 *
 */
@JsonPropertyOrder(value = { "department", "title", "name", "employeeNumber", "birthDate", "salary"})
public class Employee {
	private String department;
	private String title;
	private String name;
	private Integer employeeNumber;
	private Date birthDate;
	private BigDecimal salary;

	public Employee() {}

	public Employee(String department, String title, String name, Integer employeeNumber, Date birthDate,
			BigDecimal salary) {
		super();
		this.department = department;
		this.title = title;
		this.name = name;
		this.employeeNumber = employeeNumber;
		this.birthDate = birthDate;
		this.salary = salary;
	}

	@JsonProperty(value="Dapartment")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@JsonProperty(value="Title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty(value="Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty(value="EmployeeNumber")
	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@JsonProperty(value="BirthDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@JsonProperty(value="Salary")
	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return String.join(",", department, title, name, String.valueOf(employeeNumber), sdf.format(birthDate), salary.toPlainString());
	}
}
