package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//mark class as Controller
@RestController
public class StudentController
{
    //autowire the StudentService class
    @Autowired
    StudentService studentService;
    //creating a get mapping that retrieves all the books detail from the database
    @GetMapping("/students")
    private List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }
    //creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/student/{studentId}")
    private Student getStudents(@PathVariable("studentId") String studentId)
    {
        return studentService.getStudentsById(studentId);
    }
    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/student/{studentId}")
    private String deleteStudent(@PathVariable("studentId") String studentId)
    {
        studentService.delete(studentId);
        return "Student " + studentId + " has been deleted!";
    }
    //creating post mapping that post the book detail in the database
    @PostMapping("/student")
    private Student saveStudent(@RequestBody Student student)
    {
        studentService.saveOrUpdate(student);
        return student;
    }
    //creating put mapping that updates the book detail
    @PutMapping("/student")
    private Student update(@RequestBody Student student)
    {
        studentService.saveOrUpdate(student);
        return student;
    }
}
