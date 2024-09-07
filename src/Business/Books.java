package Business;

public class Books extends Document{
    private String isbn;
    private String genre;

    public Books(String title, String author, String publicationDate, int numberOfPages, String isbn, String genre) {
        super(title, author, publicationDate, numberOfPages);
        this.isbn = isbn;
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void borrow() {
        System.out.println("Borrowing a book");
    }

    public void returnDocument() {
        System.out.println("Returning a book");
    }

    public void displayDetails() {
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publication Date: " + getPublicationDate());
        System.out.println("Number of Pages: " + getNumberOfPages());
        System.out.println("ISBN: " + getIsbn());
        System.out.println("Genre: " + getGenre());
    }
}
