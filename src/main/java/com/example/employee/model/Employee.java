package com.example.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @NotNull(message = "Employee ID cannot be null")
    @Pattern(regexp = "^E\\d{3}$", message = "Employee ID must start with 'E' followed by 3 digits")
    private String employeeId;

    @NotNull(message = "First name cannot be null")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    private String lastName;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be in valid format")
    private String email;

    @NotNull(message = "Phone numbers cannot be null")
    @Size(min = 1, message = "At least one phone number is required")
    private List<String> phoneNumbers;

    @NotNull(message = "Date of joining cannot be null")
    @Pattern(regexp = "^(\\d{4})-(\\d{2})-(\\d{2})$", message = "Date of joining must be in YYYY-MM-DD format")
    private String doj;

    @NotNull(message = "Salary cannot be null")
    @Min(value = 0, message = "Salary must be a positive number")
    private Double salary;

    // Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
