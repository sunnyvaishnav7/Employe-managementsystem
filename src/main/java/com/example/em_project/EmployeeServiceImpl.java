package com.example.em_project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

//@SpringBootApplication
public  class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //List<Employee> employees = new ArrayList<>();

    public String createEmployee(Employee employee) {

        EmployeEntity employeEntity = new EmployeEntity();
        BeanUtils.copyProperties(employee, employeEntity);

        employeeRepository.save(employeEntity);
        //employees.add(employee);
        return "saved succesfully";
    }
    
    public Employee readEmployee(long id) {
      EmployeEntity employeeEntity = employeeRepository.findById(id).get();
      Employee employe = new Employee();
      BeanUtils.copyProperties(employeeEntity,employe);
      return employe;
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeEntity> employeesList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for (EmployeEntity employeesEntity : employeesList) {
            Employee emp = new Employee();
            emp.setId(employeesEntity.getId());
            emp.setName(employeesEntity.getName());
            emp.setPhone(employeesEntity.getPhone());
            emp.setEmail(employeesEntity.getEmail());

            employees.add(emp);
        }
        return employees;
    }

    // @SuppressWarnings("unlikely-arg-type")
    @Override
    public boolean deleteEmployee(long id) {
        // employees.remove(id);
        EmployeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
    }

   @Override
   public String updateEployee(Long id, Employee employee) {
      EmployeEntity excstingEmployee = employeeRepository.findById(id).get();


      excstingEmployee.setEmail(employee.getEmail());
      excstingEmployee.setName(employee.getName());
      excstingEmployee.setPhone(employee.getPhone());

      employeeRepository.save(excstingEmployee);
      return "Update Succesfully";
   }
}
