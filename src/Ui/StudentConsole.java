package Ui;

import java.util.Scanner;

public class StudentConsole {



    public static void studentMenu(){
        System.out.println("******************************");
        System.out.println("Choose an option:");
        System.out.println("1. Borrow a book");
        System.out.println("2. Return a book");
        System.out.println("3. exit");
        System.out.println("******************************");

        Scanner prompt = new Scanner(System.in);
        int choice = prompt.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Borrow a document");
                break;
            case 2:
                System.out.println("Return a document");
                break;
            case 3:
                System.out.println("exit");
                break;
            default:
                System.out.println("Invalid choice");

        }

    }
}
