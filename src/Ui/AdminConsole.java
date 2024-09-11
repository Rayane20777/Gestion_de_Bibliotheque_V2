package Ui;

import java.util.Scanner;
import Business.Books;



public class AdminConsole {
    
    
    public static void admin(){
        Scanner prompt = new Scanner(System.in);
        
        System.out.println("******************************");
        System.out.println("Choose an option:");
        System.out.println("1. Manage documents");
        System.out.println("2. Manage users");
        System.out.println("3. exit");
        System.out.println("******************************");

        int choice = prompt.nextInt();

        switch (choice) {
            case 1:
                docManagement();
                break;
            case 2:
                userManagement();
                break;
            case 3:
                System.out.println("go back");
                return;
            case 4:
                System.out.println("exit program");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");

        }

    }

    public static void docManagement(){
        System.out.println("******************************");
        System.out.println("Choose an option:");
        System.out.println("1. Manage Books");
        System.out.println("2. Manage Magazines");
        System.out.println("3. Manage Scientific Journals");
        System.out.println("4. Manage University Thesis");
        System.out.println("5. Go back");
        System.out.println("6. Exit program");
        System.out.println("******************************");

        Scanner prompt = new Scanner(System.in);
        int choice = prompt.nextInt();

        switch (choice) {
            case 1:
                manageBooks(prompt);
                break;
            case 2:
                System.out.println("Magazines");
                break;
            case 3:
                System.out.println("Scientific Journals");
                break;
            case 4:
                System.out.println("University Thesis");
                return;
            case 5:
                System.out.println("Go back");
                return;
            case 6:
                System.out.println("exit program");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");

        }
    }

    public static void userManagement(){
        System.out.println("******************************");
        System.out.println("Choose an option:");
        System.out.println("1. Manage Student");
        System.out.println("2. Manage Professor");
        System.out.println("3. Go back");
        System.out.println("4. Exit program");
        System.out.println("******************************");

        Scanner prompt = new Scanner(System.in);
        int choice = prompt.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Manage Student");
                break;
            case 2:
                System.out.println("Manage Professor");
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

    private static void manageBooks(Scanner prompt){
        while(true){
            System.out.println("******************************");
            System.out.println("Choose an option:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Update a book");
            System.out.println("4. Display all books");
            System.out.println("5. Go back");
            System.out.println("6. Exit program");
            System.out.println("******************************");

            int choice = prompt.nextInt();

            switch (choice) {
                case 1:
                    addBook(prompt);
                    break;
                case 2:
                    System.out.println("Remove a book");
                    break;
                case 3:
                    System.out.println("Update a book");
                    break;
                case 4:
                    System.out.println("Display all books");
                    break;
                case 5:
                    System.out.println("Go back");
                    return;
                case 6:
                    System.out.println("exit program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }
    }
    private static void addBook(Scanner prompt) {
        System.out.println("Enter Book ID:");
        int id = prompt.nextInt();
        prompt.nextLine();

        System.out.println("Enter Title:");
        String title = prompt.nextLine();

        System.out.println("Enter Author:");
        String author = prompt.nextLine();

        System.out.println("Enter Publication Date (YYYY-MM-DD):");
        String publicationDate = prompt.nextLine();

        System.out.println("Enter ISBN:");
        String isbn = prompt.nextLine();

        Books.addBook(id, title, author, publicationDate, isbn);
    }

}
