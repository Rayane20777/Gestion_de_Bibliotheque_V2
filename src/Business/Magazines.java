package Business;

public class Magazines extends Document{
    private int number;

    public Magazines(int id, String title, String author, String publicationDate, int numberOfPages,int borrowerId, int bookerId, Status status, int number) {
        super(id, title, author, publicationDate, numberOfPages, borrowerId, bookerId, status);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void returnDocument() {
        System.out.println("Returning a magazine");
    }

    public void displayDetails() {
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publication Date: " + getPublicationDate());
        System.out.println("Number of Pages: " + getNumberOfPages());
        System.out.println("This is book is " + getStatus());
        System.out.println("Number: " + getNumber());
    }

    @Override
    public void borrow() {
        System.out.println("Borrowing a magazine");
    }

    @Override
    public void turnBack(){

    }

    @Override
    public void book(){

    }

    @Override
    public void cancelBooking(){

    }
}
