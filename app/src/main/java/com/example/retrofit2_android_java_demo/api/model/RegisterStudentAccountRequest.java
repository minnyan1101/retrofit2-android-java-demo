package com.example.retrofit2_android_java_demo.api.model;

public class RegisterStudentAccountRequest {
    public String studentId;
    public String studentName;
    public String password;
    public Long classId;

    public RegisterStudentAccountRequest(String studentId, String studentName, String password, Long classId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.password = password;
        this.classId = classId;
    }
}
