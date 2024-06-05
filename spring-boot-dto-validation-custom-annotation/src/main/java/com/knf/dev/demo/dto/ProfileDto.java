package com.knf.dev.demo.dto;

import com.knf.dev.demo.validation.ValidURL;

public class ProfileDto {

    private String userName;
    @ValidURL
    private String url;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
