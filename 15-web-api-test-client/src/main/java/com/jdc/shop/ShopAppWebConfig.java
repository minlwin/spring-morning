package com.jdc.shop;

import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableJpaRepositories
@EnableTransactionManagement
@ComponentScan(basePackages = {
		"com.jdc.shop.api", "com.jdc.shop.model"
})
public class ShopAppWebConfig implements WebMvcConfigurer{

	@Bean
	EmbeddedDatabase dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.build();
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		var bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource);
		bean.setPackagesToScan("com.jdc.shop.model.entity");
		bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		bean.setJpaPropertyMap(Map.of(
			"hibernate.hbm2ddl.auto", "create",
			"hibernate.show_sql", "true",
			"hibernate.format_sql", "true"
		));
		return bean;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
