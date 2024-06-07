package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Employee;
import com.example.service.EmployeeService;

@RestController
public class MyController {


    @Autowired
    @Qualifier("employeeServiceImpl") 
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeid}")
    public void deleteEmployee(@PathVariable long employeeid){
        employeeService.deleteEmployee(employeeid);
    }

    @GetMapping("/employees/{employeeid}")
    public Employee getEmployee(@PathVariable long employeeid){
        return employeeService.getEmployee(employeeid);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){

        return employeeService.getAllEmployee();
    }


    
}
