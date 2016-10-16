package com.hunhun.mvcapp.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hunhun.mvcapp.db.JdbcUtils;

/**
 * 
 * @author nerve 封装基本CRUD方法，供子类调用 ,此实验中DAO直接获取数据库连接
 * @param <T>：当前DAO处理的实体类类型
 */
public class DAO<T> {

	private QueryRunner queryRunner = new QueryRunner();

	private Class<T> clazz;

	// 反射
	public DAO() {
		Type superClass = getClass().getGenericSuperclass();

		if (superClass instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) superClass;

			Type[] typeArgs = parameterizedType.getActualTypeArguments();
			if (typeArgs != null && typeArgs.length > 0) {
				clazz = (Class<T>) typeArgs[0];
			}
		}
	}

	public <E> E getForValue(String sql, Object... args) {
		Connection connection = null;

		try {
			connection = JdbcUtils.getConnection();
			return (E) queryRunner.query(connection, sql, new ScalarHandler(), args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}

	/**
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getForList(String sql, Object... args) {
		Connection connection = null;

		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}

	/**
	 * 返回T对应实体类的一条查询结果
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql, Object... args) {
		Connection connection = null;

		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}

	/**
	 * 该方法包含 INSERT， DELEDT， UPDATE
	 * 
	 * @param sql:
	 *            SQL语句
	 * @param args：
	 *            添加SQL占位符
	 */
	public void update(String sql, Object... args) {
		Connection connection = null;

		try {
			connection = JdbcUtils.getConnection();
			queryRunner.update(connection, sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.releaseConnection(connection);
		}
	}
}
