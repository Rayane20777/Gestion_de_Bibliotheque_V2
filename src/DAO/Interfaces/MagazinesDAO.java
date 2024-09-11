package DAO.Interfaces;

import Business.Magazines;

import java.util.List;

public interface MagazinesDAO {

    void save(Magazines magazine);
    void update(Magazines magazine);
    Magazines findById(int id);
    void delete(int id);
    List<Magazines> findAll();

}
