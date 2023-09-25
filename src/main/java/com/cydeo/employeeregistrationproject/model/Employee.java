package com.cydeo.employeeregistrationproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    private String firstName, lastName, email, password, address, address2, city, state, zipCode;
    private LocalDate birthday;




}
