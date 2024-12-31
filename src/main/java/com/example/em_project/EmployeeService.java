// package com;
package com.example.em_project;

import java.util.List;

public interface EmployeeService {

    List<Employee> readEmployees();

    boolean deleteEmployee(long id);

    String updateEployee(Long id, Employee employee);

}
