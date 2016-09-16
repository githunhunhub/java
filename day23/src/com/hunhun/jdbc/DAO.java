package com.hunhun.jdbc;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class DAO {
	// insert update delete 操作
	public void update(String sql, Object... args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}

			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(null, preparedStatement, connection);
		}
	}

	// 查询一条记录，返回对应对象
	public <T> T get(Class<T> clazz, String sql, Object... args) {
		List<T> result = getForList(clazz, sql, args);
		if (result.size() > 0) {
			return result.get(0); // 因为只查询一条数据，即List中只有一条数据
		}
		return null;
	}

	// 查询多条记录，把结果存储为List
	public <T> List<T> getForList(Class<T> clazz, String sql, Object... args) {

		List<T> list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// 1.得到结果集
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();

			// 2.处理结果集，得到Map的List，其中一个Map对象就是一条记录
			// Map的key为ResultSet中列的别名，value为列的值
			List<Map<String, Object>> values = handleResultSetToMapList(resultSet);

			// 3.把Map的List转为clazz对应的List
			// 其中Map的key即为clazz对应的对象的propertyName;
			// Map的value即为clazz对应对象的propertyValue
			list = transfterMapListToBeanList(clazz, values);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}

		return list;
	}

	/**
	 * 把MapList传入到BeanList中，返回List
	 * 
	 * @param clazz
	 * @param values
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public <T> List<T> transfterMapListToBeanList(Class<T> clazz, List<Map<String, Object>> values)
			throws InstantiationException, IllegalAccessException, InvocationTargetException {

		List<T> result = new ArrayList<>();

		T bean = null;

		if (values.size() > 0) {
			for (Map<String, Object> m : values) {
				bean = clazz.newInstance();
				for (Map.Entry<String, Object> entry : m.entrySet()) {
					String propertyName = entry.getKey();
					Object value = entry.getValue();
					
					//之前采用的ReflectionUtil，这里用BeanUtils来给对象赋值
					BeanUtils.setProperty(bean, propertyName, value);
				}

				result.add(bean);
			}
		}
		return result;
	}

	/**
	 * 把ResultSet传到MapList中
	 * 
	 * @param resultSet
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> handleResultSetToMapList(ResultSet resultSet) throws SQLException {
		List<Map<String, Object>> values = new ArrayList<>();

		List<String> columeLabels = getColumnLabels(resultSet);

		Map<String, Object> map = null;

		while (resultSet.next()) {
			map = new HashMap<>();

			for (String columnLable : columeLabels) {
				Object value = resultSet.getObject(columnLable);
				map.put(columnLable, value);
			}
			values.add(map);
		}
		return values;
	}

	/**
	 * 获取结果集的ColumnLable 对应list
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private List<String> getColumnLabels(ResultSet rs) throws SQLException {
		List<String> labels = new ArrayList<>();

		ResultSetMetaData rsmd = rs.getMetaData();
		for (int i = 0; i < rsmd.getColumnCount(); i++) {
			labels.add(rsmd.getColumnLabel(i + 1));
		}

		return labels;
	}

	public <E> E getForValues(String sql, Object... args) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return (E) resultSet.getObject(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}

		// 1.得到结果集：结果集只有一行一列

		// 2.取得结果集
		return null;
	}
}
