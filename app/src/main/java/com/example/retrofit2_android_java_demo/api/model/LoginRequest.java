package com.example.retrofit2_android_java_demo.api.model;

public class LoginRequest {
    public String id;

    public String password;

    public LoginRequest(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
