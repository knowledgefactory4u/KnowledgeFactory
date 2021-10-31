package com.knf.springboot.keycloak.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeVO {
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private int statusCode;
    private String status;

}