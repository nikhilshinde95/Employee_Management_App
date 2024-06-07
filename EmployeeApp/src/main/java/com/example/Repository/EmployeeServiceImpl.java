package com.example.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.entities.Employee;
import com.example.service.EmployeeService;

import lombok.Getter;
import lombok.Setter;

@Repository
@Primary
public class EmployeeServiceImpl implements EmployeeService {

    @Getter
    @Setter
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addEmployee(Employee employee) {
       String query="insert into employee(id,name,city) values(?,?,?)";
       jdbcTemplate.update(query,employee.getId(),employee.getName(),employee.getCity());
    }

    @Override
    public void updateEmployee(Employee employee) {
        String query="update employee set name=?, city=? where id=?";
        jdbcTemplate.update(query, employee.getName(),employee.getCity(),employee.getId());
    }

    @Override
    public void deleteEmployee(long employeeid) {
        String query="delete from employee where id=?";
        jdbcTemplate.update(query,employeeid);
    }

    @Override
    public Employee getEmployee(long employeeid) {
        String query="select * from employee where id=?";
        return jdbcTemplate.queryForObject(query, new Object[]{employeeid},new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public List<Employee> getAllEmployee() {
        String query="select * from employee";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Employee.class));
    }
    
}
