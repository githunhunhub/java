package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * sqlִ�е�����
 */
public class Test2 {

	public void queryAll(String sql) throws SQLException {
		Connection conn = Test.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		//

		// �ͷ���Դ
		Test.free(conn, stat, rs);

	}

	// ��������
	public void insertEmpBatch() throws SQLException {
		Connection conn = Test.getConnection();
		conn.setAutoCommit(false);
		String sql = "insert into myemp values(?,?)";
		// Ҳ���������޸ġ�ɾ����ֻ��Ҫ�޸�sql���
		PreparedStatement stat = conn.prepareStatement(sql);

		for (int i = 0; i < 50; i++) {
			stat.setInt(1, i);
			stat.setString(2, "name" + i);

			stat.addBatch(); // ������������ķ���
		}
		stat.executeBatch(); // ִ����������
		conn.commit(); // �����ύ

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
