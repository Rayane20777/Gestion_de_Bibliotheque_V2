package Ui;

import java.util.Scanner;

public class ProfessorConsole {

    public static void professorMenu() {
        Scanner prompt = new Scanner(System.in);
        while (true) {
            System.out.println("******************************");
            System.out.println("Choose an option:");
            System.out.println("1. Book a document");
            System.out.println("2. Cancel booking");
            System.out.println("3. exit");
            System.out.println("******************************");

            int choice = prompt.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Book a document");
                    break;
                case 2:
                    System.out.println("Cancel booking");
                    break;
                case 3:
                    System.out.println("Go back");
                    return;
                case 4:
                    System.out.println("exit program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");

            }

        }
    }

}
