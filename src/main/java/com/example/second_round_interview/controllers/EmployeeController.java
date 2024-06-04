package com.example.second_round_interview.controllers;

import com.example.second_round_interview.dao.requests.EmployeeRequest;
import com.example.second_round_interview.dao.response.EmployeeResponse;
import com.example.second_round_interview.models.Employee;
import com.example.second_round_interview.services.employee.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Employee controller
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * api to list all employees.
     */
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> listEmployees() {
        List<EmployeeResponse> responses = employeeService.listAllEmployees()
                .stream()
                .map(this::createEmployeeResponse).toList();
        return ResponseEntity.ok(responses);
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest request) {
        return ResponseEntity.ok(createEmployeeResponse(employeeService.createNewEmployee(request)));
    }


    private EmployeeResponse createEmployeeResponse(Employee employee) {
            if (employee == null) {
                return null;
            }
            return EmployeeResponse.builder()
                    .id(employee.getId())
                    .name(employee.getName())
                    .employeeCode(employee.getEmployeeCode())
                    .build();
    }
}
