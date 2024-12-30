package com.project.client_magnet.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Schedule implements Comparable<Schedule> {
	private Representative representative;
	private Employee employee;
	private String interactionType;
//	private Date dates;
	private Timestamp preferredTime;

	public Schedule() {
		super();

	}

	public Schedule(Representative representative, Employee employee, String interactionType, 
			Timestamp preferredTime) {
		super();
		this.representative = representative;
		this.employee = employee;
		this.interactionType = interactionType;
//		this.dates = dates;
		this.preferredTime = preferredTime;
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
//
//	public Date getDates() {
//		return dates;
//	}
//
//	public void setDates(Date dates) {
//		this.dates = dates;
//	}

	public Timestamp getPreferredTime() {
		return preferredTime;
	}

	public void setPreferredTime(Timestamp preferredTime) {
		this.preferredTime = preferredTime;
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
		Schedule other = (Schedule) obj;
		return Objects.equals(employee, other.employee) && Objects.equals(representative, other.representative);
	}

	@Override
	public String toString() {
		return "Schedule [representative=" + representative + ", employee=" + employee + ", interactionType="
				+ interactionType  + ", preferredTime=" + preferredTime + "]";
	}

	@Override
	public int compareTo(Schedule o) {

		return 0;
	}

}
