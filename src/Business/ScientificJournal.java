package Business;

import DAO.Interfaces.ScientificJournalDAO;
import DAO.ScientificJournalDAOImpl;

import java.util.List;

public class ScientificJournal extends Document {
    private String field;
    private String university;
    private static final ScientificJournalDAO scientificJournalDAO = new ScientificJournalDAOImpl();

    public ScientificJournal(int id, String title, String author, String publicationDate, Status status, int borrowerId, int bookerId, String field , String university) {
        super(id, title, author, publicationDate, status, borrowerId, bookerId);
        this.field = field;
        this.university = university;
    }

    // setters - getters

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }


    // methods

    public static void addScientificJournal(int id, String title, String author, String publicationDate, String field, String university) {
        ScientificJournal newScientificJournal = new ScientificJournal(id, title, author, publicationDate, Status.available, 0, 0, field, university);
        scientificJournalDAO.save(newScientificJournal);
        System.out.println("Scientific journal added successfully");
    }

    public static void deleteScientificJournal(int id) {
        scientificJournalDAO.delete(id);
        System.out.println("Scientific journal deleted successfully");
    }

    public static void updateScientificJournal(int id, String title, String author, String publicationDate, String field, String university) {
        ScientificJournal scientificJournal = scientificJournalDAO.findById(id);
        if (scientificJournal == null) {
            System.out.println("Scientific journal not found");
            return;
        }
        scientificJournal.setTitle(title);
        scientificJournal.setAuthor(author);
        scientificJournal.setPublicationDate(publicationDate);
        scientificJournal.setField(field);
        scientificJournal.setUniversity(university);
        scientificJournalDAO.update(scientificJournal);
        System.out.println("Scientific journal updated successfully");
    }

    public static void displayScientificJournals() {
        List<ScientificJournal> scientificJournalsList = scientificJournalDAO.findAll();
        for (ScientificJournal scientificJournal : scientificJournalsList) {
            scientificJournal.displayDetails();
            System.out.println("----------------------------");
        }
    }

    public void displayDetails() {
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publication Date: " + getPublicationDate());
        System.out.println("Field: " + getField());
        System.out.println("University: " + getUniversity());
    }



    public void returnDocument() {
        System.out.println("Returning a scientific journal");
    }


    // methods

    @Override
    public void borrow() {
        System.out.println("Borrowing a scientific journal");
    }

    @Override
    public void book() {
        System.out.println("Booking a scientific journal");
    }

    @Override
    public void cancelBooking() {
        System.out.println("Canceling booking of a scientific journal");
    }

    @Override
    public void turnBack() {
        System.out.println("Turning back a scientific journal");
    }
}
