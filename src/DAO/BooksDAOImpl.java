package DAO;

import Business.Books;
import DAO.Interfaces.BooksDAO;
import Config.Db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BooksDAOImpl implements BooksDAO {
    private static final Logger logger = Logger.getLogger(MagazineDAOImpl.class.getName());


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
            logger.log(Level.SEVERE , e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM book WHERE id = ?";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE , e.getMessage());
        }

    }

    @Override
    public void update(Books book) {
        String query = "UPDATE book SET title = ?, author = ?, publication_date = ?, status = ?::status, borrower_id = ?, booker_id = ?, isbn = ? WHERE id = ?";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getPublicationDate());
            stmt.setString(4, book.getStatus().name());
            stmt.setInt(5, book.getBorrowerId());
            stmt.setInt(6, book.getBookerId());
            stmt.setString(7, book.getIsbn());
            stmt.setInt(8, book.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE , e.getMessage());
        }
    }

    @Override
    public Books findById(int id) {
        String query = "SELECT * FROM book WHERE id = ?";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Books(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publication_date"),
                        Books.Status.valueOf(rs.getString("status")),
                        rs.getInt("borrower_id"),
                        rs.getInt("booker_id"),
                        rs.getString("isbn")
                );
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE , e.getMessage());
        }
        return null;
    }

    @Override
    public List<Books> findAll() {
        List<Books> booksList = new ArrayList<>();
        String query = "SELECT * FROM book";
        try (Connection conn = Db.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                booksList.add(new Books(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publication_date"),
                        Books.Status.valueOf(rs.getString("status")),
                        rs.getInt("borrower_id"),
                        rs.getInt("booker_id"),
                        rs.getString("isbn")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE , e.getMessage());
        }
        return booksList;
    }

}

