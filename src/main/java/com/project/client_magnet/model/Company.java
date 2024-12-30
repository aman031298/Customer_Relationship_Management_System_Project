package com.project.client_magnet.model;
import java.lang.Comparable;
import java.util.Objects;
public class Company implements Comparable<Company>{
	public static int counter;
	private int cid;
	private String cname;
	private String address;
	private String email;

	// static and init block
	static {
		counter = 0;
	}

	{
		this.cid = ++counter;
	}

	// alt+s+c
	public Company() {
		super();
	}

	// alt+s+a
	public Company(int cid, String cname, String address, String email) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.address = address;
		this.email = email;
	}

	public Company(String cname, String address, String email) {
		super();
		this.cname = cname;
		this.address = address;
		this.email = email;
	}

	// alt+s+r
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
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
		return Objects.hash(cid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		return cid == other.cid;
	}

	@Override
	public String toString() {
		return "Company [cid=" + cid + ", cname=" + cname + ", address=" + address + ", email=" + email + "]";
	}

	@Override
	public int compareTo(Company o) {
		
		return this.cid-o.cid;
	}

}
