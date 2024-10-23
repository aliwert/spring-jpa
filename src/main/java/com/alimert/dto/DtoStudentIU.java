package com.alimert.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "Firstname cannot be left blank")
    @Min(value = 2, message = "Firstname must be at least 2 characters long")
    @Max(value = 20, message = "Firstname must be a maximum of 20 characters.")
    private String firstName;

    @Size(min = 2, max = 30)
    private String lastName;

    private Date birthOfDate;

    @Email(message = "Please enter an email in the correct format")
    private String email;

    @Size(min = 11, max = 11, message = "The TCKN must be 11 digits long")
    @NotEmpty(message = "TCKN cannot be left blank")
    private String tckn;
}
