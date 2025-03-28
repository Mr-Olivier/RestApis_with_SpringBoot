//package net.javaguides.springboot.controller;
//
//import net.javaguides.springboot.exceptions.ResourceNotFoundException;
//import net.javaguides.springboot.model.Employee;
//import net.javaguides.springboot.repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin("*")
//@RestController
//@RequestMapping("/api/v1/employees")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @GetMapping
//    public List<Employee> getAllEmployees(){
//        return employeeRepository.findAll();
//    }
//
//    // build create employee REST API
//    @PostMapping
//    public Employee createEmployee(@RequestBody Employee employee) {
//        return employeeRepository.save(employee);
//    }
//
//    // build get employee by id REST API
//    @GetMapping("{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable  long id){
//        Employee employee = employeeRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
//        return ResponseEntity.ok(employee);
//    }
//
//    // build update employee REST API
//    @PutMapping("{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails) {
//        Employee updateEmployee = employeeRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
//
//        updateEmployee.setFirstName(employeeDetails.getFirstName());
//        updateEmployee.setLastName(employeeDetails.getLastName());
//        updateEmployee.setEmailId(employeeDetails.getEmailId());
//
//        employeeRepository.save(updateEmployee);
//
//        return ResponseEntity.ok(updateEmployee);
//    }
//
//    // build delete employee REST API
//    @DeleteMapping("{id}")
//    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
//
//        Employee employee = employeeRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
//
//        employeeRepository.delete(employee);
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//    }
//}



package net.javaguides.springboot.controller;

import net.javaguides.springboot.exceptions.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all employees API
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Employees retrieved successfully");
        response.put("count", employees.size());
        response.put("data", employees);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Create employee REST API
    @PostMapping
    public ResponseEntity<Map<String, Object>> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Employee created successfully");
        response.put("data", savedEmployee);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Map<String, Object>> getEmployeeById(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Employee retrieved successfully");
        response.put("data", employee);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Map<String, Object>> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        Employee updatedEmployee = employeeRepository.save(updateEmployee);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Employee updated successfully");
        response.put("data", updatedEmployee);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Delete employee REST APIS
    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        employeeRepository.delete(employee);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Employee deleted successfully");
        response.put("id", id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}