package com.jdc.spring.conf;

import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableJpaRepositories(
		basePackages = "com.jdc.spring.model.repo", 
		transactionManagerRef = "transactionManager")
@ComponentScan(basePackages = {
		"com.jdc.spring.controller",
		"com.jdc.spring.model.service"
})
public class ApplicationConfig implements WebMvcConfigurer{

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
