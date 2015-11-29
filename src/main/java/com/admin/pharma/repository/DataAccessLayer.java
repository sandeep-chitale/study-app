package com.admin.pharma.repository;

import com.admin.pharma.config.DatabaseConfig;
import com.admin.pharma.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;


/**
 * Created by DELL on 11/29/2015.
 */
@Component
@Getter
@Setter
public class DataAccessLayer {

    public DataAccessLayer(){}
    private JdbcTemplate template;

    @Autowired
    DatabaseConfig dbConfig;

    @Bean
    @Singleton
    public JdbcTemplate getJDBCTemplate() {
        if(template == null)
            template =new JdbcTemplate(dbConfig.getDBDatasource());
        return template;
    }

}
