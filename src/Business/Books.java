package Business;

public class Books extends Document{
    private String isbn;

    public Books(int id, String title, String author, String publicationDate, int numberOfPages, int borrowerId, int bookerId, Status status, String isbn) {
        super(id, title, author, publicationDate, numberOfPages, borrowerId, bookerId, status);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }





    public void returnDocument() {
        System.out.println("Returning a book");
    }

    public void displayDetails() {
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publication Date: " + getPublicationDate());
        System.out.println("Number of Pages: " + getNumberOfPages());
        System.out.println("This is book is " + getStatus());
        System.out.println("ISBN: " + getIsbn());
    }

    @Override
    public void borrow() {
        System.out.println("Borrowing a book");
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
