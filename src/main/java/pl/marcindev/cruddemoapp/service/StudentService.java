package pl.marcindev.cruddemoapp.service;

import pl.marcindev.cruddemoapp.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student findById(int studentId);

    Student save(Student student);

    void deleteById(int studentId);

    Student update(Student student);

}
