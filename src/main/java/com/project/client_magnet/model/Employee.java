package com.project.client_magnet.model;

import java.util.Objects;

public class Employee implements Comparable<Employee> {

	public static int counter;
	private int empID;
	private String empName;
	private String email;
	private String mobile;
	private Team team;
	private String password;
	private String seller;

	static {
		counter = 0;
	}

	{
		this.empID = ++counter;
	}

	public Employee() {
		super();

	}

	public Employee(int empID, String empName, String email, String mobile, Team team, String password) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.email = email;
		this.mobile = mobile;
		this.team = team;
		this.password = password;
	}

	public Employee(String email, String password) {
		super();

		this.email = email;

		this.password = password;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	public String getSeller() {
		return seller;
	}
	
	public void setSeller(String id) {
		this.seller = seller;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empID, team);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empID == other.empID && Objects.equals(team, other.team);
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", team=" + team + ", email=" + email + ", mobile="
				+ mobile + "]";
	}

	@Override
	public int compareTo(Employee o) {

		return this.empID - o.empID;
	}

	

}
