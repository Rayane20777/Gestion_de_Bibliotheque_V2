package Business;

public class ScientificJournal extends Document {
    private String field;
    private String university;

    public ScientificJournal(int id, String title, String author, String publicationDate, int numberOfPages, int borrowerId, int bookerId, Status status, String field , String university) {
        super(id, title, author, publicationDate, numberOfPages, borrowerId, bookerId, status);
        this.field = field;
        this.university = university;
    }

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


    public void returnDocument() {
        System.out.println("Returning a scientific journal");
    }

    public void displayDetails() {
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publication Date: " + getPublicationDate());
        System.out.println("Number of Pages: " + getNumberOfPages());
        System.out.println("Field: " + getField());
        System.out.println("University: " + getUniversity());
    }

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
