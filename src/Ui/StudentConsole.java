package Ui;

import java.util.Scanner;

public class StudentConsole {



    public static void studentMenu() {
        Scanner prompt = new Scanner(System.in);
        while (true) {
            System.out.println("******************************");
            System.out.println("Choose an option:");
            System.out.println("1. Borrow a book");
            System.out.println("2. Return a book");
            System.out.println("3. exit");
            System.out.println("******************************");

            int choice = prompt.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Borrow a document");
                    break;
                case 2:
                    System.out.println("Return a document");
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
