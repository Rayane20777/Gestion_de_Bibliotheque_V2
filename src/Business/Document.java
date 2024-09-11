package Business;

import Business.Interfaces.Bookable;
import Business.Interfaces.Borrowable;

abstract public class Document implements Bookable, Borrowable {
    private int id;
    private String title;
    private String author;
    private String publicationDate;
    private Status status;
    private int borrowerId;
    private int bookerId;
    public enum Status{
        available,
        borrowed,
        booked
    }

    public Document(int id, String title, String author, String publicationDate,Status status, int borrowerId, int bookerId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.status = status;
        this.borrowerId = borrowerId;
        this.bookerId = bookerId;

    }

    // setters - getters


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getBookerId() {
        return bookerId;
    }

    public void setBookerId(int bookerId) {
        this.bookerId = bookerId;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }


}
