package DAO.Interfaces;

import Business.Books;

import java.util.List;

public interface BooksDAO {

    void save(Books book);
    void update(Books book);
    Books findById(int id);
    void delete(int id);
    List<Books> findAll();
}
