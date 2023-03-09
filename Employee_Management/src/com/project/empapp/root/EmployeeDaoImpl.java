package com.project.empapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDaoIntrf {

	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet res;

	@Override
	public void createEmployee(Employee emp) {

		con = DBConnection.createDBConnection();

		String sql = "insert into employee values(?,?,?,?)";
		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setDouble(3, emp.getSalary());
			pstmt.setInt(4, emp.getAge());

			int row = pstmt.executeUpdate();

			System.out.println(row + " row affected \n");

		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("hi");
		}
	}

	@Override
	public void showAllEmployee() {

		con = DBConnection.createDBConnection();

		String sql = "select * from employee";

		try {

			stmt = con.createStatement();

			res = stmt.executeQuery(sql);

			while (res.next() == true) {
				System.out.println("Id : " + res.getInt(1));
				System.out.println("Name : " + res.getString(2));
				System.out.println("Salary : " + res.getInt(3));
				System.out.println("Age : " + res.getInt(4));

				System.out.println("--------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showEmployeeBasedOnId(int id) {

		con = DBConnection.createDBConnection();

		String sql = "select * from employee where id = ?";

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);

			res = pstmt.executeQuery();

			while (res.next() == true) {

				System.out.println("Id : " + res.getInt(1));
				System.out.println("Name : " + res.getString(2));
				System.out.println("Salary : " + res.getInt(3));
				System.out.println("Age : " + res.getInt(4));

				System.out.println("--------------------\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(int id, String name) {

		con = DBConnection.createDBConnection();

		String sql = "update employee set name = ? where id = ?";

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, id);

			int row = pstmt.executeUpdate();
			
			System.out.println(row + " row affected/n");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEmployee(int id) {
		
		con = DBConnection.createDBConnection();
		
		String sql = "Delete from employee where id = ?";
		
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			int row = pstmt.executeUpdate();
	
			System.out.println(row + " row affected\n");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
