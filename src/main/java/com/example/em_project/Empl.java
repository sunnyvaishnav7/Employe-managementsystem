package  com.example.em_project;

import java.util.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


public class Empl implements  EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    public String createEmployee(Employee employee){

        EmployeEntity employeEntity = new EmployeEntity();

        BeanUtils.copyProperties(employeEntity, employee);

        employeeRepository.save(employeEntity);

        return "saved Succesfully";
    }

    public Employee readEmployee(long id){

        EmployeEntity employeEntity = employeeRepository.findById(id).get();
        Employee employee = new Employee();

        BeanUtils.copyProperties(employee, employeEntity);

        employeeRepository.save(employeEntity);
        return employee; 

    }


    public List<Employee> readEmployees(){
        List<Employee> employees= new ArrayList<>();
        List<EmployeEntity> employeeList = employeeRepository.findAll();

        for(EmployeEntity employeEntity : employeeList){

            Employee emp = new Employee();

            emp.setId(employeEntity.getId());
            emp.setName(employeEntity.getName());
            emp.setEmail(employeEntity.getEmail());
            emp.setPhone(employeEntity.getPhone());

            employees.add(emp);
        }
        return employees;

    }

    @Override
    public boolean deleteEmployee(long id) {
        EmployeEntity emp = employeeRepository.findById(id).get();

        employeeRepository.delete(emp);
        return true;
    }

    @Override
    public String updateEployee(Long id, Employee employee) {
        EmployeEntity exsistingemp = employeeRepository.findById(id).get();

        exsistingemp.setName(employee.getName());
        exsistingemp.setEmail(employee.getEmail());
        exsistingemp.setPhone(employee.getPhone());
        return "updated succesfully";
    }


    
}