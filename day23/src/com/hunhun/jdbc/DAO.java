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
	// insert update delete ����
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

	// ��ѯһ����¼�����ض�Ӧ����
	public <T> T get(Class<T> clazz, String sql, Object... args) {
		List<T> result = getForList(clazz, sql, args);
		if (result.size() > 0) {
			return result.get(0); // ��Ϊֻ��ѯһ�����ݣ���List��ֻ��һ������
		}
		return null;
	}

	// ��ѯ������¼���ѽ���洢ΪList
	public <T> List<T> getForList(Class<T> clazz, String sql, Object... args) {

		List<T> list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// 1.�õ������
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();

			// 2.�����������õ�Map��List������һ��Map�������һ����¼
			// Map��keyΪResultSet���еı�����valueΪ�е�ֵ
			List<Map<String, Object>> values = handleResultSetToMapList(resultSet);

			// 3.��Map��ListתΪclazz��Ӧ��List
			// ����Map��key��Ϊclazz��Ӧ�Ķ����propertyName;
			// Map��value��Ϊclazz��Ӧ�����propertyValue
			list = transfterMapListToBeanList(clazz, values);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}

		return list;
	}

	/**
	 * ��MapList���뵽BeanList�У�����List
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
					
					//֮ǰ���õ�ReflectionUtil��������BeanUtils��������ֵ
					BeanUtils.setProperty(bean, propertyName, value);
				}

				result.add(bean);
			}
		}
		return result;
	}

	/**
	 * ��ResultSet����MapList��
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
	 * ��ȡ�������ColumnLable ��Ӧlist
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

		// 1.�õ�������������ֻ��һ��һ��

		// 2.ȡ�ý����
		return null;
	}
}
