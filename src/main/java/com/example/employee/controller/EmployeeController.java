package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody @Validated Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping("/{employeeId}/tax-deductions")
    public ResponseEntity<?> getTaxDeductions(@PathVariable String employeeId) {
        Employee employee = employeeService.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        double tax = employeeService.calculateTax(employee);

        return ResponseEntity.ok(Map.of(
                "employeeId", employee.getEmployeeId(),
                "firstName", employee.getFirstName(),
                "lastName", employee.getLastName(),
                "yearlySalary", employee.getSalary() * 12,
                "taxAmount", tax
        ));
    }
}

