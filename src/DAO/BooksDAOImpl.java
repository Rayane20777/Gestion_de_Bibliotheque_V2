package DAO;

import Business.Books;
import DAO.Interfaces.BooksDAO;
import Config.Db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BooksDAOImpl implements BooksDAO {



    @Override
    public void save(Books book) {
        String query = "INSERT INTO book (id, title, author, publication_date, status, borrower_id, booker_id, isbn) VALUES (?, ?, ?, ?, ?::status, ?, ?, ?)";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, book.getId());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setString(4, book.getPublicationDate());
            stmt.setString(5, book.getStatus().name());
            stmt.setInt(6, book.getBorrowerId());
            stmt.setInt(7, book.getBookerId());
            stmt.setString(8, book.getIsbn());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        }

//        @Override
//        public void update(Books book) {
//            System.out.println("The book has been updated.");
//        }

//        @Override
//        public Books findBookById(int id) {
//            System.out.println("The book has been found.");
//            return new Books();
//        }

//        @Override
//        public void delete(Books book) {
//            System.out.println("The book has been deleted.");
//        }

//    }
