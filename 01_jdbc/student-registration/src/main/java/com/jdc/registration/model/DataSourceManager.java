package com.jdc.registration.model;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSourceManager {

	private static final String URL = "jdbc:mysql://localhost:3306/demo_db";
	private static final String USER = "demousr";
	private static final String PASS = "demopass";

	public static DataSource getDataSource() {
		var ds = new BasicDataSource();
		ds.setUrl(URL);
		ds.setUsername(USER);
		ds.setPassword(PASS);
		return ds;
	}
}
