package Ui;

import java.util.Scanner;

import Business.ScientificJournal;
import Business.UniversityThesis;
import Resources.InputValidator;

public class ProfessorConsole {

    public static void professorMenu() {
        Scanner prompt = new Scanner(System.in);
        while (true) {
            System.out.println("******************************");
            System.out.println("Choose an option:");
            System.out.println("1. Display scientific journal");
            System.out.println("2. Display university thesis");
            System.out.println("3. Borrow scientific journal");
            System.out.println("4. Borrow university thesis");
            System.out.println("5. Return scientific journal");
            System.out.println("6. Return university thesis");
            System.out.println("7. Book scientific journal");
            System.out.println("8. Book university thesis");
            System.out.println("9. Cancel scientific journal booking");
            System.out.println("10. Cancel university thesis booking");
            System.out.println("11. Go back");
            System.out.println("12. Exit program");
            System.out.println("******************************");

            int choice = InputValidator.intValidator(prompt);
            prompt.nextLine();

            switch (choice) {
                case 1:
                    ScientificJournal.displayScientificJournals();
                    break;
                case 2:
                    UniversityThesis.displayUniversityThesis();
                    break;
                case 3:
                    borrowScientificJournal(prompt);
                    break;
                case 4:
                    borrowUniversityThesis(prompt);
                    break;
                case 5:
                    returnScientificJournal(prompt);
                    break;
                case 6:
                    returnUniversityThesis(prompt);
                    break;
                case 7:
                    bookScientificJournal(prompt);
                    break;
                case 8:
                    bookUniversityThesis(prompt);
                    break;
                case 9:
                    cancelScientificJournalBooking(prompt);
                    break;
                case 10:
                    cancelUniversityThesisBooking(prompt);
                    break;
                case 11:
                    System.out.println("Go back");
                    return;
                case 12:
                    System.out.println("Exit program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void borrowScientificJournal(Scanner prompt) {
        System.out.println("Enter the scientific journal name:");
        String docName = prompt.nextLine();
        System.out.println("Enter your name:");
        String borrowerName = prompt.nextLine();
        ScientificJournal scientificJournal = ScientificJournal.scientificJournalId(docName);
        if (scientificJournal == null) {
            System.out.println("Scientific journal not found");
        } else {
            scientificJournal.borrow(docName, borrowerName);
        }
    }

    private static void borrowUniversityThesis(Scanner prompt) {
        System.out.println("Enter the university thesis name:");
        String docName = prompt.nextLine();
        System.out.println("Enter your name:");
        String borrowerName = prompt.nextLine();
        UniversityThesis universityThesis = UniversityThesis.universityThesisId(docName);
        if (universityThesis == null) {
            System.out.println("University thesis not found");
        } else {
            universityThesis.borrow(docName, borrowerName);
        }
    }

    private static void returnScientificJournal(Scanner prompt) {
        System.out.println("Enter the scientific journal name:");
        String docName = prompt.nextLine();
        System.out.println("Enter your name:");
        String borrowerName = prompt.nextLine();
        ScientificJournal scientificJournal = ScientificJournal.scientificJournalId(docName);
        if (scientificJournal == null) {
            System.out.println("Scientific journal not found");
        } else {
            scientificJournal.turnBack(docName, borrowerName);
        }
    }

    private static void returnUniversityThesis(Scanner prompt) {
        System.out.println("Enter the university thesis name:");
        String docName = prompt.nextLine();
        System.out.println("Enter your name:");
        String borrowerName = prompt.nextLine();
        UniversityThesis universityThesis = UniversityThesis.universityThesisId(docName);
        if (universityThesis == null) {
            System.out.println("University thesis not found");
        } else {
            universityThesis.turnBack(docName, borrowerName);
        }
    }

    private static void bookScientificJournal(Scanner prompt) {
        System.out.println("Enter the scientific journal name:");
        String docName = prompt.nextLine();
        System.out.println("Enter your name:");
        String bookerName = prompt.nextLine();
        ScientificJournal scientificJournal = ScientificJournal.scientificJournalId(docName);
        if (scientificJournal == null) {
            System.out.println("Scientific journal not found");
        } else {
            scientificJournal.book(docName, bookerName);
        }
    }

    private static void bookUniversityThesis(Scanner prompt) {
        System.out.println("Enter the university thesis name:");
        String docName = prompt.nextLine();
        System.out.println("Enter your name:");
        String bookerName = prompt.nextLine();
        UniversityThesis universityThesis = UniversityThesis.universityThesisId(docName);
        if (universityThesis == null) {
            System.out.println("University thesis not found");
        } else {
            universityThesis.book(docName, bookerName);
        }
    }

    private static void cancelScientificJournalBooking(Scanner prompt) {
        System.out.println("Enter the scientific journal name:");
        String docName = prompt.nextLine();
        System.out.println("Enter your name:");
        String bookerName = prompt.nextLine();
        ScientificJournal scientificJournal = ScientificJournal.scientificJournalId(docName);
        if (scientificJournal == null) {
            System.out.println("Scientific journal not found");
        } else {
            scientificJournal.cancelBooking(docName, bookerName);
        }
    }

    private static void cancelUniversityThesisBooking(Scanner prompt) {
        System.out.println("Enter the university thesis name:");
        String docName = prompt.nextLine();
        System.out.println("Enter your name:");
        String bookerName = prompt.nextLine();
        UniversityThesis universityThesis = UniversityThesis.universityThesisId(docName);
        if (universityThesis == null) {
            System.out.println("University thesis not found");
        } else {
            universityThesis.cancelBooking(docName, bookerName);
        }
    }
}
