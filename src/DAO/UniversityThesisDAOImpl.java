package DAO;

import Business.UniversityThesis;
import DAO.Interfaces.UniversityThesisDAO;
import Config.Db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UniversityThesisDAOImpl implements UniversityThesisDAO {
    private static final Logger logger = Logger.getLogger(UniversityThesisDAOImpl.class.getName());

    public void save(UniversityThesis universityThesis) {
        String query = "INSERT INTO university_thesis (id, title, author, publication_date, status, borrower_id, booker_id, research_domain) VALUES (?, ?, ?, ?, ?::status, ?, ?, ?)";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, universityThesis.getId());
            stmt.setString(2, universityThesis.getTitle());
            stmt.setString(3, universityThesis.getAuthor());
            stmt.setString(4, universityThesis.getPublicationDate());
            stmt.setString(5, universityThesis.getStatus().name());
            stmt.setInt(6, universityThesis.getBorrowerId());
            stmt.setInt(7, universityThesis.getBookerId());
            stmt.setString(8, universityThesis.getResearchDomain());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE , e.getMessage());
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM university_thesis WHERE id = ?";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE , e.getMessage());
        }

    }

    public void update(UniversityThesis universityThesis) {
        String query = "UPDATE university_thesis SET title = ?, author = ?, publication_date = ?, status = ?::status, borrower_id = ?, booker_id = ?, research_domain = ? WHERE id = ?";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, universityThesis.getTitle());
            stmt.setString(2, universityThesis.getAuthor());
            stmt.setString(3, universityThesis.getPublicationDate());
            stmt.setString(4, universityThesis.getStatus().name());
            stmt.setInt(5, universityThesis.getBorrowerId());
            stmt.setInt(6, universityThesis.getBookerId());
            stmt.setString(7, universityThesis.getResearchDomain());
            stmt.setInt(8, universityThesis.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE , e.getMessage());
        }
    }

    public List<UniversityThesis> findAll() {
        List<UniversityThesis> universityTheses = new ArrayList<>();
        String query = "SELECT * FROM university_thesis";
        try (Connection conn = Db.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                UniversityThesis universityThesis = new UniversityThesis(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("publication_date"), UniversityThesis.Status.valueOf(rs.getString("status")), rs.getInt("borrower_id"), rs.getInt("booker_id"), rs.getString("research_domain"));
                universityTheses.add(universityThesis);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE , e.getMessage());
        }
        return universityTheses;
    }

    public UniversityThesis findById(int id) {
        String query = "SELECT * FROM university_thesis WHERE id = ?";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new UniversityThesis(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publication_date"),
                        UniversityThesis.Status.valueOf(rs.getString("status")),
                        rs.getInt("borrower_id"),
                        rs.getInt("booker_id"),
                        rs.getString("research_domain")
                );
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE , e.getMessage());
        }
        return null;
    }
}
