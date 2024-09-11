package Business;

import DAO.BooksDAOImpl;
import DAO.Interfaces.BooksDAO;

public class Books extends Document{
    private String isbn;
    private static final BooksDAO booksDAO = new BooksDAOImpl();



    public Books(int id, String title, String author, String publicationDate, Status status, int borrowerId, int bookerId, String isbn) {
        super(id, title, author, publicationDate,status, borrowerId, bookerId);
        this.isbn = isbn;
    }

    // setters - getters

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }



    // methods

    // methods
    public static void addBook(int id, String title, String author, String publicationDate, String isbn) {
        Books newBook = new Books(id, title, author, publicationDate, Status.available, 0, 0, isbn);
        booksDAO.save(newBook);
        System.out.println("Book added successfully");
    }

    public void displayDetails() {
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publication Date: " + getPublicationDate());
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
