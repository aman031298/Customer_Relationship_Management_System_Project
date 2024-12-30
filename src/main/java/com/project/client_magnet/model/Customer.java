package com.project.client_magnet.model;

import java.lang.Comparable;
import java.util.Objects;

public class Customer implements Comparable<Customer> {
	public static int counter;
	private int custID;
	private String custName;
	private Product product;
	private String industryType;
	private String address;
	private String email;

	static {
		counter = 0;
	}

	{
		this.custID = ++counter;
	}

	public Customer() {
		super();

	}

	public Customer(int custID, String custName, Product product, String industryType, String address, String email) {
		super();
		this.custID = custID;
		this.custName = custName;
		this.product = product;
		this.industryType = industryType;
		this.address = address;
		this.email = email;
	}

	public Customer(String custName, Product product, String industryType, String address, String email) {
		super();
		this.custName = custName;
		this.product = product;
		this.industryType = industryType;
		this.address = address;
		this.email = email;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Customer.counter = counter;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(custID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return custID == other.custID;
	}

	@Override
	public String toString() {
		return "Customer [custID=" + custID + ", custName=" + custName + ", product=" + product + ", industryType="
				+ industryType + ", address=" + address + ", email=" + email + "]";
	}

	@Override
	public int compareTo(Customer o) {

		return this.custID - o.custID;
	}

}
