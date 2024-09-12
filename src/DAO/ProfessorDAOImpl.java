package DAO;

import Business.Professor;
import DAO.Interfaces.ProfessorDAO;
import Config.Db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfessorDAOImpl implements ProfessorDAO {
    private static final Logger logger = Logger.getLogger(ProfessorDAOImpl.class.getName());

    @Override
    public void save(Professor professor) {
        String query = "INSERT INTO professor (id, name, email, departement) VALUES (?, ?, ?, ?)";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, professor.getId());
            stmt.setString(2, professor.getName());
            stmt.setString(3, professor.getEmail());
            stmt.setString(4, professor.getDepartment());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE , e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM professor WHERE id = ?";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE , e.getMessage());
        }
    }

    @Override
    public void update(Professor professor) {
        String query = "UPDATE professor SET name = ?, email = ?, departement = ? WHERE id = ?";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, professor.getName());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getDepartment());
            stmt.setInt(4, professor.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE , e.getMessage());
        }
    }

    @Override
    public Professor findById(int id) {
        String query = "SELECT * FROM professor WHERE id = ?";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Professor(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("departement"));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    @Override
    public List<Professor> findAll() {
        List<Professor> professors = new ArrayList<>();
        String query = "SELECT * FROM professor";
        try (Connection conn = Db.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                professors.add(new Professor(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("departement")));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return professors;
    }
}
