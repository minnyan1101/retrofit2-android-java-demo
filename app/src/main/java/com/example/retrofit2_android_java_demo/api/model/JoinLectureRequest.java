package com.example.retrofit2_android_java_demo.api.model;

public class JoinLectureRequest {
    public Long subjectId;
    public Long lectureId;
    public Long joinCode;

    public JoinLectureRequest(Long subjectId, Long lectureId, Long joinCode) {
        this.subjectId = subjectId;
        this.lectureId = lectureId;
        this.joinCode = joinCode;
    }

}
