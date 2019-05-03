package com.epam.model;

public class Employees implements Comparable<Employees>{
	
	private int id;
	private String name;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	@Override
	public int compareTo(Employees o) {
		if(this.getId() > o.getId())
			return 1;
		if(this.getId() < o.getId())
			return -1;
		return 0;
	}
	
	
}
