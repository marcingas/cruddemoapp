package pl.marcindev.cruddemoapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.marcindev.cruddemoapp.entity.Student;
import pl.marcindev.cruddemoapp.repository.StudentRepository;

import java.util.List;

@SpringBootApplication
public class CruddemoappApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoappApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return runner -> {
//          createStudent(studentRepository);
//            System.out.println(readStudent(studentRepository,1));
//            for(var student : readAllStudents(studentRepository)){
//                System.out.println(student);
//            }
           int id =5;
            System.out.println(updateStudent(studentRepository,id));
//            deleteStudent(studentRepository,id);
//            System.out.println("Deleted num of Students=" + deleteAllStudents(studentRepository));
        };
    }

    private int deleteAllStudents(StudentRepository studentRepository) {
       return studentRepository.deleteAll();
    }

    private int updateStudent(StudentRepository studentRepository, int id) {
       Student student = studentRepository.getStudent(id);
       student.setLastName("Piechniczek");
       student.setEmail("email@email.pl");
       studentRepository.update(student);
       return student.getId();
    }

    private List<Student> findStudentByLastName(StudentRepository studentRepository, String lastName) {
       return studentRepository.findByLastName(lastName);
    }

    private void createStudent(StudentRepository studentRepository) {
        Student student1 = new Student("Karol", "Kowalski", "j@k.pl");
        Student student2 = new Student("Gosia", "Kowalski", "j@k.pl");
        Student student3 = new Student("Waldek", "Kowalski", "j@k.pl");
        Student student4 = new Student("Karolina", "Kowalski", "j@k.pl");
        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);

    }

    private Student readStudent(StudentRepository studentRepository, int id) {
        return studentRepository.getStudent(id);
    }

    private List<Student> readAllStudents(StudentRepository studentRepository) {
        return studentRepository.getAllStudents();
    }
    private void deleteStudent(StudentRepository studentRepository,int id){
        studentRepository.deleteStudent(id);
        System.out.println("Student with id " + id + " deleted");
    }
}

