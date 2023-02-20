package com.project.empapp;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		EmployeeDaoIntrf dao = new EmployeeDaoImpl();

		int id;
		String name;

		System.out.println("Welcome to Employee management application\n");

		Scanner sc = new Scanner(System.in);

		do {

			System.out.println("1. Add Employee\n" + "2. Show All Employee\n" + "3. Show Employee based on id \n"
					+ "4. Update Employee\n" + "5. Delete Employee\n");

			System.out.println("Enter Choice: ");
		
			int choice = sc.nextInt();

			switch(choice) {

			case 1:

				Employee emp = new Employee();

				System.out.println("Enter ID");
				id = sc.nextInt();

				System.out.println("Enter Name");
				name = sc.next();

				System.out.println("Enter Salary");
				double salary = sc.nextDouble();

				System.out.println("Enter Age");
				int age = sc.nextInt();

				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				emp.setAge(age);

				dao.createEmployee(emp);
				break;

			case 2:

				dao.showAllEmployee();

				break;

			case 3:

				System.out.println("Enter the employee Id");
				id = sc.nextInt();

				dao.showEmployeeBasedOnId(id);

				break;

			case 4:

				System.out.println("Enter the employee Id");
				id = sc.nextInt();

				System.out.println("Enter the new name");
				name = sc.next();

				dao.updateEmployee(id, name);

				break;

			case 5:

				System.out.println("Enter the employee id you want to delete");
				id = sc.nextInt();

				dao.deleteEmployee(id);

				break;

			case 6:
				System.out.println("Thank you for using our Application !!! ");
				System.exit(0);
				break;

			default:
				System.out.println("Enter the valid input!!! \n ");
				break;
			}
			
		} while (true);

	}
}
