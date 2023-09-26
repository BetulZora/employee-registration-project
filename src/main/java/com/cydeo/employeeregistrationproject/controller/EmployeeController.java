package com.cydeo.employeeregistrationproject.controller;

import com.cydeo.employeeregistrationproject.bootstrap.DataGenerator;
import com.cydeo.employeeregistrationproject.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/register")
    public String createEmployee(Model model){

        model.addAttribute("employee", new Employee());
        model.addAttribute("states", DataGenerator.getAllStates());

        return "employee/employee-create";
    }

    @PostMapping("/list")
    public String employeeList(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model){

        /*
        Perform validation on the Employee object that's populated. Use the @Valid annotation
        will impose restrictions defined in POJO with annotations
         */

        // BindingResult interface, add parameter directly after @Valid object param

        if(bindingResult.hasErrors()) { // .hasErrors() will return true if there is an error

            // have to add the state list the employee object has been carried over but not the statelist
            // we need the statelist because we need to return to the create page and fix the employee object
            model.addAttribute("states", DataGenerator.getAllStates());

            return  "employee/employee-create"; // go back to employee-create if there is an error on validated fields
        }
        DataGenerator.saveEmployee(employee);

        model.addAttribute("employeeList", DataGenerator.readAllEmployees());



        return "employee/employee-list";
    }
}
