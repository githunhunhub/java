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
			
			//1.得到ResultSetMetaData对象
			ResultSetMetaData rsmd = resultSet.getMetaData();
			
			while(resultSet.next()){
				
				//2.遍历每列的列名
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
		//查询Customer表
		String sql = "select id, name, email, birth"
				+ " from customer where id = ?";
		
		Customer customer = get(Customer.class, sql, 5);
		System.out.println(customer);
		
		//查询examstudent表
		sql = "select flow_id flowId,type, id_card idCard, exam_card examCard, name, location, grade"
				+ " from examstudent where flow_id = ?";
		
		Student student = get(Student.class, sql, 10);
		System.out.println(student);
		
	}

	/*
	 * 通用查询方法，根据传入SQL、class对象返回SQL对应语句
	 * 
	 * @ param clazz:描述对象类型
	 * 
	 * @ param sql:SQL语句，可以带占位符
	 * 
	 * @param args：填充占位符的可变参数
	 * 
	 * @return
	 */
	public <T> T get(Class<T> clazz, String sql, Object... args) {
		T entity = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// 1.得到ResultSet对象
			connection = JDBCTool.getConnection2();
			preparedStatement = connection.prepareStatement(sql);
			// 1.1为为Object的args赋值
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i+1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();
			
			// 2.得到ResultSetMetaData对象
			ResultSetMetaData rsmd = resultSet.getMetaData();
			
			// 3.创建一个Map<Strirng, Object>对象，键String：SQL查询列的别名，Object值：列的值
			Map<String, Object> values = new HashMap<>();
			
			// 4.处理结果集，利用ResultSetMetaData(结果集元数据)填充3对应Map对象
			if(resultSet.next()){
				for(int i=0; i<rsmd.getColumnCount(); i++){
					String columnLabel = rsmd.getColumnLabel(i+1);
					Object columnValue = resultSet.getObject(i+1);
					
					values.put(columnLabel, columnValue);
				}
			}
			
			// 5.若Map不为空，利用反射创建clazz对应的对象
			if(values.size()>0){
				entity = clazz.newInstance();
				
				// 5.1遍历Map对象，利用反射为clazz对象的对应属性赋值
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
	// Statement存在SQL注入，但PreparedStatement不存在此问题
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
				System.out.println("登陆成功！");
			} else {
				System.out.println("用户名或密码错误！");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTool.release(resultSet, preparedStatement, connection);
		}
	}

	@Test
	// Statement存在SQL注入，但PreparedStatement不存在此问题
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
				System.out.println("登陆成功！");
			} else {
				System.out.println("用户名或密码错误！");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTool.release(statement, connection);
		}
	}

	/*
	 * PreparedStatement使用
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
	 * 获得学生具体信息
	 */
	@Test
	public void testGetStudent() {
		// 1.获得查询类型
		int searchType = getSearchTypeFromConsole();

		// 2.具体查询学生信息
		Student student = searchStudent(searchType);

		// 3.打印学生信息
		printStudent(student);

	}

	// 4.打印学生信息
	public void printStudent(Student student) {
		if (student != null) {
			System.out.println("**********");
			System.out.println(student);
		} else {
			System.out.println("未找到相关数据。");
		}
	}

	// 3.从数据库获得学生信息
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

	// 2.根具查询type具体查询学生信息，提示输入身份证号， type2，提示输入考号
	// 构造 SQL 查询语句

	public Student searchStudent(int searchType) {

		String sql = "select flowid, type, idcard, examcard, name, location, grade" + " from examstudent" + " where";

		Scanner scanner = new Scanner(System.in);
		// 根据searchType提示输入信息
		if (searchType == 1) {
			System.out.print("请输入准考证号：");
			String examCard = scanner.next();
			sql = sql + " examCard = '" + examCard + "'";
			System.out.println(sql);
		} else {
			System.out.print("请输入身份证号：");
			String idcard = scanner.next();
			sql = sql + " idcard = '" + idcard + "'";
			System.out.println(sql);
		}

		// 执行查询，把结果封装为Student
		Student student = getStudent(sql);

		return student;
	}

	// 1.从控制台读入整数，确定查询Type
	public int getSearchTypeFromConsole() {
		System.out.print("输入查询类型：1是考号查询，2是身份证号查询 :");

		Scanner scanner = new Scanner(System.in);
		int type = scanner.nextInt();

		if (type != 1 && type != 2) {
			System.out.println("输入有误，重新输入");
			throw new RuntimeException();
		}
		return type;
	}

	/*
	 * 添加学生到数据库
	 */
	@Test
	public void testAddStudent() {
		Student student = getStudentFromConsole();
		// addNewStudent(student);
		addNewStudent2(student);
	}

	// 从屏幕获取各列值
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

	// 1.准备的SQL语句
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

		// 2.调用JDBCTool类的update
		JDBCTool.update(sql);
	}
}
