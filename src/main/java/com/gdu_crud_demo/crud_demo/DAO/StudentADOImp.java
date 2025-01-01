package com.gdu_crud_demo.crud_demo.DAO;

import com.gdu_crud_demo.crud_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentADOImp implements StudentDAO {
    private EntityManager entityManager;

    public StudentADOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void insert(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Student.class, id));

    }

    @Override
    public Student selectOne(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> selectAll() {
        String sql = "Select s from Student s";
        TypedQuery<Student> query = entityManager.createQuery(sql, Student.class);
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    @Transactional
    public void deleteAll() {
        String sql = "Delete from Student";
        entityManager.createQuery(sql).executeUpdate();
    }

    @Override
    public List<Student> findByName(String name) {
        String sql = "Select s from Student s where s.firstname = :name";
        TypedQuery<Student> query = entityManager.createQuery(sql, Student.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
