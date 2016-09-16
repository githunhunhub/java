package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * JDBC ��������
 */
public class TestJDBCInsert {
	public static void main(String[] args) {
		try {
			// 1.������Ӧ���ݿ��driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.�����ݿ⽨�����ӣ�
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			// 3.��Ҫִ�е�sql���,���в����ĸ��Ӳ�ѯ
			String sql = "insert into emp values(?,?,?,?)";
			
			// 4.�Դ��в����Ĳ��룬ʹ��PreparedStatement
			PreparedStatement stat = conn.prepareStatement(sql);
			
			stat.setInt(1, 100);//�Բ������ã�1��ʾ��һ���ʺã�1000��ʾֵ����
			stat.setInt(2, 233333);					 //�������������Ͳ�������Ӧ��set����setString()
			stat.setString(3, "123@abc.com");
			stat.setString(4, "AAA");
			
			// 5.ִ�в���
			int rs = stat.executeUpdate();
			
			//5.�ж����������Ƿ����
			if(rs == 1){
				System.out.println("����ɹ���");
			}else {
				System.out.println("����ʧ�ܣ�");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}