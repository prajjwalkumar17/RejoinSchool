package com.rejointech.Rejoinschool.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class Contact {
    @NotBlank(message = "Name shouldn't be blank")
    @Size(min = 3, message = "name should be at least 3 characters long")
    String name;
    @NotBlank(message = "mobile-No shouldn't be blank")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile no must be of 10 digits")
    String mobileNum;
    @NotBlank(message = "Email shouldn't be blank")
    @Email(message = "Provide a valid email address")
    String email;
    @NotBlank(message = "Subject can't be left blank")
    @Size(min = 5, message = "Subject must be at least 5 characters long")
    String subject;
    @NotBlank(message = "Message shouldn't be left blank")
    @Size(min = 10, message = "Message must be 10 characters in length")
    String message;
}
