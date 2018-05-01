package com.apitore.dao.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.apitore.dao")
public class DaoConfig {

  @Value("${db.driver}")
  private String DB_DRIVER;
  @Value("${db.pass}")
  private String DB_PASS;
  @Value("${db.url}")
  private String DB_URL;
  @Value("${db.user}")
  private String DB_USER;

  @Value("${hibernate.dialect}")
  private String HIBERNATE_DIALECT;
  @Value("${hibernate.show_sql}")
  private String HIBERNATE_SHOWSQL;

  @Value("${entitymanager.packages.to.scan}")
  private String ENTITYMANAGER_PACKAGES_TO_SCAN;


  @Bean(name = "dataSource")
  public DataSource dataSource() {
    BasicDataSource dataSource = new BasicDataSource ();
    dataSource.setDriverClassName(DB_DRIVER);
    dataSource.setUrl(DB_URL);
    dataSource.setUsername(DB_USER);
    dataSource.setPassword(DB_PASS);
    return dataSource;
  }

  @Bean(name = "passwordEncoder")
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(12);
  }

  @Bean(name = "sessionFactory")
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    sessionFactoryBean.setDataSource(dataSource());
    sessionFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
    sessionFactoryBean.setHibernateProperties(hibProperties());
    return sessionFactoryBean;
  }

  private Properties hibProperties() {
    Properties properties = new Properties();
    properties.put("hibernate.dialect", HIBERNATE_DIALECT);
    properties.put("hibernate.show_sql", HIBERNATE_SHOWSQL);
    return properties;
  }

  @Bean(name = "transactionManager")
  public HibernateTransactionManager transactionManager() {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory().getObject());
    return transactionManager;
  }

}
