package Business.Model;

public class UniversityThesis extends Document {

    private String researchDomain;

    public UniversityThesis(int id, String title, String author, String publicationDate, int numberOfPages, int borrowerId, int bookerId, Status status,String researchDomain) {
        super(id, title, author, publicationDate, numberOfPages, borrowerId, bookerId, status);
        this.researchDomain = researchDomain;

    }

    // setters - getters

    public String getResearchDomain() {
        return researchDomain;
    }

    public void setResearchDomain(String researchDomain) {
        this.researchDomain = researchDomain;
    }

    // methods

    @Override
    public void book() {
        System.out.println("The university thesis has been booked.");
    }

    @Override
    public void cancelBooking() {
        System.out.println("The university thesis booking has been canceled.");
    }

    @Override
    public void borrow() {
        System.out.println("The university thesis has been borrowed.");
    }

    @Override
    public void turnBack() {
        System.out.println("The university thesis has been turned back.");
    }
}
