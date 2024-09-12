package DAO.Interfaces;

import Business.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    void delete(int id);
    void update(Student student);
    Student findById(int id);
    List<Student> findAll();
}
