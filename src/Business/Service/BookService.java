package Business.Service;

import java.util.Scanner;

public class BookService {
    public static void addBook(Scanner prompt){
        System.out.println("Enter Book ID:");
        int id = prompt.nextInt();
        System.out.println("Book added");
    }

    public static void removeBook(Scanner prompt){
        System.out.println("Book removed");
    }

    public static void updateBook(Scanner prompt){
        System.out.println("Book updated");
    }

    public static void displayBooks(Scanner prompt){
        System.out.println("Books listed");
    }
}
