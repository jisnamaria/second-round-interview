package com.example.second_round_interview.services.employee;

import com.example.second_round_interview.dao.requests.EmployeeRequest;
import com.example.second_round_interview.models.Employee;
import java.util.List;

/**
 * Employee service.
 */
public interface EmployeeService {
    List<Employee> listAllEmployees();

    Employee createNewEmployee(EmployeeRequest request);
}
