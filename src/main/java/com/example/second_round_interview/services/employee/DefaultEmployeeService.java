package com.example.second_round_interview.services.employee;

import com.example.second_round_interview.dao.requests.EmployeeRequest;
import com.example.second_round_interview.models.Employee;
import com.example.second_round_interview.repositories.EmployeeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Employee service implementation.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultEmployeeService implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> listAllEmployees() {
        log.info("listing all employees");
        try {
            return employeeRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("failed to list employees", e);
        }
    }

    @Override
    public Employee createNewEmployee(EmployeeRequest request) {
        log.info("creating new employee {} ", request.getName());
        try {
            Employee employee = new Employee();
            employee.setName(request.getName());
            employee.setEmployeeCode(request.getEmployeeCode());
            return employeeRepository.save(employee);
        } catch (Exception e) {
            throw new RuntimeException("failed to save employees", e);
        }

    }
}
