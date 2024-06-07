package com.example.service;

import java.util.List;

import com.example.entities.Employee;

public interface EmployeeService {

    public void addEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void deleteEmployee(long employeeid);

    public Employee getEmployee(long employeeid);

    public List<Employee> getAllEmployee();
    
    
}
