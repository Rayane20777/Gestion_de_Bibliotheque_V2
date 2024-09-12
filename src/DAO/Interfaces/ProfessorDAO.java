package DAO.Interfaces;

import Business.Professor;

import java.util.List;

public interface ProfessorDAO {
    void save(Professor professor);
    void delete(int id);
    void update(Professor professor);
    Professor findById(int id);
    List<Professor> findAll();
}
