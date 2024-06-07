package com.example.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.entities.Employee;

public class RowMapperImpl implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee emp=new Employee();
        emp.setId(rs.getInt(1));
        emp.setName(rs.getString(2));
        emp.setCity(rs.getString(3));
        return emp;
    }

    
    
}
