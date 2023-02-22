package com.jdc.spring.conf;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@ComponentScan(basePackages = {
		"com.jdc.spring.controller",
		"com.jdc.spring.model.service"
})
@EnableJpaRepositories(
		basePackages = "com.jdc.spring.model.repo", 
		transactionManagerRef = "transactionManager")
public class ApplicationConfig {

	@Bean
	RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
		var adapter = new RequestMappingHandlerAdapter();
		adapter.setMessageConverters(
			List.of(new MappingJackson2HttpMessageConverter())	
		);
		return adapter;
	}
	
	@Bean
	DataSource dataSource() {
		var bean = new BasicDataSource();
		bean.setUrl("jdbc:mysql://localhost:3306/rest_db");
		bean.setUsername("restusr");
		bean.setPassword("restpwd");
		return bean;
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		var bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource);
		bean.setPackagesToScan("com.jdc.spring.model.entity");
		bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		bean.setJpaPropertyMap(Map.of(
				"jakarta.persistence.schema-generation.database.action", "drop-and-create",
				"hibernate.show_sql", true,
				"hibernate.format_sql", true));
		return bean;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		var bean = new JpaTransactionManager();
		bean.setEntityManagerFactory(entityManagerFactory);
		return bean;
	}
}
