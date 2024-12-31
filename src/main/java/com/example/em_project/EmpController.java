package com.example.em_project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    //Dependesy injection
     @Autowired
    EmployeeServiceImpl employeeService;

    @GetMapping("employees")
    public List<Employee> getAllEmployes() {

        return employeeService.readEmployees();
    }


    @GetMapping("employees/{id}")
    public Employee getAllEmployesByid(@PathVariable Long id) {

        return employeeService.readEmployee(id);
    }
    
    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {

        return employeeService.createEmployee(employee);

    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if (employeeService.deleteEmployee(id)) {
            return "Delete Succesfully";
        }

        return "not found";
    }

    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable long id,@RequestBody Employee employee){
        return employeeService.updateEployee(id, employee);
    }

}