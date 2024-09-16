package Resources;

import java.util.Scanner;


public class InputValidator {
    public static int intValidator(Scanner prompt) {
        while (!prompt.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            prompt.next();
        }
        return prompt.nextInt();
    }
}
