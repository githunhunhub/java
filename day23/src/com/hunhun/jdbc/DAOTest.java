package com.hunhun.jdbc;

import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.List;

import org.junit.Test;

public class DAOTest {
	
	DAO dao = new DAO();
	
	@Test
	public void testUpdate() {
		String sql = "insert into customer(name, email, birth) values(?,?,?)";
			
		dao.update(sql, "ะกร๗","xiao@123.com", new Date(new java.util.Date().getTime()));
	}

	
	@Test
	public void testGet() {
		String sql = "select flow_id flowId, type, exam_card examCard, id_card idCard, name, location, grade from examstudent where flow_id = ?";
		Student student = dao.get(Student.class, sql, 5);
		System.out.println(student);
	}

	
	@Test
	public void testGetForList() {
		String sql = "select flow_id flowId, type, exam_card examCard, id_card idCard, name, location, grade from examstudent";
		
		List<Student> students = dao.getForList(Student.class, sql);
		System.out.println(students);
	}

	
	@Test
	public void testGetForValues() {
		String sql = "select exam_card from examstudent where flow_id = ?";;
		
		String examCard = dao.getForValues(sql, 5);
		System.out.println(examCard);
		
		sql = "select max(grade) from examstudent";
		int grade = dao.getForValues(sql);
		System.out.println(grade);
	}

}
