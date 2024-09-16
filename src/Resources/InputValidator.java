package Resources;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.UUID;


public class InputValidator {
    public static int intValidator(Scanner prompt) {
        while (!prompt.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            prompt.next();
        }
        return prompt.nextInt();
    }

    public static String uuidValidator(Scanner prompt) {
        while (true) {
            String uuid = prompt.next();
            try {
                UUID.fromString(uuid);
                return uuid;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid UUID. Please enter a valid UUID:");
            }
        }
    }


    public static boolean emailValidator(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    public static boolean dateValidator(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
