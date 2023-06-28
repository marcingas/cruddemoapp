package pl.marcindev.cruddemoapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.marcindev.cruddemoapp.entity.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/main")
public class StudentController {
    private List<Student> students = new ArrayList<>();

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Jan", "Kowalski", "j@k.pl"));
        students.add(new Student("Ania", "Kowalski", "j@k.pl"));
        students.add(new Student("Piotr", "Kowalski", "j@k.pl"));
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId >= students.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found:" + studentId);
        }
            return students.get(studentId);
    }

}
