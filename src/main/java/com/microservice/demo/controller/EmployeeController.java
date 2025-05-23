package com.microservice.demo.controller;

import com.microservice.demo.response.EmployeeResponse;
import com.microservice.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{employee_id}")
    private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("employee_id") int employeeId) {
        EmployeeResponse employee = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

}