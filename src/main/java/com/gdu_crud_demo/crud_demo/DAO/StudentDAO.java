package com.gdu_crud_demo.crud_demo.DAO;

import com.gdu_crud_demo.crud_demo.entity.Student;

import java.util.List;

public interface StudentDAO {
    public void insert(Student student);
    public void update(Student student);
    public void delete(int id);
    public Student selectOne(int id);
    public List<Student> selectAll();
    public void deleteAll();
    public List<Student> findByName(String name);
}
