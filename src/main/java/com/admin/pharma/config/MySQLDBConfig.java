package com.admin.pharma.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by DELL on 11/29/2015.
 */

@Configuration
//@Profile("dev")
public class MySQLDBConfig implements DatabaseConfig {

    @Bean
    public DataSource getDBDatasource() {
        DriverManagerDataSource toReturn = new DriverManagerDataSource("jdbc:mysql://localhost/adminpharma",
                "root", "root");
        toReturn.setDriverClassName("com.mysql.jdbc.Driver");
        return toReturn;
    }
}