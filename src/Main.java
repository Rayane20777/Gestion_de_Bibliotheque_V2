import Config.Db;
import Ui.ConsoleUi;

import java.sql.SQLException;

public class Main {


    public static void main(String... args) {
        try {
            // Initialize the database connection
            Db db = Db.getInstance();
            System.out.println("Database connection established.");

            // Start the console interface
            ConsoleUi console = new ConsoleUi();
            console.startMenu();
        } catch (SQLException e) {
            System.err.println("Failed to establish database connection: " + e.getMessage());
        }
    }
}