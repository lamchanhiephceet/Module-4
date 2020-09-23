package com.codegym.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class FormRegister implements Validator {

    private String firstName;
    private String lastName;
    private String age;
    private String number;
    private String email;
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FormRegister.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        FormRegister formRegister = (FormRegister) target;
        String number = formRegister.getNumber();
        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("number", "number.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("number", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number", "number.matches");
        }

        String firstName = formRegister.getFirstName();

        if(!firstName.matches("@Size(min=5,max=45)")) {
            errors.rejectValue("firstName", "firstName.matches");
        }

        String lastName = formRegister.getLastName();
        if(!"@Size(min=5,max=45)".matches(lastName)){
            errors.rejectValue("lastName","lastName.matches");
        }

        String age = formRegister.getAge();
        if(!age.matches("@Range(min=18,max=120)")) {
            errors.rejectValue("age","age.matches");
        }

        String email = formRegister.getEmail();
        if(!email.matches("@Email")){
            errors.rejectValue("email","email.matches");
        }
    }
}