package com.jdc.test.utils;

import java.sql.SQLException;

import com.jdc.registration.DataSourceManager;

public class DbUtils {

	public static void execute(String... sqls) {

		try (var conn = DataSourceManager.getDataSource().getConnection(); 
				var stmt = conn.createStatement()) {
			
			for(var sql : sqls) {
				stmt.execute(sql);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void truncate(String... tables) {
		try (var conn = DataSourceManager.getDataSource().getConnection(); 
				var stmt = conn.createStatement()) {
			
			stmt.execute("set foreign_key_checks = 0");
			
			for(var table : tables) {
				stmt.execute("truncate table %s".formatted(table));
			}

			stmt.execute("set foreign_key_checks = 1");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
