package com.hunhun.javaweb.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO {
	
	public void deleteByFlowId(Integer flowId){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql:///hunhun";
			String user = "root";
			String password = "root";
			
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			
			String sql = "delete from examstudent where flow_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, flowId);
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(preparedStatement != null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public List<Student> getAll() {
		
		List<Student> students = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql:///hunhun";
			String user = "root";
			String password = "root";
			
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT flow_id, TYPE, id_card, exam_card,"
					+ " NAME, location, grade FROM examstudent";
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int flowId = resultSet.getInt(1);
				int type = resultSet.getInt(2);
				String idCard = resultSet.getString(3);
				String examCard = resultSet.getString(4);
				String name = resultSet.getString(5);
				String location = resultSet.getString(6);
				int grade = resultSet.getInt(7);
				
				Student student = new Student(flowId, type, idCard, examCard, name, location, grade);
				
				students.add(student);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(resultSet != null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(preparedStatement != null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return students;
	}
}
