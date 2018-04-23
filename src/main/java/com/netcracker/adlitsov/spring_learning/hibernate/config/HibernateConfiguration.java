package com.netcracker.adlitsov.spring_learning.hibernate.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com.netcracker.adlitsov.spring_learning.hibernate")
@EnableTransactionManagement
@PropertySource(("classpath:application.properties"))
public class HibernateConfiguration {

    @Autowired
    Environment environment;

    @Autowired
    DataSource dataSource;


    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));

        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory factory) {
        return new HibernateTransactionManager(factory);
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("com.netcracker.adlitsov.spring_learning.hibernate.model");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }
}