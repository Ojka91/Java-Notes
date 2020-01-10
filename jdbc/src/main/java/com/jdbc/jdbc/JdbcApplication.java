package com.jdbc.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class JdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);

		//1. Create connection chain
		String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";  //we need to include parameters after '?'

		try {
			//2. Connection object to db
			Connection connection = DriverManager.getConnection(url, "root", "admin");

			/**
			 * Statement: Compile query each time - no cache (better use for only one call)
			 * PreparedStatement: Only compile query one time -save it on cache(better use if needs to repeat the query)
			 * CallableStatement: Call procedures
			 */
			//3. Create Statement
			Statement statement = connection.createStatement();

			//4. Creare query
			String sql = "select id_person, name, surname, email, phone from person";

			/**
			 * executeQuery: SELECT - Return ResultSet Object
			 * executeUpdate: DML/DDL - Return int (number registers affected)(insert, update delete, create table, truncate....)
			 * execute: Any SQL sentence - Return boolean
			 */
			//5. Execute query
			ResultSet resultSet = statement.executeQuery(sql);

			//6. Work the results
			while(resultSet.next()){
				System.out.println("ID: " + resultSet.getInt(1));
				System.out.println("Name: " + resultSet.getString(2));
				System.out.println("Surname: " + resultSet.getString(3));
				System.out.println("Email: " + resultSet.getString(4));
				System.out.println("Phone: " + resultSet.getString(5));
			}

			//7. Close connection objects
			resultSet.close();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}

	}

}
