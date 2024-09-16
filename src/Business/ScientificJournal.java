package Business;

import DAO.Interfaces.ScientificJournalDAO;
import DAO.ScientificJournalDAOImpl;

import java.util.List;

public class ScientificJournal extends Document {
    private String field;
    private String university;
    private static final ScientificJournalDAO scientificJournalDAO = new ScientificJournalDAOImpl();

    // Constructor
    public ScientificJournal(int id, String title, String author, String publicationDate, Status status, int borrowerId, int bookerId, String field, String university) {
        super(id, title, author, publicationDate, status, borrowerId, bookerId);
        this.field = field;
        this.university = university;
    }

    // Getters and setters
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

    // CRUD operations

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
        List<ScientificJournal> scientificJournalList = scientificJournalDAO.findAll();
        for (ScientificJournal scientificJournal : scientificJournalList) {
            scientificJournal.displayDetails();
            System.out.println("----------------------------");
        }
    }

    public static void searchScientificJournal(String title) {
        List<ScientificJournal> scientificJournalList = scientificJournalDAO.findAll();
        scientificJournalList.stream()
                .filter(scientificJournal -> scientificJournal.getTitle().toLowerCase().contains(title.toLowerCase()))
                .forEach(scientificJournal -> {
                    scientificJournal.displayDetails();
                    System.out.println("----------------------------");
                });
    }

    public void displayDetails() {
        System.out.println("ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publication Date: " + getPublicationDate());
        System.out.println("Field: " + getField());
        System.out.println("University: " + getUniversity());
        System.out.println("Status: " + getStatus());
    }

    public static ScientificJournal scientificJournalId(String title) {
        List<ScientificJournal> scientificJournalList = scientificJournalDAO.findAll();
        for (ScientificJournal scientificJournal : scientificJournalList) {
            if (scientificJournal.getTitle().toLowerCase().equals(title.toLowerCase())) {
                return scientificJournal;
            }
        }
        return null;
    }

    // Borrowing, Returning, Booking, and Canceling Booking methods

    @Override
    public void borrow(String docName, String borrowerName) {
        Student student = Student.studentId(borrowerName);
        if (student == null) {
            System.out.println("Student not found");
            return;
        }

        ScientificJournal scientificJournal = scientificJournalId(docName);
        if (scientificJournal == null) {
            System.out.println("Scientific journal not found");
            return;
        }

        if (scientificJournal.getStatus() == Status.borrowed) {
            System.out.println("Scientific journal is already borrowed");
            return;
        }

        scientificJournal.setBorrowerId(student.getId());
        scientificJournal.setStatus(Status.borrowed);
        scientificJournalDAO.update(scientificJournal);
        System.out.println("Scientific journal borrowed successfully");
    }

    @Override
    public void turnBack(String docName, String borrowerName) {
        Student student = Student.studentId(borrowerName);
        if (student == null) {
            System.out.println("Student not found");
            return;
        }

        ScientificJournal scientificJournal = scientificJournalId(docName);
        if (scientificJournal == null) {
            System.out.println("Scientific journal not found");
            return;
        }

        if (scientificJournal.getStatus() != Status.borrowed) {
            System.out.println("This scientific journal is not borrowed");
            return;
        }

        scientificJournal.setBorrowerId(0);
        scientificJournal.setStatus(Status.available);
        scientificJournalDAO.update(scientificJournal);
        System.out.println("Scientific journal returned successfully");
    }

    @Override
    public void book(String docName, String bookerName) {
        Student student = Student.studentId(bookerName);
        if (student == null) {
            System.out.println("Student not found");
            return;
        }

        ScientificJournal scientificJournal = scientificJournalId(docName);
        if (scientificJournal == null) {
            System.out.println("Scientific journal not found");
            return;
        }

        if (scientificJournal.getStatus() == Status.borrowed) {
            scientificJournal.setBookerId(student.getId());
            scientificJournal.setStatus(Status.booked);
            scientificJournalDAO.update(scientificJournal);
            System.out.println("Scientific journal booked successfully");
        } else {
            System.out.println("This scientific journal is currently available for borrowing");
        }
    }

    @Override
    public void cancelBooking(String docName, String bookerName) {
        Student student = Student.studentId(bookerName);
        if (student == null) {
            System.out.println("Student not found");
            return;
        }

        ScientificJournal scientificJournal = scientificJournalId(docName);
        if (scientificJournal == null) {
            System.out.println("Scientific journal not found");
            return;
        }

        if (scientificJournal.getBookerId() != student.getId()) {
            System.out.println("This student hasn't booked this scientific journal");
            return;
        }

        scientificJournal.setBookerId(0);
        scientificJournal.setStatus(Status.available);
        scientificJournalDAO.update(scientificJournal);
        System.out.println("Scientific journal booking canceled successfully");
    }
}
