package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    private static Db instance;
    final private Connection connection;
    private String jdbcUrl = "jdbc:postgresql://localhost:5432/Library_V2";
    private String username = "postgres";
    private String password = "password";

    private Db() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            throw new SQLException("Failed to create the database connection.", e);
        }
    }

    public static Db getInstance() throws SQLException {
        if (instance == null) {
            instance = new Db();
        } else if (instance.getConnection().isClosed()) {
            instance = new Db();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}