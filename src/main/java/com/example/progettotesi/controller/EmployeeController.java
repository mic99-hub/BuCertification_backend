package com.example.progettotesi.controller;

import com.example.progettotesi.model.Employee;
import com.example.progettotesi.repository.EmployeeRepository;
import com.example.progettotesi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    // build create employee REST API
    //@PostMapping()
    ///public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        //return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
   // }

    @PostMapping()
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployees(@RequestParam("query") String query){
        return ResponseEntity.ok(employeeService.searchEmployees(query));
    }




    // built get all employee REST API
    @GetMapping("/list") List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // build get employee by Id REST API
    // http://localhost/:8080/employees/1
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }

    // build update employee REST API
    // http://localhost/:8080/api/employees/1
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id
                  , @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);

    }

    // build delete employee REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {

        employeeService.deleteEmployee(id);

        return  new ResponseEntity<String>("Employee deleted successfully! ", HttpStatus.OK);
    }
    
}
