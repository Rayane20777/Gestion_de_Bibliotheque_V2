package DAO.Interfaces;

import Business.ScientificJournal;

import java.util.List;

public interface ScientificJournalDAO {
    void save(ScientificJournal scientificJournal);
    void update(ScientificJournal scientificJournal);
    ScientificJournal findById(int id);
    void delete(int id);
    List<ScientificJournal> findAll();
}
