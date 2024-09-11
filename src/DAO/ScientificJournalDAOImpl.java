package DAO;

import DAO.Interfaces.ScientificJournalDAO;
import Business.ScientificJournal;
import Config.Db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScientificJournalDAOImpl implements  ScientificJournalDAO {
    private static final Logger logger = Logger.getLogger(ScientificJournalDAOImpl.class.getName());

    public void save(ScientificJournal scientificJournal) {
        String query = "INSERT INTO scientific_journal (id, title, author, publication_date, status, borrower_id, booker_id, field, university) VALUES (?, ?, ?, ?, ?::status, ?, ?, ?, ?)";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, scientificJournal.getId());
            stmt.setString(2, scientificJournal.getTitle());
            stmt.setString(3, scientificJournal.getAuthor());
            stmt.setString(4, scientificJournal.getPublicationDate());
            stmt.setString(5, scientificJournal.getStatus().name());
            stmt.setInt(6, scientificJournal.getBorrowerId());
            stmt.setInt(7, scientificJournal.getBookerId());
            stmt.setString(8, scientificJournal.getField());
            stmt.setString(9, scientificJournal.getUniversity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM scientific_journal WHERE id = ?";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

    }

    public void update(ScientificJournal scientificJournal) {
        String query = "UPDATE scientific_journal SET title = ?, author = ?, publication_date = ?, status = ?::status, borrower_id = ?, booker_id = ?, field = ?, university = ? WHERE id = ?";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, scientificJournal.getTitle());
            stmt.setString(2, scientificJournal.getAuthor());
            stmt.setString(3, scientificJournal.getPublicationDate());
            stmt.setString(4, scientificJournal.getStatus().name());
            stmt.setInt(5, scientificJournal.getBorrowerId());
            stmt.setInt(6, scientificJournal.getBookerId());
            stmt.setString(7, scientificJournal.getField());
            stmt.setString(8, scientificJournal.getUniversity());
            stmt.setInt(9, scientificJournal.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    public ScientificJournal findById(int id) {
        String query = "SELECT * FROM scientific_journal WHERE id = ?";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new ScientificJournal(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publication_date"),
                        ScientificJournal.Status.valueOf(rs.getString("status")),
                        rs.getInt("borrower_id"),
                        rs.getInt("booker_id"),
                        rs.getString("field"),
                        rs.getString("university")
                );
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    public List<ScientificJournal> findAll() {
        String query = "SELECT * FROM scientific_journal";
        List<ScientificJournal> scientificJournals = new ArrayList<>();
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                scientificJournals.add(new ScientificJournal(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publication_date"),
                        ScientificJournal.Status.valueOf(rs.getString("status")),
                        rs.getInt("borrower_id"),
                        rs.getInt("booker_id"),
                        rs.getString("field"),
                        rs.getString("university")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return scientificJournals;
    }

}

