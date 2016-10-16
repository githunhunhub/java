package com.hunhun.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet3 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//htmlҳ��ͨ�� submit�ύ�� post�������ݣ�����user��password
		String user = req.getParameter("user");
		String password = req.getParameter("password");

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		PrintWriter out = resp.getWriter();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql:///hunhun";
			String user1 = "root";
			String password1 = "root";
			connection = DriverManager.getConnection(url, user1, password1);

			// count(id) ����ѡ���ķ��� id �������˴�����з��ϵ�username��password��count(id)=1,
			// ����=0
			String sql = "select count(id) from users where username = ? and password = ?";

			statement = connection.prepareStatement(sql);
			statement.setString(1, user);
			statement.setString(2, password);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				int count = resultSet.getInt(1);	//���count(id)��һ�е�ֵ���� 0 �� 1

				if (count > 0) {
					out.println("Hello: " + user);
				} else {
					out.print("Sorry: " + user);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
