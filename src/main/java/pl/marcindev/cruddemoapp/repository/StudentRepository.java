package pl.marcindev.cruddemoapp.repository;

import pl.marcindev.cruddemoapp.entity.Student;

import java.util.List;

public interface StudentRepository {
    void save(Student student);
    Student getStudent(int id);
    List<Student>getAllStudents();
    List<Student>findByLastName(String lastName);
    int update(Student student);
    void deleteStudent(int id);
    int deleteAll();
}
