package com.jdc.demo;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.jdc.demo")
public class ApplicationConfig {

	// Data Source
	@Bean
	DataSource dataSource() {
		var bean = new HikariDataSource();
		bean.setJdbcUrl("jdbc:mysql://localhost:3306/inheridb");
		bean.setUsername("inheridb");
		bean.setPassword("inheridb");
		return bean;
	}
	
	// EntityManagerFactory Bean
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		var bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource);
		bean.setPackagesToScan("com.jdc.demo.entity");
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		bean.setJpaPropertyMap(Map.of(
			"hibernate.hbm2ddl.auto", "create",
			"hibernate.show_sql", true,
			"hibernate.format_sql", true
		));
		return bean;
	}
	
	// Transaction Manager
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
