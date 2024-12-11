package com.example.retrofit2_android_java_demo.api.model;

public class StudentRequest {
    public String studentName;
    public String classId;

    public StudentRequest(String studentName, String classId) {
        this.studentName = studentName;
        this.classId = classId;
    }
}
