package com.example.second_round_interview.dao.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Employee Request.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    private String name;
    private String employeeCode;
}
