package com.knf.dev.demo.dto;

import com.knf.dev.demo.validation.ValidPassword;

public class UserDto {

    private String userName;
    @ValidPassword
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
