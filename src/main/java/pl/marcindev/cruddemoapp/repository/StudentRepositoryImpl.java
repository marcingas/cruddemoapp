package pl.marcindev.cruddemoapp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.marcindev.cruddemoapp.entity.Student;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    EntityManager entityManager;

    @Autowired
    public StudentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    public Student getStudent(int id) {
       return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> query = entityManager.createQuery("from Student",Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery query  = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
        query.setParameter("theData",lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Student update(Student student) {
        entityManager.merge(student);
        return student;
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("Delete FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
