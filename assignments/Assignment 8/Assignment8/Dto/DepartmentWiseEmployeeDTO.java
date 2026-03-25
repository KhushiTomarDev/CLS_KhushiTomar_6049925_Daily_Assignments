package com.example.Assignment8.Dto;

public class DepartmentWiseEmployeeDTO {
	private long noOfEmployees;
	private String dname;
	public long getNoOfEmployees() {
		return noOfEmployees;
	}
	public void setNoOfEmployees(long noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "DepartmentWiseEmployeeDTO [noOfEmployees=" + noOfEmployees + ", dname=" + dname + "]";
	}
	public DepartmentWiseEmployeeDTO(String dname, long noOfEmployees) {
		super();
		this.noOfEmployees = noOfEmployees;
		this.dname = dname;
	}
	
	
}
