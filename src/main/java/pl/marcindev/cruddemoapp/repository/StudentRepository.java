package pl.marcindev.cruddemoapp.repository;

import pl.marcindev.cruddemoapp.entity.Student;

import java.util.List;

public interface StudentRepository {
    Student save(Student student);
    Student getStudent(int id);
    List<Student>getAllStudents();
    List<Student>findByLastName(String lastName);
    Student update(Student student);
    void deleteStudent(int id);
    int deleteAll();
}
