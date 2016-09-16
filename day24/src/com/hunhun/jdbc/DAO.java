package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 访问数据的 DAO 接口 , 里边定定义好访问 Table 的各种方法
 * 
 * @author nerve
 * @param T:
 *            DAO处理的实体的类型
 *
 */
public interface DAO<T> {
	/**
	 * the method of batch process
	 * 
	 * @param connection
	 * @param sql
	 * @param args
	 */
	void batch(Connection connection, String sql, Object[]... args);

	/**
	 * return a specific value, like value of name, salary
	 * 
	 * @param connection
	 * @param sql
	 * @param args
	 * @return
	 */
	<E> E getForValue(Connection connection, String sql, Object... args);

	/**
	 * return the object of T for list
	 * 
	 * @param connection
	 * @param sql
	 * @param args
	 * @return
	 */
	List<T> getForList(Connection connection, String sql, Object... args);

	/**
	 * return just one object of T
	 * 
	 * @param connection
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException 
	 */
	T get(Connection connection, String sql, Object... args) throws SQLException;

	/**
	 * INSERT, UPDADTE, DELECTE
	 * 
	 * @param connection:
	 *            connection with DataBase
	 * @param sql:
	 *            SQL sentence
	 * @param args:
	 *            use args to take place of "?"
	 */
	void update(Connection connection, String sql, Object... args);
}
