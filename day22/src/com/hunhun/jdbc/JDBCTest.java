package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

public class JDBCTest {
	@Test
	public void testResultSetMetaData() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
//			String sql = "SELECT flow_id flowId, type, id_card idCard, "
//					+ "exam_card examCard, name, "
//					+ "location, grade " 
//					+ "FROM examstudent WHERE flow_id = ?";
			String sql = "select flow_id flowId, type, id_card idCard, "
					+ "exam_card examCard, name, "
					+ "location, grade "
					+ "from examstudent where flow_id = ?";
//			System.out.println(sql);
			
			connection = JDBCTool.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 5);
			
			resultSet = preparedStatement.executeQuery();
			
			Map<String, Object> values = new HashMap<String, Object>();
			
			//1.�õ�ResultSetMetaData����
			ResultSetMetaData rsmd = resultSet.getMetaData();
			
			while(resultSet.next()){
				
				//2.����ÿ�е�����
				for(int i=0; i<rsmd.getColumnCount(); i++){
					String columLable = rsmd.getColumnLabel(i+1);
					Object columValue = resultSet.getObject(columLable);
					
					values.put(columLable, columValue);
				}
			}
			
			System.out.println("*******"+values+"******");
			Class clazz = Student.class;
			
			Object object = clazz.newInstance();
			for(Map.Entry<String, Object> entry : values.entrySet()){
				String filedName = entry.getKey();
				Object filedValue = entry.getValue();
				
				System.out.println(filedName + ": "+ filedValue);
				
				ReflectionUtils.setFieldValue(object, filedName, filedValue);
			}
			
			System.out.println("####"+object);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTool.release(resultSet, preparedStatement, connection);
		}
	}

	
	
	@Test
	public void testGet() {
		//��ѯCustomer��
		String sql = "select id, name, email, birth"
				+ " from customer where id = ?";
		
		Customer customer = get(Customer.class, sql, 5);
		System.out.println(customer);
		
		//��ѯexamstudent��
		sql = "select flow_id flowId,type, id_card idCard, exam_card examCard, name, location, grade"
				+ " from examstudent where flow_id = ?";
		
		Student student = get(Student.class, sql, 10);
		System.out.println(student);
		
	}

	/*
	 * ͨ�ò�ѯ���������ݴ���SQL��class���󷵻�SQL��Ӧ���
	 * 
	 * @ param clazz:������������
	 * 
	 * @ param sql:SQL��䣬���Դ�ռλ��
	 * 
	 * @param args�����ռλ���Ŀɱ����
	 * 
	 * @return
	 */
	public <T> T get(Class<T> clazz, String sql, Object... args) {
		T entity = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// 1.�õ�ResultSet����
			connection = JDBCTool.getConnection2();
			preparedStatement = connection.prepareStatement(sql);
			// 1.1ΪΪObject��args��ֵ
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i+1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();
			
			// 2.�õ�ResultSetMetaData����
			ResultSetMetaData rsmd = resultSet.getMetaData();
			
			// 3.����һ��Map<Strirng, Object>���󣬼�String��SQL��ѯ�еı�����Objectֵ���е�ֵ
			Map<String, Object> values = new HashMap<>();
			
			// 4.��������������ResultSetMetaData(�����Ԫ����)���3��ӦMap����
			if(resultSet.next()){
				for(int i=0; i<rsmd.getColumnCount(); i++){
					String columnLabel = rsmd.getColumnLabel(i+1);
					Object columnValue = resultSet.getObject(i+1);
					
					values.put(columnLabel, columnValue);
				}
			}
			
			// 5.��Map��Ϊ�գ����÷��䴴��clazz��Ӧ�Ķ���
			if(values.size()>0){
				entity = clazz.newInstance();
				
				// 5.1����Map�������÷���Ϊclazz����Ķ�Ӧ���Ը�ֵ
				for(Map.Entry<String, Object> entry : values.entrySet()){
					String fieldName = entry.getKey();
					Object value = entry.getValue();
					
					ReflectionUtils.setFieldValue(entity, fieldName, value);
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTool.release(resultSet, preparedStatement, connection);
		}

		return entity;
	}

	public Customer getCustomemr(String sql, Object... args) {
		Customer customer = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTool.getConnection2();

			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				customer = new Customer();
				customer.setId(resultSet.getInt(1));
				customer.setName(resultSet.getString(2));
				customer.setEmail(resultSet.getString(3));
				customer.setBirth(resultSet.getDate(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTool.release(resultSet, preparedStatement, connection);
		}

		return customer;
	}

	@Test
	// Statement����SQLע�룬��PreparedStatement�����ڴ�����
	public void testSQLInjection2() {
		String username = "a' or password = ";
		String password = " or '1' = '1";

		String sql = "select * from users where username = ? " + "and password = ?";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTool.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				System.out.println("��½�ɹ���");
			} else {
				System.out.println("�û������������");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTool.release(resultSet, preparedStatement, connection);
		}
	}

	@Test
	// Statement����SQLע�룬��PreparedStatement�����ڴ�����
	public void testSQLInjection() {

		// String username ="Tom";
		// String password = "12345";

		String username = "a' or password = ";
		String password = " or '1' = '1";

		String sql = "select * from users where username = '" + username + "' and" + " password = '" + password + "'";

		System.out.println(sql);

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCTool.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				System.out.println("��½�ɹ���");
			} else {
				System.out.println("�û������������");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTool.release(statement, connection);
		}
	}

	/*
	 * PreparedStatementʹ��
	 */
	@Test
	public void testPreparedStatement() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JDBCTool.getConnection2();
			String sql = "insert into customer(name, email, birth)" + " values(?,?,?)";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "HUNHUN");
			preparedStatement.setString(2, "123@sdfd.com");
			preparedStatement.setDate(3, new Date(new java.util.Date().getTime()));

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTool.release(preparedStatement, connection);
		}

	}

	/*
	 * ���ѧ��������Ϣ
	 */
	@Test
	public void testGetStudent() {
		// 1.��ò�ѯ����
		int searchType = getSearchTypeFromConsole();

		// 2.�����ѯѧ����Ϣ
		Student student = searchStudent(searchType);

		// 3.��ӡѧ����Ϣ
		printStudent(student);

	}

	// 4.��ӡѧ����Ϣ
	public void printStudent(Student student) {
		if (student != null) {
			System.out.println("**********");
			System.out.println(student);
		} else {
			System.out.println("δ�ҵ�������ݡ�");
		}
	}

	// 3.�����ݿ���ѧ����Ϣ
	private Student getStudent(String sql) {
		Student stu = null;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCTool.getConnection2();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				stu = new Student(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTool.release(resultSet, statement, connection);
		}

		return stu;
	}

	// 2.���߲�ѯtype�����ѯѧ����Ϣ����ʾ�������֤�ţ� type2����ʾ���뿼��
	// ���� SQL ��ѯ���

	public Student searchStudent(int searchType) {

		String sql = "select flowid, type, idcard, examcard, name, location, grade" + " from examstudent" + " where";

		Scanner scanner = new Scanner(System.in);
		// ����searchType��ʾ������Ϣ
		if (searchType == 1) {
			System.out.print("������׼��֤�ţ�");
			String examCard = scanner.next();
			sql = sql + " examCard = '" + examCard + "'";
			System.out.println(sql);
		} else {
			System.out.print("���������֤�ţ�");
			String idcard = scanner.next();
			sql = sql + " idcard = '" + idcard + "'";
			System.out.println(sql);
		}

		// ִ�в�ѯ���ѽ����װΪStudent
		Student student = getStudent(sql);

		return student;
	}

	// 1.�ӿ���̨����������ȷ����ѯType
	public int getSearchTypeFromConsole() {
		System.out.print("�����ѯ���ͣ�1�ǿ��Ų�ѯ��2�����֤�Ų�ѯ :");

		Scanner scanner = new Scanner(System.in);
		int type = scanner.nextInt();

		if (type != 1 && type != 2) {
			System.out.println("����������������");
			throw new RuntimeException();
		}
		return type;
	}

	/*
	 * ���ѧ�������ݿ�
	 */
	@Test
	public void testAddStudent() {
		Student student = getStudentFromConsole();
		// addNewStudent(student);
		addNewStudent2(student);
	}

	// ����Ļ��ȡ����ֵ
	private Student getStudentFromConsole() {
		Scanner scanner = new Scanner(System.in);

		Student student = new Student();

		System.out.print("FlowID");
		student.setFlowId(scanner.nextInt());

		System.out.print("Type");
		student.setType(scanner.nextInt());

		System.out.print("IDCard");
		student.setIdCard(scanner.next());

		System.out.print("ExamCard");
		student.setExamCard(scanner.next());

		System.out.print("Name");
		student.setName(scanner.next());

		System.out.print("Location");
		student.setLocation(scanner.next());

		System.out.print("Grade");
		student.setGrade(scanner.nextInt());

		return student;
	}

	// 1.׼����SQL���
	public void addNewStudent2(Student student) {
		String sql = "insert into examstudent(flowid,type," + "idcard,examcard,name,location,grade)"
				+ "values(?,?,?,?,?,?,?)";

		JDBCTool.update(sql, student.getFlowId(), student.getType(), student.getIdCard(), student.getExamCard(),
				student.getName(), student.getLocation(), student.getGrade());
	}

	public void addNewStudent(Student student) {

		String sql = "insert into examstudent values(" + student.getFlowId() + "," + student.getType() + ",'"
				+ student.getIdCard() + "','" + student.getExamCard() + "','" + student.getName() + "','"
				+ student.getLocation() + "'," + student.getGrade() + ")";

		System.out.println(sql);

		// 2.����JDBCTool���update
		JDBCTool.update(sql);
	}
}
