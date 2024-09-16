package Ui;

import java.util.Scanner;

import Business.*;
import Resources.InputValidator;


public class AdminConsole {
    public static void admin(){
        Scanner prompt = new Scanner(System.in);

        System.out.println("******************************");
        System.out.println("Choose an option:");
        System.out.println("1. Manage documents");
        System.out.println("2. Manage users");
        System.out.println("3. exit");
        System.out.println("******************************");

        int choice = InputValidator.intValidator(prompt);

        switch (choice) {
            case 1:
                docManagement(prompt);
                break;
            case 2:
                userManagement(prompt);
                break;
            case 3:
                System.out.println("go back");
                return;
            default:
                System.out.println("Invalid choice");

        }

    }

    public static void docManagement(Scanner prompt){
        System.out.println("******************************");
        System.out.println("Choose an option:");
        System.out.println("1. Manage Books");
        System.out.println("2. Manage Magazines");
        System.out.println("3. Manage Scientific Journals");
        System.out.println("4. Manage University Thesis");
        System.out.println("5. Go back");
        System.out.println("6. Exit program");
        System.out.println("******************************");

        int choice = InputValidator.intValidator(prompt);

        switch (choice) {
            case 1:
                manageBooks(prompt);
                break;
            case 2:
                manageMagazines(prompt);
                break;
            case 3:
                manageScientificJournals(prompt);
                break;
            case 4:
                manageUniversityThesis(prompt);
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

    public static void userManagement(Scanner prompt){
        System.out.println("******************************");
        System.out.println("Choose an option:");
        System.out.println("1. Manage Student");
        System.out.println("2. Manage Professor");
        System.out.println("3. Go back");
        System.out.println("4. Exit program");
        System.out.println("******************************");

        int choice = InputValidator.intValidator(prompt);

        switch (choice) {
            case 1:
                manageStudent(prompt);
                break;
            case 2:
                professorManagement(prompt);
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

    public static void manageStudent(Scanner prompt){
        while(true) {

            System.out.println("******************************");
            System.out.println("Choose an option:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Update Student");
            System.out.println("4. Display all Students");
            System.out.println("5. Search for a Student");
            System.out.println("6. Go back");
            System.out.println("7. Exit program");
            System.out.println("******************************");

            int choice = InputValidator.intValidator(prompt);

            switch (choice) {
                case 1:
                    addStudent(prompt);
                    break;
                case 2:
                    removeStudent(prompt);
                    break;
                case 3:
                    updateStudent(prompt);
                    break;
                case 4:
                    displayStudents();
                    break;
                case 5:
                    System.out.println("Enter student name:");
                    String name = prompt.next();
                    Student.searchStudent(name);
                    break;
                case 6:
                    System.out.println("Go back");
                    return;
                case 7:
                    System.out.println("exit program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }
    }

    public static void professorManagement(Scanner prompt){
        while(true){
            System.out.println("******************************");
            System.out.println("Choose an option:");
            System.out.println("1. Add Professor");
            System.out.println("2. Remove Professor");
            System.out.println("3. Update Professor");
            System.out.println("4. Display all Professors");
            System.out.println("5. Search for a Professor");
            System.out.println("6. Go back");
            System.out.println("7. Exit program");
            System.out.println("******************************");

            int choice = InputValidator.intValidator(prompt);

            switch (choice) {
                case 1:
                    addProfessor(prompt);
                    break;
                case 2:
                    removeProfessor(prompt);
                    break;
                case 3:
                    updateProfessor(prompt);
                    break;
                case 4:
                    displayProfessors();
                    break;
                case 5:
                    System.out.println("Enter professor name:");
                    String name = prompt.next();
                    Professor.searchProfessor(name);
                    break;
                case 6:
                    System.out.println("Go back");
                    return;
                case 7:
                    System.out.println("exit program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");

            }
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
            System.out.println("5. Search for a book");
            System.out.println("6. Go back");
            System.out.println("7. Exit program");
            System.out.println("******************************");

            int choice = InputValidator.intValidator(prompt);

            switch (choice) {
                case 1:
                    addBook(prompt);
                    break;
                case 2:
                    removeBook(prompt);
                    break;
                case 3:
                    updateBook(prompt);
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    System.out.println("Enter book title:");
                    String title = prompt.next();
                    Books.searchBook(title);
                    break;
                case 6:
                    System.out.println("Go back");
                    return;
                case 7:
                    System.out.println("exit program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }
    }

    private static void manageMagazines(Scanner prompt) {
        while (true) {
            System.out.println("******************************");
            System.out.println("Choose an option:");
            System.out.println("1. Add a magazine");
            System.out.println("2. Remove a magazine");
            System.out.println("3. Update a magazine");
            System.out.println("4. Display all magazines");
            System.out.println("5. Search a magazine");
            System.out.println("6. Go back");
            System.out.println("7. Exit program");
            System.out.println("******************************");

            int choice = InputValidator.intValidator(prompt);

            switch (choice) {
                case 1:
                    addMagazine(prompt);
                    break;
                case 2:
                    removeMagazine(prompt);
                    break;
                case 3:
                    updateMagazine(prompt);
                    break;
                case 4:
                    displayMagazines();
                    break;
                case 5:
                    System.out.println("Enter magazine title:");
                    String title = prompt.next();
                    Magazines.searchMagazine(title);
                    break;
                case 6:
                    System.out.println("Go back");
                    return;
                case 7:
                    System.out.println("exit program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void manageScientificJournals(Scanner prompt) {
        while(true){
            System.out.println("******************************");
            System.out.println("Choose an option:");
            System.out.println("1. Add a Scientific Journal");
            System.out.println("2. Remove a Scientific Journal");
            System.out.println("3. Update a Scientific Journal");
            System.out.println("4. Display all Scientific Journals");
            System.out.println("5. Search a Scientific Journal");
            System.out.println("6. Go back");
            System.out.println("7. Exit program");
            System.out.println("******************************");

            int choice = InputValidator.intValidator(prompt);

            switch (choice) {
                case 1:
                    addScientificJournal(prompt);
                    break;
                case 2:
                    removeScientificJournal(prompt);
                    break;
                case 3:
                    updateScientificJournal(prompt);
                    break;
                case 4:
                    displayScientificJournals();
                    break;
                case 5:
                    System.out.println("Enter Scientific Journal title:");
                    String title = prompt.next();
                    ScientificJournal.searchScientificJournal(title);
                    break;
                case 6:
                    System.out.println("Go back");
                    return;
                case 7:
                    System.out.println("exit program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }
    }

    private static void manageUniversityThesis(Scanner prompt) {
        while(true){
            System.out.println("******************************");
            System.out.println("Choose an option:");
            System.out.println("1. Add a University Thesis");
            System.out.println("2. Remove a University Thesis");
            System.out.println("3. Update a University Thesis");
            System.out.println("4. Display all University Thesis");
            System.out.println("5. Search a University Thesis");
            System.out.println("6. Go back");
            System.out.println("7. Exit program");
            System.out.println("******************************");

            int choice = InputValidator.intValidator(prompt);

            switch (choice) {
                case 1:
                    addUniversityThesis(prompt);
                    break;
                case 2:
                    removeUniversityThesis(prompt);
                    break;
                case 3:
                    updateUniversityThesis(prompt);
                    break;
                case 4:
                    displayUniversityThesis();
                    break;
                case 5:
                    System.out.println("Enter University Thesis title:");
                    String title = prompt.next();
                    UniversityThesis.searchUniversityThesis(title);
                    break;
                case 6:
                    System.out.println("Go back");
                    return;
                case 7:
                    System.out.println("exit program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }
    }

    // University Thesis methods ********************************************

    private static void addUniversityThesis(Scanner prompt) {
        System.out.println("Enter University Thesis ID:");
        int id = InputValidator.intValidator(prompt);
        prompt.nextLine();

        System.out.println("Enter Title:");
        String title = prompt.nextLine();

        System.out.println("Enter Author:");
        String author = prompt.nextLine();

        System.out.println("Enter Publication Date (yyyy-MM-dd):");
        String publicationDate;
        while (true) {
            publicationDate = prompt.nextLine();
            if (InputValidator.dateValidator(publicationDate)) {
                break;
            } else {
                System.out.println("Invalid date. Please enter a valid publication date (yyyy-MM-dd):");
            }
        }

        System.out.println("Enter research domain:");
        String researchDomain = prompt.nextLine();

        UniversityThesis.addUniversityThesis(id, title, author, publicationDate, researchDomain);
    }

    private static void removeUniversityThesis(Scanner prompt) {
        System.out.println("Enter University Thesis ID:");
        int id = InputValidator.intValidator(prompt);
        prompt.nextLine();
        UniversityThesis.deleteUniversityThesis(id);
    }

    private static void updateUniversityThesis(Scanner prompt) {
        System.out.println("Enter University Thesis ID to update:");
        int id = InputValidator.intValidator(prompt);
        prompt.nextLine();

        System.out.println("Enter new Title:");
        String title = prompt.nextLine();
        System.out.println("Enter new Author:");
        String author = prompt.nextLine();
        System.out.println("Enter Publication Date (yyyy-MM-dd):");
        String publicationDate;
        while (true) {
            publicationDate = prompt.nextLine();
            if (InputValidator.dateValidator(publicationDate)) {
                break;
            } else {
                System.out.println("Invalid date. Please enter a valid publication date (yyyy-MM-dd):");
            }
        }
        System.out.println("Enter new research domain:");
        String researchDomain = prompt.nextLine();

        UniversityThesis.updateUniversityThesis(id, title, author, publicationDate, researchDomain);
    }

    private static void displayUniversityThesis() {
        UniversityThesis.displayUniversityThesis();
    }

    // Scientific Journals methods ********************************************

    private static void addScientificJournal(Scanner prompt) {
        System.out.println("Enter Scientific Journal ID:");
        int id = InputValidator.intValidator(prompt);
        prompt.nextLine();

        System.out.println("Enter Title:");
        String title = prompt.nextLine();

        System.out.println("Enter Author:");
        String author = prompt.nextLine();

        System.out.println("Enter Publication Date (yyyy-MM-dd):");
        String publicationDate;
        while (true) {
            publicationDate = prompt.nextLine();
            if (InputValidator.dateValidator(publicationDate)) {
                break;
            } else {
                System.out.println("Invalid date. Please enter a valid publication date (yyyy-MM-dd):");
            }
        }

        System.out.println("Enter filed:");
        String field = prompt.nextLine();

        System.out.println("Enter university:");
        String university = prompt.nextLine();


        ScientificJournal.addScientificJournal(id, title, author, publicationDate, field, university);
    }

    private static void removeScientificJournal(Scanner prompt) {
        System.out.println("Enter Scientific Journal ID:");
        int id = InputValidator.intValidator(prompt);
        prompt.nextLine();
        ScientificJournal.deleteScientificJournal(id);
    }

    private static void updateScientificJournal(Scanner prompt) {
        System.out.println("Enter Scientific Journal ID to update:");
        int id = InputValidator.intValidator(prompt);
        prompt.nextLine();

        System.out.println("Enter new Title:");
        String title = prompt.nextLine();
        System.out.println("Enter new Author:");
        String author = prompt.nextLine();
        System.out.println("Enter Publication Date (yyyy-MM-dd):");
        String publicationDate;
        while (true) {
            publicationDate = prompt.nextLine();
            if (InputValidator.dateValidator(publicationDate)) {
                break;
            } else {
                System.out.println("Invalid date. Please enter a valid publication date (yyyy-MM-dd):");
            }
        }
        System.out.println("Enter new field:");
        String field = prompt.nextLine();
        System.out.println("Enter new university:");
        String university = prompt.nextLine();


        ScientificJournal.updateScientificJournal(id, title, author, publicationDate, field, university);
    }

    private static void displayScientificJournals() {
        ScientificJournal.displayScientificJournals();
    }

    // Books methods ***********************************************************

    private static void addBook(Scanner prompt) {
        System.out.println("Enter Book ID:");
        int id = InputValidator.intValidator(prompt);
        prompt.nextLine();

        System.out.println("Enter Title:");
        String title = prompt.nextLine();

        System.out.println("Enter Author:");
        String author = prompt.nextLine();

        System.out.println("Enter Publication Date (yyyy-MM-dd):");
        String publicationDate;
        while (true) {
            publicationDate = prompt.nextLine();
            if (InputValidator.dateValidator(publicationDate)) {
                break;
            } else {
                System.out.println("Invalid date. Please enter a valid publication date (yyyy-MM-dd):");
            }
        }



        Books.addBook(id, title, author, publicationDate);
    }

    private static void removeBook(Scanner prompt) {
        System.out.println("Enter Book ID:");
        int id = InputValidator.intValidator(prompt);
        prompt .nextLine();
        Books.deleteBook(id);
    }

    private static void updateBook(Scanner prompt) {
        System.out.println("Enter Book ID to update:");
        int id = InputValidator.intValidator(prompt);
        prompt.nextLine();

        System.out.println("Enter new Title:");
        String title = prompt.nextLine();
        System.out.println("Enter new Author:");
        String author = prompt.nextLine();
        System.out.println("Enter Publication Date (yyyy-MM-dd):");
        String publicationDate;
        while (true) {
            publicationDate = prompt.nextLine();
            if (InputValidator.dateValidator(publicationDate)) {
                break;
            } else {
                System.out.println("Invalid date. Please enter a valid publication date (yyyy-MM-dd):");
            }
        }
        System.out.println("Enter new ISBN:");
        String isbn = prompt.nextLine();

        Books.updateBook(id, title, author, publicationDate, isbn);
    }

    private static void displayBooks() {
        Books.displayBooks();
    }

    // Magazines methods *******************************************************

    private static void addMagazine(Scanner prompt) {
        System.out.println("Enter Magazine ID:");
        int id = InputValidator.intValidator(prompt);
        prompt.nextLine();

        System.out.println("Enter Title:");
        String title = prompt.nextLine();

        System.out.println("Enter Author:");
        String author = prompt.nextLine();

        System.out.println("Enter Publication Date (yyyy-MM-dd):");
        String publicationDate;
        while (true) {
            publicationDate = prompt.nextLine();
            if (InputValidator.dateValidator(publicationDate)) {
                break;
            } else {
                System.out.println("Invalid date. Please enter a valid publication date (yyyy-MM-dd):");
            }
        }

        System.out.println("Enter ISBN:");
        int number = InputValidator.intValidator(prompt);
        prompt.nextLine();

        Magazines.addMagazine(id, title, author, publicationDate, number);
    }

    private static void removeMagazine(Scanner prompt) {
        System.out.println("Enter Magazine ID:");
        int id = InputValidator.intValidator(prompt);
        prompt.nextLine();
        Magazines.deleteMagazine(id);
    }

    private static void updateMagazine(Scanner prompt) {
        System.out.println("Enter Magazine ID to update:");
        int id = InputValidator.intValidator(prompt);
        prompt.nextLine();

        System.out.println("Enter new Title:");
        String title = prompt.nextLine();
        System.out.println("Enter new Author:");
        String author = prompt.nextLine();
        System.out.println("Enter Publication Date (yyyy-MM-dd):");
        String publicationDate;
        while (true) {
            publicationDate = prompt.nextLine();
            if (InputValidator.dateValidator(publicationDate)) {
                break;
            } else {
                System.out.println("Invalid date. Please enter a valid publication date (yyyy-MM-dd):");
            }
        }
        System.out.println("Enter new ISBN:");
        int number = InputValidator.intValidator(prompt);
        prompt.nextLine();

        Magazines.updateMagazine(id, title, author, publicationDate, number);
    }

    private static void displayMagazines() {
        Magazines.displayMagazines();
    }

    private static void addStudent(Scanner prompt) {
        System.out.println("Enter Student ID:");
        int id = InputValidator.intValidator(prompt);
        prompt.nextLine();

        System.out.println("Enter Name:");
        String name = prompt.nextLine();

        System.out.println("Enter Email:");
        String email;
        while (true) {
            email = prompt.nextLine();
            if (InputValidator.emailValidator(email)) {
                break;
            } else {
                System.out.println("Invalid email. Please enter a valid email address:");
            }
        }


        System.out.println("Enter Faculty:");
        String faculty = prompt.nextLine();

        System.out.println("Enter Grade:");
        String grade = prompt.nextLine();

        Student.addStudent(id, name, email, faculty, grade);

    }

    private static void removeStudent(Scanner prompt) {
        System.out.println("Enter Student ID:");
        int id = InputValidator.intValidator(prompt);
        prompt.nextLine();
        Student.removeStudent(id);
    }

    private static void updateStudent(Scanner prompt) {
        System.out.println("Enter Student ID to update:");
        int id = InputValidator.intValidator(prompt);
        prompt.nextLine();

        System.out.println("Enter new Name:");
        String name = prompt.nextLine();
        System.out.println("Enter new Email:");
        String email;
        while (true) {
            email = prompt.nextLine();
            if (InputValidator.emailValidator(email)) {
                break;
            } else {
                System.out.println("Invalid email. Please enter a valid email address:");
            }
        }
        System.out.println("Enter new Faculty:");
        String faculty = prompt.nextLine();
        System.out.println("Enter new Grade:");
        String grade = prompt.nextLine();

        Student.updateStudent(id, name, email, faculty, grade);


    }

    private static void displayStudents() {
        Student.displayStudents();

    }

    private static void addProfessor(Scanner prompt) {
        System.out.println("Enter Professor ID:");
        int id = InputValidator.intValidator(prompt);
        prompt.nextLine();

        System.out.println("Enter Name:");
        String name = prompt.nextLine();

        System.out.println("Enter Email:");
        String email = prompt.nextLine();

        System.out.println("Enter Department:");
        String department = prompt.nextLine();

        Professor.addProfessor(id, name, email, department);

    }

    private static void removeProfessor(Scanner prompt) {
        System.out.println("Enter Professor ID:");
        int id = InputValidator.intValidator(prompt);
        prompt.nextLine();
        Professor.removeProfessor(id);
    }

    private static void updateProfessor(Scanner prompt) {
        System.out.println("Enter Professor ID to update:");
        int id = InputValidator.intValidator(prompt);
        prompt.nextLine();

        System.out.println("Enter new Name:");
        String name = prompt.nextLine();
        System.out.println("Enter new Email:");
        String email = prompt.nextLine();
        System.out.println("Enter new Department:");
        String department = prompt.nextLine();

        Professor.updateProfessor(id, name, email, department);
    }

    private static void displayProfessors() {
        Professor.displayProfessors();
    }

}