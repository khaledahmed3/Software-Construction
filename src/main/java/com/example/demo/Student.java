package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//mark class as an Entity
@Entity
//defining class name as Table name
@Table
public class Student
{
    //Defining book id as primary key
    @Id
    @Column
    private String studentId;
    @Column
    private String studentName;
    @Column
    private String courseName;
    @Column
    private int admittedYear;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getAdmittedYear() {
        return admittedYear;
    }

    public void setAdmittedYear(int admittedYear) {
        this.admittedYear = admittedYear;
    }
}
