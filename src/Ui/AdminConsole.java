package Ui;

import java.util.Scanner;

public class AdminConsole {

    public static void admin(){
        System.out.println("******************************");
        System.out.println("Choose an option:");
        System.out.println("1. Add a document");
        System.out.println("2. Remove a document");
        System.out.println("3. exit");
        System.out.println("******************************");

        Scanner prompt = new Scanner(System.in);
        int choice = prompt.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Manage documents");
                break;
            case 2:
                System.out.println("Manage users");
                break;
            case 3:
                System.out.println("exit");
                break;
            default:
                System.out.println("Invalid choice");

        }

    }

}
