package pl.marcindev.cruddemoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.marcindev.cruddemoapp.entity.Student;
import pl.marcindev.cruddemoapp.repository.StudentRepository;
import pl.marcindev.cruddemoapp.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/main")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student student = studentService.findById(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student id not found:" + studentId);
        }
        return student;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.save(student);
        return savedStudent;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.update(student);
    }
    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId){
        studentService.deleteById(studentId);
        return "Student deleted with Id:" + studentId;
    }


}
