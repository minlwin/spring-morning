package com.jdc.registration;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSourceManager {

	private static final String URL = "jdbc:mysql://localhost:3306/registrations";
	private static final String USER = "registrations";
	private static final String PASS = "registrations";

	public static DataSource getDataSource() {
		var ds = new BasicDataSource();
		ds.setUrl(URL);
		ds.setUsername(USER);
		ds.setPassword(PASS);
		return ds;
	}
}
