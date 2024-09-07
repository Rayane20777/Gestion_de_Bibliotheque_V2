package Business;

public class Magazines extends Document{
    private int number;

    public Magazines(String title, String author, String publicationDate, int numberOfPages, int number) {
        super(title, author, publicationDate, numberOfPages);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void borrow() {
        System.out.println("Borrowing a magazine");
    }

    public void returnDocument() {
        System.out.println("Returning a magazine");
    }

    public void displayDetails() {
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publication Date: " + getPublicationDate());
        System.out.println("Number of Pages: " + getNumberOfPages());
        System.out.println("Number: " + getNumber());
    }
}
