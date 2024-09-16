package Ui;

import java.util.Scanner;

import Business.Books;
import Business.Magazines;
import Resources.InputValidator;

public class StudentConsole {

    public static void studentMenu() {
        Scanner prompt = new Scanner(System.in);
        while (true) {
            System.out.println("******************************");
            System.out.println("Choose an option:");
            System.out.println("1. Borrow a book");
            System.out.println("2. Borrow a magazine");
            System.out.println("3. Return a book");
            System.out.println("4. Return a magazine");
            System.out.println("5. Book a book");
            System.out.println("6. Book a magazine");
            System.out.println("7. Cancel book booking");
            System.out.println("8. Cancel magazine booking");
            System.out.println("9. Exit");
            System.out.println("******************************");

            int choice = InputValidator.intValidator(prompt);
            prompt.nextLine();

            switch (choice) {
                case 1:
                    borrowBook(prompt);
                    break;
                case 2:
                    borrowMagazine(prompt);
                    break;
                case 3:
                    returnBook(prompt);
                    break;
                case 4:
                    returnMagazine(prompt);
                    break;
                case 5:
                    bookBook(prompt);
                    break;
                case 6:
                    bookMagazine(prompt);
                    break;
                case 7:
                    cancelBookBooking(prompt);
                    break;
                case 8:
                    cancelMagazineBooking(prompt);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void borrowBook(Scanner prompt) {
        System.out.println("Enter the book name:");
        String docName = prompt.nextLine();
        System.out.println("Enter your name:");
        String borrowerName = prompt.nextLine();
        Books book = Books.bookId(docName);
        if (book == null) {
            System.out.println("Book not found");
        } else {
            book.borrow(docName, borrowerName);
        }
    }

    public static void borrowMagazine(Scanner prompt) {
        System.out.println("Enter the magazine name:");
        String docName = prompt.nextLine();
        System.out.println("Enter your name:");
        String borrowerName = prompt.nextLine();
        Magazines magazine = Magazines.magazineId(docName);
        if (magazine == null) {
            System.out.println("Magazine not found");
        } else {
            magazine.borrow(docName, borrowerName);
        }
    }

    public static void returnBook(Scanner prompt) {
        System.out.println("Enter the book name:");
        String docName = prompt.nextLine();
        System.out.println("Enter your name:");
        String borrowerName = prompt.nextLine();
        Books book = Books.bookId(docName);
        if (book == null) {
            System.out.println("Book not found");
        } else {
            book.turnBack(docName, borrowerName);
        }
    }

    public static void returnMagazine(Scanner prompt) {
        System.out.println("Enter the magazine name:");
        String docName = prompt.nextLine();
        System.out.println("Enter your name:");
        String borrowerName = prompt.nextLine();
        Magazines magazine = Magazines.magazineId(docName);
        if (magazine == null) {
            System.out.println("Magazine not found");
        } else {
            magazine.turnBack(docName, borrowerName);
        }
    }

    public static void bookBook(Scanner prompt) {
        System.out.println("Enter the book name:");
        String docName = prompt.nextLine();
        System.out.println("Enter your name:");
        String bookerName = prompt.nextLine();
        Books book = Books.bookId(docName);
        if (book == null) {
            System.out.println("Book not found");
        } else {
            book.book(docName, bookerName);
        }
    }

    public static void bookMagazine(Scanner prompt) {
        System.out.println("Enter the magazine name:");
        String docName = prompt.nextLine();
        System.out.println("Enter your name:");
        String bookerName = prompt.nextLine();
        Magazines magazine = Magazines.magazineId(docName);
        if (magazine == null) {
            System.out.println("Magazine not found");
        } else {
            magazine.book(docName, bookerName);
        }
    }

    public static void cancelBookBooking(Scanner prompt) {
        System.out.println("Enter the book name:");
        String docName = prompt.nextLine();
        System.out.println("Enter your name:");
        String bookerName = prompt.nextLine();
        Books book = Books.bookId(docName);
        if (book == null) {
            System.out.println("Book not found");
        } else {
            book.cancelBooking(docName, bookerName);
        }
    }

    public static void cancelMagazineBooking(Scanner prompt) {
        System.out.println("Enter the magazine name:");
        String docName = prompt.nextLine();
        System.out.println("Enter your name:");
        String bookerName = prompt.nextLine();
        Magazines magazine = Magazines.magazineId(docName);
        if (magazine == null) {
            System.out.println("Magazine not found");
        } else {
            magazine.cancelBooking(docName, bookerName);
        }
    }
}
