package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//defining the business logic
@Service
public class StudentService
{
    @Autowired
    StudentRepository studentRepository;
    //getting all books record by using the method findaAll() of CrudRepository
    public List<Student> getAllStudents()
    {
        List<Student> books = new ArrayList<Student>();
        studentRepository.findAll().forEach(student1 -> books.add(student1));
        return books;
    }
    //getting a specific record by using the method findById() of CrudRepository
    public Student getStudentsById(String id)
    {
        return studentRepository.findById(id).get();
    }
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Student student)
    {
        studentRepository.save(student);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(String id)
    {
        studentRepository.deleteById(id);
    }
    //updating a record
    public void update(Student student, int bookid)
    {
        studentRepository.save(student);
    }
}