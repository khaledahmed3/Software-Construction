package com.example.soft_cons.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "timetables")
public class TimeTable {

    private long id;
    private String title;
    private String semester;


    public TimeTable() {

    }

    public TimeTable(String title, String semester) {
        this.title = title;
        this.semester = semester;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "semester", nullable = false)
    public String getSemester() {
        return semester;
    }
    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", title=" + title + ", semester=" + semester + "]";
    }

}