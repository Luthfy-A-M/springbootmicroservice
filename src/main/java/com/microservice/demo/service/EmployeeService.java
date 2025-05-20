package com.microservice.demo.service;

import com.microservice.demo.entity.Employee;
import com.microservice.demo.repository.EmployeeRepo;
import com.microservice.demo.response.EmployeeResponse;
import org.modelmapper.ModelMapper; //not resolved ? 
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper mapper;

    public EmployeeResponse getEmployeeById(int id) {
        // logger.debug("Fetching employee with ID: {}", id);
        Optional<Employee> employee = employeeRepo.findById(id);
        // logger.debug("Fetching Found : {}", employee);
        EmployeeResponse employeeResponse = mapper.map(employee.get(), EmployeeResponse.class); // .get () must
        return employeeResponse;
    }

}