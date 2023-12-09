package com.cboy.common.db;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

/**
 * <a href = https://github.com/brettwooldridge/HikariCP/blob/dev/src/main/java/com/zaxxer/hikari/HikariDataSource.java#LL11>HikariCP DataSource</a>
 * @author yuhangbin
 * @date 2023/10/27
 **/
public class DefaultDataSource implements DataSource {

	private Queue<Connection> unused = new LinkedBlockingQueue<>(100);
	private Queue<Connection> used = new LinkedBlockingQueue<>(100);
	private MySQLProperties properties;

	public DefaultDataSource(MySQLProperties properties) {
		this.properties = properties;
	}

	@Override public Connection getConnection() throws SQLException {
		Connection connection = unused.poll();
		if (connection == null) {
			connection = doGetConnection();
		}
		used.add(connection);
		return connection;
	}

	private Connection doGetConnection() throws SQLException{
		return DriverManager.getConnection(properties.getDatabaseUrl(), properties.getUsername(), properties.getPassword());
	}

	@Override public Connection getConnection(String username, String password) throws SQLException {
		return getConnection();
	}

	@Override public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	@Override public void setLogWriter(PrintWriter out) throws SQLException {

	}

	@Override public void setLoginTimeout(int seconds) throws SQLException {

	}

	@Override public int getLoginTimeout() throws SQLException {
		return 0;
	}

	@Override public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	@Override public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	@Override public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}
}
