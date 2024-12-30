package com.project.client_magnet.model;

import java.sql.*;
import java.util.Objects;

public class Logs {
	private Representative representative;
	private Employee employee;
	private String interactionType;
	private Date dates;
	private String notes;
	

	public Logs(Representative representative, Employee employee, String interactionType, Date dates, String notes) {
		super();
		this.representative = representative;
		this.employee = employee;
		this.interactionType = interactionType;
		this.dates = dates;
		this.notes = notes;
	}

	
	public Representative getRepresentative() {
		
		return representative;
	}

	public void setRepresentative(Representative representative) {
		this.representative = representative;
	}

	public Employee getEmployee() {
		
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getInteractionType() {
		return interactionType;
	}

	public void setInteractionType(String interactionType) {
		this.interactionType = interactionType;
	}

	public Date getDates() {
		return dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(employee, representative);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Logs other = (Logs) obj;
		return Objects.equals(employee, other.employee) && Objects.equals(representative, other.representative);
	}

	@Override
	public String toString() {
		return "Logs [representative=" + representative + ", employee=" + employee + ", interactionType="
				+ interactionType + ", dates=" + dates + ", notes=" + notes + "]";
	}

}

