package com.project.client_magnet.model;

import java.lang.Comparable;
import java.util.Objects;

public class Lead implements Comparable<Lead> {
	public static int counter;
	private int leadID;
	private Company company;
	private Product product;
	private String industryType;
	private String source;
	private int interestLevel;
	private double dealSize;
	private Representative representative;

	static {
		counter = 0;
	}

	{
		this.leadID = ++counter;
	}

	public Lead() {
		super();

	}

	public Lead(int leadID, Company company, Product product, String industryType, String source, int interestLevel,
			double dealSize, Representative representative) {
		super();
		this.leadID = leadID;
		this.company = company;
		this.product = product;
		this.industryType = industryType;
		this.source = source;
		this.interestLevel = interestLevel;
		this.dealSize = dealSize;
		this.representative = representative;
	}

	public Lead(Company company, Product product, String industryType, String source, int interestLevel,
			double dealSize, Representative representative) {
		super();
		this.company = company;
		this.product = product;
		this.industryType = industryType;
		this.source = source;
		this.interestLevel = interestLevel;
		this.dealSize = dealSize;
		this.representative = representative;
	}

	public int getLeadID() {
		return leadID;
	}

	public void setLeadID(int leadID) {
		this.leadID = leadID;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getInterestLevel() {
		return interestLevel;
	}

	public void setInterestLevel(int interestLevel) {
		this.interestLevel = interestLevel;
	}

	public double getDealSize() {
		return dealSize;
	}

	public void setDealSize(double dealSize) {
		this.dealSize = dealSize;
	}

	public Representative getRepresentative() {
		return representative;
	}

	public void setRepresentative(Representative representative) {
		this.representative = representative;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(company, leadID, product, representative);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lead other = (Lead) obj;
		return Objects.equals(company, other.company) && leadID == other.leadID
				&& Objects.equals(product, other.product) && Objects.equals(representative, other.representative);
	}

	@Override
	public String toString() {
		return "Lead [leadID=" + leadID + ", company=" + company + ", product=" + product + ", industryType="
				+ industryType + ", source=" + source + ", interestLevel=" + interestLevel + ", dealSize=" + dealSize
				+ ", representative=" + representative + "]";
	}

	@Override
	public int compareTo(Lead o) {

		return this.leadID - o.leadID;
	}

}
