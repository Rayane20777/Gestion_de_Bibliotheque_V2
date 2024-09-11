package DAO;

import Business.Books;
import Business.Magazines;
import DAO.Interfaces.MagazinesDAO;
import Config.Db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MagazineDAOImpl implements MagazinesDAO{

    public void save(Magazines magazine) {
        String query = "INSERT INTO magazine (id, title, author, publication_date, status, borrower_id, booker_id, number) VALUES (?, ?, ?, ?, ?::status, ?, ?, ?)";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, magazine.getId());
            stmt.setString(2, magazine.getTitle());
            stmt.setString(3, magazine.getAuthor());
            stmt.setString(4, magazine.getPublicationDate());
            stmt.setString(5, magazine.getStatus().name());
            stmt.setInt(6, magazine.getBorrowerId());
            stmt.setInt(7, magazine.getBookerId());
            stmt.setInt(8, magazine.getNumber());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM magazine WHERE id = ?";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Magazines magazine) {
        String query = "UPDATE magazine SET title = ?, author = ?, publication_date = ?, status = ?::status, borrower_id = ?, booker_id = ?, number = ? WHERE id = ?";
        try (Connection conn = Db.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, magazine.getTitle());
            stmt.setString(2, magazine.getAuthor());
            stmt.setString(3, magazine.getPublicationDate());
            stmt.setString(4, magazine.getStatus().name());
            stmt.setInt(5, magazine.getBorrowerId());
            stmt.setInt(6, magazine.getBookerId());
            stmt.setInt(7, magazine.getNumber());
            stmt.setInt(8, magazine.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Magazines findById(int id) {
        Magazines magazine = null;
        try {
            Connection connection = Db.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM magazine WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                magazine = new Magazines(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getString("publication_date"),
                        Books.Status.valueOf(resultSet.getString("status")),
                        resultSet.getInt("borrower_id"),
                        resultSet.getInt("booker_id"),
                        resultSet.getInt("number")
                );
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return magazine;

    }

    public List<Magazines> findAll() {
        List<Magazines> magazinesList = new ArrayList<>();
        try {
            Connection connection = Db.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM magazine");
            while (resultSet.next()) {
                Magazines magazine = new Magazines(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getString("publication_date"),
                        Books.Status.valueOf(resultSet.getString("status")),
                        resultSet.getInt("borrower_id"),
                        resultSet.getInt("booker_id"),
                        resultSet.getInt("number")
                );
                magazinesList.add(magazine);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return magazinesList;
    }
}
