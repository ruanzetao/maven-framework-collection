package com.javaTCs;

import utilities.MySQLUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTestConnection {

	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		return MySQLUtils.getMySQLConnection();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("Get connection...");
		Connection connection = MySQLTestConnection.getMyConnection();
		System.out.println("Open connection...");
		Statement statement = connection.createStatement();
		String sql = "Select Emp.Emp_Id, Emp.First_Name, Emp.Last_Name,Emp.Dept_Id from Employee Emp;";
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			int empId = rs.getInt(1);
			String empFirstName = rs.getString(2);
			String empLastName = rs.getString("Last_Name");
			System.out.println("Emp id: " + empId);
			System.out.println("Emp Firstname: " + empFirstName);
			System.out.println("Emp Lastname: " + empLastName);
		}
		connection.close();
		System.out.println("Close connection.");
	}

}
