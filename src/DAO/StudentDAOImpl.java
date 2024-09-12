package DAO;

import Business.Student;
import DAO.Interfaces.StudentDAO;
import Config.Db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StudentDAOImpl implements StudentDAO {
    private static final Logger logger = Logger.getLogger(StudentDAOImpl.class.getName());

    @Override
    public void save(Student student) {
        String query = "INSERT INTO student (id, name, email, faculty, grade) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getEmail());
            stmt.setString(4, student.getFaculty());
            stmt.setString(5, student.getGrade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE , e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM student WHERE id = ?";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE , e.getMessage());
        }
    }

    @Override
    public void update(Student student) {
        String query = "UPDATE student SET name = ?, email = ?, faculty = ?, grade = ? WHERE id = ?";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getFaculty());
            stmt.setString(4, student.getGrade());
            stmt.setInt(5, student.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE , e.getMessage());
        }
    }

    @Override
    public Student findById(int id) {
        String query = "SELECT * FROM student WHERE id = ?";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("faculty"), rs.getString("grade"));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE , e.getMessage());
        }
        return null;


    }

    public List<Student> findAll() {

        List<Student> studentList = new ArrayList<>();
        String query = "SELECT * FROM student";
        try (Connection conn = Db.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("faculty"), rs.getString("grade"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE , e.getMessage());
        }
        return null;
    }
}
