package com.example.retrofit2_android_java_demo.api.model;

import java.time.LocalDate;

public class CreateSubjectLectureRequest {
    public String lectureName;
    public LocalDate date;
    public Long periods;

    public CreateSubjectLectureRequest(String lectureName, LocalDate date, Long periods) {
        this.lectureName = lectureName;
        this.date = date;
        this.periods = periods;
    }
}