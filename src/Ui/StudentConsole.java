package Ui;

import java.util.Scanner;

import Business.Books;
import Business.Magazines;

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
            System.out.println("9. exit");
            System.out.println("******************************");

            int choice = prompt.nextInt();
            prompt.nextLine();

            switch (choice) {
                case 1: {
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
                    break;
                case 2: {
                    System.out.println("Enter the book name:");
                    String docName = prompt.nextLine();
                    System.out.println("Enter your name:");
                    String borrowerName = prompt.nextLine();
                    Magazines magazine = Magazines.magazineId(docName);
                    if (magazine == null) {
                        System.out.println("Book not found");
                    } else {
                        magazine.borrow(docName, borrowerName);
                    }
                }
                break;

                case 3: {
                    System.out.println("Enter the book name:");
                    String docName = prompt.nextLine();
                    System.out.println("Enter your name:");String borrowerName = prompt.nextLine();

                    Books book = Books.bookId(docName);
                    if (book == null) {
                        System.out.println("Book not found");
                    } else {
                        book.turnBack(docName, borrowerName);
                    }
                }
                    break;
                case 4: {
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
                    break;
                case 5:{
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
                    break;
                case 6:

                    break;
                case 7:{
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

                    break;
                case 8:
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }
}
