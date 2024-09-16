package Business;

import DAO.Interfaces.UniversityThesisDAO;
import DAO.UniversityThesisDAOImpl;

import java.util.List;

public class UniversityThesis extends Document {

    private String researchDomain;
    private static final UniversityThesisDAO universityThesisDAO = new UniversityThesisDAOImpl();

    public UniversityThesis(int id, String title, String author, String publicationDate, Status status,int borrowerId, int bookerId, String researchDomain) {
        super(id, title, author, publicationDate, status,  borrowerId, bookerId);
        this.researchDomain = researchDomain;

    }

    // setters - getters

    public String getResearchDomain() {
        return researchDomain;
    }

    public void setResearchDomain(String researchDomain) {
        this.researchDomain = researchDomain;
    }


    //mehtods
    public static void addUniversityThesis(int id, String title, String author, String publicationDate, String researchDomain) {
        UniversityThesis newUniversityThesis = new UniversityThesis(id, title, author, publicationDate, Status.available, 0, 0, researchDomain);
        universityThesisDAO.save(newUniversityThesis);
        System.out.println("University thesis added successfully");
    }

    public static void deleteUniversityThesis(int id) {
        universityThesisDAO.delete(id);
        System.out.println("University thesis deleted successfully");
    }

    public static void updateUniversityThesis(int id, String title, String author, String publicationDate, String researchDomain) {
        UniversityThesis universityThesis = universityThesisDAO.findById(id);
        if (universityThesis == null) {
            System.out.println("University thesis not found");
            return;
        }
        universityThesis.setTitle(title);
        universityThesis.setAuthor(author);
        universityThesis.setPublicationDate(publicationDate);
        universityThesis.setResearchDomain(researchDomain);
        universityThesisDAO.update(universityThesis);
        System.out.println("University thesis updated successfully");
    }

    public static void searchUniversityThesis(String title){
        List<UniversityThesis> universityThesisList = universityThesisDAO.findAll();
        universityThesisList.stream()
                .filter(universityThesis -> universityThesis.getTitle().contains(title.toLowerCase()))
                .forEach(universityThesis -> {
                    universityThesis.displayDetails();
                    System.out.println("--------------------------");
                });
    }

    public static void displayUniversityThesis() {
        universityThesisDAO.findAll().forEach(universityThesis -> {
            System.out.println("ID: " + universityThesis.getId() + " Title: " + universityThesis.getTitle() + " Author: " + universityThesis.getAuthor() + " Publication Date: " + universityThesis.getPublicationDate() + " Research Domain: " + universityThesis.getResearchDomain());
        });
    }

    public void displayDetails() {
        System.out.println("ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publication Date: " + getPublicationDate());
        System.out.println("Research Domain: " + getResearchDomain());
    }

    public static UniversityThesis universityThesisId(String title) {
        List<UniversityThesis> universityThesisList = universityThesisDAO.findAll();
        for (UniversityThesis universityThesis : universityThesisList) {
            if (universityThesis.getTitle().equals(title)) {
                return universityThesis;
            }
        }
        return null;
    }



    // methods

    @Override
    public void book(String docName, String bookerName) {
        System.out.println("The university thesis has been booked.");
    }

    @Override
    public void cancelBooking() {
        System.out.println("The university thesis booking has been canceled.");
    }

    @Override
    public void borrow(String docName, String borrowerName) {
        Student student = Student.studentId(borrowerName);
        if (student == null) {
            System.out.println("Student not found");
            return;
        }

        UniversityThesis universityThesis = UniversityThesis.universityThesisId(docName);
        if (universityThesis == null) {
            System.out.println("University thesis not found");
            return;
        }

        if (universityThesis.getStatus() == Status.borrowed) {
            System.out.println("The university thesis is already borrowed.");
            return;
        }

        universityThesis.setBorrowerId(student.getId());
        universityThesis.setStatus(Status.borrowed);
        universityThesisDAO.update(universityThesis);
        System.out.println("The university thesis has been borrowed successfully.");

    }

    @Override
    public void turnBack(String docName, String borrowerName) {
        Student student = Student.studentId(borrowerName);
        if (student == null) {
            System.out.println("Student not found");
            return;
        }

        UniversityThesis universityThesis = UniversityThesis.universityThesisId(docName);
        if (universityThesis == null) {
            System.out.println("University thesis not found");
            return;
        }

        if (universityThesis.getStatus() == Status.available) {
            System.out.println("The university thesis is already available.");
            return;
        }

        universityThesis.setBorrowerId(0);
        universityThesis.setStatus(Status.available);
        universityThesisDAO.update(universityThesis);
        System.out.println("The university thesis has been returned successfully.");
    }
}
