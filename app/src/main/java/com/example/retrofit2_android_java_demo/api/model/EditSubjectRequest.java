package com.example.retrofit2_android_java_demo.api.model;

import java.time.LocalDate;
import java.util.List;

public class EditSubjectRequest {
    public String subjectName;
    public LocalDate startDate;
    public LocalDate finishDate;
    public String teacherId;
    public List<String> studentIds;

    public EditSubjectRequest(String subjectName, LocalDate startDate, LocalDate finishDate, String teacherId, List<String> studentIds) {
        this.subjectName = subjectName;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.teacherId = teacherId;
        this.studentIds = studentIds;
    }
}
