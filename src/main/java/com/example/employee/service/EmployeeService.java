package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    public Optional<Employee> findById(String employeeId) {
        return employeeRepository.findById(employeeId);  
    }

    public double calculateTax(Employee employee) {
        double yearlySalary = employee.getSalary() * 12;
        double tax = 0;

        if (yearlySalary <= 250000) return 0;

        if (yearlySalary <= 500000)
            tax += (yearlySalary - 250000) * 0.05;

        else if (yearlySalary <= 1000000) {
            tax += 250000 * 0.05;
            tax += (yearlySalary - 500000) * 0.1;
        } else {
            tax += 250000 * 0.05;
            tax += 500000 * 0.1;
            tax += (yearlySalary - 1000000) * 0.2;
        }

        if (yearlySalary > 2500000) {
            double cess = (yearlySalary - 2500000) * 0.02;
            tax += cess;
        }

        return tax;
    }
}
