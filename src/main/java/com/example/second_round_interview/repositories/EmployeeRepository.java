package com.example.second_round_interview.repositories;

import com.example.second_round_interview.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Employee repository.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
