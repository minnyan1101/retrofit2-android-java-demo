package com.example.retrofit2_android_java_demo;

import java.time.LocalDate;
import java.util.List;

public class TeacherSubject {
    public Long subjectId;
    public String subjectName;
    public LocalDate startDate;
    public LocalDate finishDate;
    public String teacherId;
    public List<String> studentIds;
}