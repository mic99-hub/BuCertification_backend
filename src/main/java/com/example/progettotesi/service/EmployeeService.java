package com.example.progettotesi.service;

import com.example.progettotesi.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> searchEmployees(String query);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id );
    Employee updateEmployee(Employee employee ,Long id );
    void deleteEmployee(long id);




}
