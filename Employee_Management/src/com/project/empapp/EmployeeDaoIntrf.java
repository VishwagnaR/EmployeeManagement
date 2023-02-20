package com.project.empapp;

public interface EmployeeDaoIntrf {

	//Create Employee
	
	public void createEmployee(Employee emp);
	
	//Show all employee
	
	public void showAllEmployee();
	
	//Show employee based on id
	
	public void showEmployeeBasedOnId(int id);
	
	//Update employee
	
	public void updateEmployee(int id, String name);
	
	//Delete employee
	
	public void deleteEmployee(int id);
}
