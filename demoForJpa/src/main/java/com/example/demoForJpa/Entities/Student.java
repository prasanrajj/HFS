package com.example.demoForJpa.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String StudentName;
    private String email;
    private long mobile;

    private String Address;

    public Student() {
    }

    public Student(long id, String studentName, String email, long mobile, String address) {
        this.id = id;
        StudentName = studentName;
        this.email = email;
        this.mobile = mobile;
        Address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", StudentName='" + StudentName + '\'' +
                ", email='" + email + '\'' +
                ", mobile=" + mobile +
                ", Address='" + Address + '\'' +
                '}';
    }
}
