package Business;

import DAO.Interfaces.UniversityThesisDAO;
import DAO.UniversityThesisDAOImpl;


import java.util.List;

public class UniversityThesis extends Document {
    private String researchDomain;
    private static final UniversityThesisDAO universityThesisDAO = new UniversityThesisDAOImpl();

    // Constructor
    public UniversityThesis(int id, String title, String author, String publicationDate, Status status, int borrowerId, int bookerId, String researchDomain) {
        super(id, title, author, publicationDate, status, borrowerId, bookerId);
        this.researchDomain = researchDomain;
    }

    // Getters and setters
    public String getResearchDomain() {
        return researchDomain;
    }

    public void setResearchDomain(String researchDomain) {
        this.researchDomain = researchDomain;
    }

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

    public static void displayUniversityThesis() {
        List<UniversityThesis> universityThesisList = universityThesisDAO.findAll();
        for (UniversityThesis universityThesis : universityThesisList) {
            universityThesis.displayDetails();
            System.out.println("----------------------------");
        }
    }

    public static void searchUniversityThesis(String title) {
        List<UniversityThesis> universityThesisList = universityThesisDAO.findAll();
        universityThesisList.stream()
                .filter(thesis -> thesis.getTitle().toLowerCase().contains(title.toLowerCase()))
                .forEach(thesis -> {
                    thesis.displayDetails();
                    System.out.println("----------------------------");
                });
    }



    public void displayDetails() {
        System.out.println("ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publication Date: " + getPublicationDate());
        System.out.println("Research Domain: " + getResearchDomain());
        System.out.println("Status: " + getStatus());
    }

    public static UniversityThesis universityThesisId(String title) {
        List<UniversityThesis> universityThesisList = universityThesisDAO.findAll();
        for (UniversityThesis thesis : universityThesisList) {
            if (thesis.getTitle().toLowerCase().equals(title.toLowerCase())) {
                return thesis;
            }
        }
        return null;
    }

    @Override
    public void borrow(String docName, String borrowerName) {
        Professor professor = Professor.professorId(borrowerName);        if (professor == null) {
            System.out.println("professor not found");
            return;
        }

        UniversityThesis thesis = universityThesisId(docName);
        if (thesis == null) {
            System.out.println("University thesis not found");
            return;
        }

        if (thesis.getStatus() == Status.borrowed) {
            System.out.println("University thesis is already borrowed");
            return;
        }

        thesis.setBorrowerId(professor.getId());
        thesis.setStatus(Status.borrowed);
        universityThesisDAO.update(thesis);
        System.out.println("University thesis borrowed successfully");
    }

    @Override
    public void turnBack(String docName, String borrowerName) {
Professor professor = Professor.professorId(borrowerName); 
            if (professor == null) {
            System.out.println("professor not found");
            return;
        }

        UniversityThesis thesis = universityThesisId(docName);
        if (thesis == null) {
            System.out.println("University thesis not found");
            return;
        }

        if (thesis.getStatus() != Status.borrowed) {
            System.out.println("This thesis is not borrowed");
            return;
        }

        thesis.setBorrowerId(0);
        thesis.setStatus(Status.available);
        universityThesisDAO.update(thesis);
        System.out.println("University thesis returned successfully");
    }

    @Override
    public void book(String docName, String bookerName) {
        Professor professor = Professor.professorId(bookerName);
        if (professor == null) {
            System.out.println("professor not found");
            return;
        }

        UniversityThesis thesis = universityThesisId(docName);
        if (thesis == null) {
            System.out.println("University thesis not found");
            return;
        }

        if (thesis.getStatus() == Status.borrowed) {
            thesis.setBookerId(professor.getId());
            thesis.setStatus(Status.booked);
            universityThesisDAO.update(thesis);
            System.out.println("University thesis booked successfully");
        } else {
            System.out.println("This thesis is currently available for borrowing");
        }
    }

    @Override
    public void cancelBooking(String docName, String bookerName) {
        Professor professor = Professor.professorId(bookerName);
        if (professor == null) {
            System.out.println("professor not found");
            return;
        }

        UniversityThesis thesis = universityThesisId(docName);
        if (thesis == null) {
            System.out.println("University thesis not found");
            return;
        }

        if (thesis.getBookerId() != professor.getId()) {
            System.out.println("This professor hasn't booked this thesis");
            return;
        }

        thesis.setBookerId(0);
        thesis.setStatus(Status.available);
        universityThesisDAO.update(thesis);
        System.out.println("University thesis booking canceled successfully");
    }


}
