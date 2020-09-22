package com.codegym.model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

public class User {

    @NotEmpty
    @Size(min = 2, max = 30, message = "Not empty, at least 2 - 30 character,")
    private String name;

   // @Min(value = 18)
    @Range(min = 18, max = 120,message = "Invalid, must be greater than and smaller to 120" )
    private int age;

    @Email(message = "Email invalid")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone invalid")
    private String phone;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}