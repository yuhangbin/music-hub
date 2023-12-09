package com.cboy.common.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Enumeration;

/**
 * @author yuhangbin
 * @date 2023/10/27
 **/
public class MySQLTest {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/db0";
	private static final String DB_USER = "yuhangbin";
	private static final String DB_PW = "yuhangbin";

	@Test
	void testMySQLConnection() throws Throwable{
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PW)){
			Assertions.assertNotNull(connection);
		}
	}

	@Test
	void testCreateTable() {

	}


	@Test
	void testInsert() {

	}

	@Test
	void testUpdate() {

	}

	@Test
	void testDelete() {

	}

	@Test
	void testSelect() {

	}
}
