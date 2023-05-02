package com.example.progettotesi.service.impl;

import com.example.progettotesi.exception.ResourceNotFoundException;
import com.example.progettotesi.model.Employee;
import com.example.progettotesi.repository.EmployeeRepository;
import com.example.progettotesi.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> searchEmployees(String query) {
        List<Employee> employees = employeeRepository.searchEmployees(query);
        return employees;
    }


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
       // Optional<Employee> employee = employeeRepository.findBy(id);
        // if (employee.isPresent()){
            //return employee.get();
       // }else{
           // throw new ResourceNotFoundException("Employee","Id",id);
        //}
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee","Id",id));
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {

        Employee existingEmployee =employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee","Id",id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        // save existing employee to DB
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {

        // check whether a employee exist in DB or not
        employeeRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Employee","Id",id));

        employeeRepository.deleteById(id);
    }


   // @Test
    //void countMethod(){
       // long count = employeeRepository.count();
       // System.out.println(count);
    //}



}
