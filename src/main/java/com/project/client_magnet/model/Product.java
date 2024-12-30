package com.project.client_magnet.model;

import java.util.Objects;

public class Product {
	public static int counter;
	private int productID;
	private String productName;
	private Team team;
	static {
		counter = 0;
	}

	public Product() {
		super();
	}

	public Product(int productID, String productName, Team team) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.team = team;
	}

	public Product(String productName, Team team) {
		super();
		this.productName = productName;
		this.team = team;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productID, team);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return productID == other.productID && Objects.equals(team, other.team);
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", team=" + team + "]";
	}

	public int compareTo(Product o) {
		return this.productID - o.productID;
	}

}
