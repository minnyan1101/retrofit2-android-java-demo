package com.example.retrofit2_android_java_demo.api.model;

public class EditAttendanceRequest {
    public String status;
    public Boolean isLateness;
    public Boolean isLeaveEarly;

    public EditAttendanceRequest(String status, Boolean isLateness, Boolean isLeaveEarly) {
        this.status = status;
        this.isLateness = isLateness;
        this.isLeaveEarly = isLeaveEarly;
    }
}
