package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * sql执行的任务
 */
public class Test2 {

	public void queryAll(String sql) throws SQLException {
		Connection conn = Test.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		//

		// 释放资源
		Test.free(conn, stat, rs);

	}

	// 批量插入
	public void insertEmpBatch() throws SQLException {
		Connection conn = Test.getConnection();
		conn.setAutoCommit(false);
		String sql = "insert into myemp values(?,?)";
		// 也可以批量修改、删除，只需要修改sql语句
		PreparedStatement stat = conn.prepareStatement(sql);

		for (int i = 0; i < 50; i++) {
			stat.setInt(1, i);
			stat.setString(2, "name" + i);

			stat.addBatch(); // 添加批量操作的方法
		}
		stat.executeBatch(); // 执行批量操作
		conn.commit(); // 批量提交

		Test.free(conn, stat, null);
	}

	public static void main(String[] args) {
		Test2 obj = new Test2();

		try {
			obj.insertEmpBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
