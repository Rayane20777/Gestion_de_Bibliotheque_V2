package Ui;

import java.util.Scanner;

import Business.Books;

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
            System.out.println("5. Cancel book booking");
            System.out.println("6. Cancel magazine booking");
            System.out.println("7. exit");
            System.out.println("******************************");

            int choice = prompt.nextInt();
            prompt.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the book name:");
                    String docName = prompt.nextLine();
                    System.out.println("Enter your name:");
                    String borrowerName = prompt.nextLine();
                    Books book = Books.bookId(docName); // Assuming this method exists in Books class
                    if (book == null) {
                        System.out.println("Book not found");
                    } else {
                        book.borrow(docName, borrowerName);
                    }
                    break;
                case 2:
                    System.out.println("Enter the magazine id:");
                    int magazineId = prompt.nextInt();
                    System.out.println("Enter the student id:");
                    int studentId2 = prompt.nextInt();
                    System.out.println("Enter the return date:");
                    String returnDate2 = prompt.next();
                    break;
                case 3:
                    System.out.println("Enter the book name:");
                    docName = prompt.nextLine();
                    System.out.println("Enter your name:");
                    borrowerName = prompt.nextLine();

                    book = Books.bookId(docName);
                    if (book == null) {
                        System.out.println("Book not found");
                    } else {
                        book.turnBack(docName, borrowerName);
                    }
                    break;
                case 4:
                    System.out.println("Enter the magazine id:");
                    int magazineId2 = prompt.nextInt();
                    break;
                case 5:
                    System.out.println("Enter the book id:");
                    int bookId3 = prompt.nextInt();
                    break;
                case 6:
                    System.out.println("Enter the magazine id:");
                    int magazineId3 = prompt.nextInt();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }
}
