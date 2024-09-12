package DAO.Interfaces;

import Business.UniversityThesis;

import java.util.List;

public interface UniversityThesisDAO {

    void save(UniversityThesis universityThesis);
    void update(UniversityThesis universityThesis);
    UniversityThesis findById(int id);
    void delete(int id);
    List<UniversityThesis> findAll();
}
