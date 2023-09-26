package com.cydeo.employeeregistrationproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    /*
    validation annotations with dependency "spring-boot-starter-validation"

    @NotNull --> field will accept anything but null, including "" or '' etc
    @NotEmpty --> field will not accept null, will not accept "" bit will take " "
    @NotBlank --> for it to accept an input there has to be a character beside space. So will not take "" or " "

    Each annotation can be modified with further restrictions

    @Size(max = 12, min=2) --> take min of 2 chars, no more than 12

     */

    // @NotBlank(message="Here is a message that will show on our console")
    // Better to organize messages in messages.properties
    @NotBlank
    @Size (max = 12, min=2)
    private String firstName;
    private String lastName;

    private String email, password, address, address2, city, state, zipCode;

    // Thymeleaf fails when LocalDate is not provided as a pattern. So Better to format it with this annotation
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate birthday;




}
