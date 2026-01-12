package com.yudorm.app.data.models;

public class RegisterRequest {

    private String studentNo;
    private String fullName;
    private String password;
    private String department;
    private String roomNumber;

    public RegisterRequest(String studentNo, String fullName, String password, String department, String roomNumber) {
        this.studentNo = studentNo;
        this.fullName = fullName;
        this.password = password;
        this.department = department;
        this.roomNumber = roomNumber;
    }
}
