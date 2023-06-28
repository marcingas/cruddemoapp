package pl.marcindev.cruddemoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marcindev.cruddemoapp.entity.Student;
import pl.marcindev.cruddemoapp.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.getAllStudents();
    }

    @Override
    public Student findById(int studentId) {
        return studentRepository.getStudent(studentId);
    }

    @Override
    public Student save(Student student) {
       return studentRepository.save(student);
    }

    @Override
    public void deleteById(int studentId) {
        studentRepository.deleteStudent(studentId);
    }

    @Override
    public Student update(Student student) {
        return studentRepository.update(student);
    }
}
