package Business;

import DAO.MagazineDAOImpl;
import DAO.Interfaces.MagazinesDAO;
import java.util.List;

public class Magazines extends Document{
    private int number;
    private static final MagazinesDAO magazinesDAO = new MagazineDAOImpl();

    public Magazines(int id, String title, String author, String publicationDate,Status status, int borrowerId, int bookerId, int number) {
        super(id, title, author, publicationDate,status,  borrowerId, bookerId);
        this.number = number;
    }

    // setters - getters


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    // methods


    public static void addMagazine(int id, String title, String author, String publicationDate, int number) {
        Magazines newMagazine = new Magazines(id, title, author, publicationDate, Status.available, 0, 0, number);
        magazinesDAO.save(newMagazine);
        System.out.println("Magazine added successfully");
    }

    public static void deleteMagazine(int id) {
        magazinesDAO.delete(id);
        System.out.println("Magazine deleted successfully");
    }

    public static void updateMagazine(int id, String title, String author, String publicationDate, int number) {
        Magazines magazine = magazinesDAO.findById(id);
        if (magazine == null) {
            System.out.println("Magazine not found");
            return;
        }
        magazine.setTitle(title);
        magazine.setAuthor(author);
        magazine.setPublicationDate(publicationDate);
        magazine.setNumber(number);
        magazinesDAO.update(magazine);
        System.out.println("Magazine updated successfully");
    }



    public static void displayMagazines() {
        List<Magazines> magazinesList = magazinesDAO.findAll();
        for (Magazines magazine : magazinesList) {
            magazine.displayDetails();
            System.out.println("----------------------------");
        }
    }

    public static void searchMagazine(String title){
        List<Magazines> magazinesList = magazinesDAO.findAll();
        magazinesList.stream()
                .filter(magazines -> magazines.getTitle().toLowerCase().contains(title.toLowerCase()))
                .forEach(magazines -> {
                    magazines.displayDetails();
                    System.out.println("----------------------------");
                });
    }

    public static Magazines magazineId(String title){
        List<Magazines> magazinesList = magazinesDAO.findAll();
        for (Magazines magazine : magazinesList) {
            if (magazine.getTitle().toLowerCase().contains(title.toLowerCase())) {
                return magazine;
            }
        }
        return null;
    }

    public void displayDetails() {
        System.out.println("ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publication Date: " + getPublicationDate());
        System.out.println("This magazine is " + getStatus());
        System.out.println("Number: " + getNumber());
    }




    public void returnDocument() {
        System.out.println("Returning a magazine");
    }




    @Override
    public void borrow(String docName, String borrowerName) {
        Student student = Student.studentId(borrowerName);
        if (student == null) {
            System.out.println("Student not found");
            return;
        }
        Magazines magazine = Magazines.magazineId(docName);
        if (magazine == null) {
            System.out.println("Magazine not found");
            return;
        }

        magazine.setBorrowerId(student.getId());
        magazine.setStatus(Status.borrowed);
        magazinesDAO.update(magazine);
        System.out.println("Magazine borrowed successfully");
    }

    @Override
    public void turnBack(String docName, String borrowerName){

        Student student = Student.studentId(borrowerName);
        if (student == null) {
            System.out.println("Student not found");
            return;
        }
        Magazines magazine = Magazines.magazineId(docName);
        if (magazine == null) {
            System.out.println("Magazine not found");
            return;
        }

        if (magazine.getBorrowerId() != student.getId()) {
            System.out.println("Magazine is not borrowed by this student.");
            return;
        }
        magazine.setBorrowerId(0);


        if (magazine.getBookerId() != 0) {
            int newBorrowerId = magazine.getBookerId();
            magazine.setBorrowerId(newBorrowerId);
            magazine.setBookerId(0);
            magazine.setStatus(Status.borrowed);

            magazinesDAO.update(magazine);


        } else {
            magazine.setStatus(Status.available);
            magazinesDAO.update(magazine);
            System.out.println("Magazine turned back successfully and is now available.");
        }
    }

    @Override
    public void book(String docName, String bookerName){
        Student student = Student.studentId(bookerName);
        if (student == null) {
            System.out.println("Student not found");
            return;
        }
        Magazines magazine = Magazines.magazineId(docName);
        if (magazine == null) {
            System.out.println("Magazine not found");
            return;
        }
        if (magazine.getStatus() == Status.booked) {
            System.out.println("Magazine is already booked.");
            return;
        }

        if (magazine.getStatus() != Status.borrowed) {
            System.out.println("Magazine is available for borrowing, no need to magazine.");
            return;
        }

        magazine.setBookerId(student.getId());
        magazine.setStatus(Status.booked);
        magazinesDAO.update(magazine);
        System.out.println("Magazine booked successfully");

    }

    @Override
    public void cancelBooking(String docName, String bookerName){
        Student student = Student.studentId(bookerName);
        if (student == null) {
            System.out.println("Student not found");
            return;
        }
        Magazines magazine = Magazines.magazineId(docName);
        if (magazine == null) {
            System.out.println("Magazine not found");
            return;
        }

        if (magazine.getBookerId() != student.getId()) {
            System.out.println("You have not booked this magazine.");
            return;
        }

        magazine.setBookerId(0);
        magazine.setStatus(Status.borrowed);
        magazinesDAO.update(magazine);
        System.out.println("Booking cancelled successfully");

    }
}
