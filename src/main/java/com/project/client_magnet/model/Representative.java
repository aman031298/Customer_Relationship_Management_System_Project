package com.project.client_magnet.model;

import java.util.Objects;

public class Representative {
	public static int counter;
	private int repID;
	private String repName;
	private String repEmail;
	private String repMobile;
	private String jobRole;
	private Company company;// HAS-A
	static {
		counter = 0;
	}

	public Representative() {
		super();
	}

	public Representative(int repID, String repName, String repEmail, String repMobile, String jobRole,
			Company company) {
		super();
		this.repID = repID;
		this.repName = repName;
		this.repEmail = repEmail;
		this.repMobile = repMobile;
		this.jobRole = jobRole;
		this.company = company;
	}

	public Representative(String repName, String repEmail, String repMobile, String jobRole, Company company) {
		super();
		this.repName = repName;
		this.repEmail = repEmail;
		this.repMobile = repMobile;
		this.jobRole = jobRole;
		this.company = company;
	}

	public int getRepID() {
		return repID;
	}

	public void setRepID(int repID) {
		this.repID = repID;
	}

	public String getRepName() {
		return repName;
	}

	public void setRepName(String repName) {
		this.repName = repName;
	}

	public String getRepEmail() {
		return repEmail;
	}

	public void setRepEmail(String repEmail) {
		this.repEmail = repEmail;
	}

	public String getRepMobile() {
		return repMobile;
	}

	public void setRepMobile(String repMobile) {
		this.repMobile = repMobile;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public int hashCode() {
		return Objects.hash(company, repID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Representative other = (Representative) obj;
		return Objects.equals(company, other.company) && repID == other.repID;
	}

	@Override
	public String toString() {
		return "Representative [repID=" + repID + ", repName=" + repName + ", repEmail=" + repEmail + ", repMobile="
				+ repMobile + ", jobRole=" + jobRole + ", company=" + company + "]";
	}

	public int compareTo(Representative o) {
		return this.repID - o.repID;
	}

}
