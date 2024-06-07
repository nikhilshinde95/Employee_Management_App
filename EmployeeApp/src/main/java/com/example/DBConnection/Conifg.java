package com.example.DBConnection;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.Repository.EmployeeServiceImpl;
import com.example.service.EmployeeService;

@Configuration
@ComponentScan(basePackages={"com.example.Repository"})
public class Conifg {

    @Bean(name={"ds"})
    public DataSource getDataSource(){

         DriverManagerDataSource ds = new DriverManagerDataSource();
         ds.setDriverClassName("org.postgresql.Driver"); 
         ds.setUrl("jdbc:postgresql://localhost:5432/College");
         ds.setUsername("postgres");
         ds.setPassword("root");
         return ds;
    }

    @Bean(name={"jdbcTemplate"})
    public JdbcTemplate getTemplate(){
        JdbcTemplate template=new JdbcTemplate();
        template.setDataSource(getDataSource());
        return template;
    }

    @Bean(name={"employeeDao"})
    public EmployeeService getEmployee(){
        EmployeeServiceImpl emp=new EmployeeServiceImpl();
        emp.setJdbcTemplate(getTemplate());
        return emp;

    }

    
}
