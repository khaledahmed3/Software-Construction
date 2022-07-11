package com.example.demo;

import org.springframework.data.repository.CrudRepository;

//repository that extends CrudRepository
public interface StudentRepository extends CrudRepository<Student, String>
{
}