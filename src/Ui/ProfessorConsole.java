package Ui;

import java.util.Scanner;

import Business.ScientificJournal;
import Business.UniversityThesis;


public class ProfessorConsole {

    public static void professorMenu() {
        Scanner prompt = new Scanner(System.in);
        while (true) {
            System.out.println("******************************");
            System.out.println("1. Borrow a scientific journal");
            System.out.println("2. Borrow a university thesis");
            System.out.println("3. Return a scientific journal");
            System.out.println("4. Return a university thesis");
            System.out.println("5. Cancel scientific journal booking");
            System.out.println("6. Cancel university thesis booking");
            System.out.println("7. go back");
            System.out.println("8. exit");
            System.out.println("******************************");

            int choice = prompt.nextInt();
            prompt.nextLine();

            switch (choice) {
                case 1:
                {
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
                    break;
                case 2:
                {
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
                    break;
                case 3:
                {
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
                    break;
                case 4:
                {
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
                    break;
                case 5:
                    System.out.println("Cancel scientific journal booking");
                    break;
                case 6:
                    System.out.println("Cancel university thesis booking");
                    break;
                case 7:
                    System.out.println("Go back");
                    return;
                case 8:
                    System.out.println("exit program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");

            }

        }
    }

}
