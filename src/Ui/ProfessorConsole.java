package Ui;

import java.util.Scanner;

public class ProfessorConsole {

    public static void professorMenu(){
        System.out.println("******************************");
        System.out.println("Choose an option:");
        System.out.println("1. Book a document");
        System.out.println("2. Cancel booking");
        System.out.println("3. exit");
        System.out.println("******************************");

        Scanner prompt = new Scanner(System.in);
        int choice = prompt.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Book a document");
                break;
            case 2:
                System.out.println("Cancel booking");
                break;
            case 3:
                System.out.println("exit");
                break;
            default:
                System.out.println("Invalid choice");

        }

    }

}
