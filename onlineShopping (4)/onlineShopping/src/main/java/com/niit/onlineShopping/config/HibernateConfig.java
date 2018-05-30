package com.niit.onlineShopping.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"com.niit.onlineShopping.model"})
@EnableTransactionManagement
public class HibernateConfig {
	
	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		System.out.println("Hibernate Initiated...");
		BasicDataSource datasource=new BasicDataSource();
		
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:~/onlineShopping");
		datasource.setUsername("sa");
		datasource.setPassword("");
		return datasource;
	}

	@Bean
	public SessionFactory getSessionFactory(DataSource datasource)
	{
		System.out.println("SESSION FACTORY Initiated...");
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(datasource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.niit.onlineShopping.model");
		System.out.println("SessionFactory Bean Created");
		return builder.buildSessionFactory();
	}	
	
	private Properties getHibernateProperties()
	{
		System.out.println("Hibernate PROPS Initiated...");
		Properties p = new Properties();
		p.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		p.put("hibernate.show_sql", "true");
		p.put("hibernate.format_sql", "true");
		p.put("hibernate.hbm2ddl.auto", "update");
		return p;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionfactory)
	{
		System.out.println("TMANAGER...");
		HibernateTransactionManager tm = new HibernateTransactionManager(sessionfactory);
		return tm;
	}

}
