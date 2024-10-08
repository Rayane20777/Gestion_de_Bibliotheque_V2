package Business;

import DAO.BooksDAOImpl;
import DAO.Interfaces.BooksDAO;
import Resources.Generators;
import java.util.Optional;

import java.util.List;


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
    public static void addBook(int id, String title, String author, String publicationDate) {
        String isbn = Generators.isbnGenerator();

        Books newBook = new Books(id, title, author, publicationDate, Status.available, 0, 0, isbn);
        booksDAO.save(newBook);
        System.out.println("Book added successfully");
    }

    public static void deleteBook(int id) {
        booksDAO.delete(id);
        System.out.println("Book deleted successfully");
    }

    public static void updateBook(int id, String title, String author, String publicationDate, String isbn) {
        Books book = booksDAO.findById(id);
        if (book == null) {
            System.out.println("Book not found");
            return;
        }
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublicationDate(publicationDate);
        book.setIsbn(isbn);
        booksDAO.update(book);
        System.out.println("Book updated successfully");
    }



    public static void displayBooks() {
        List<Books> booksList = booksDAO.findAll();
        for (Books book : booksList) {
            book.displayDetails();
            System.out.println("----------------------------");
        }
    }

    public static void searchBook(String title) {
        List<Books> booksList = booksDAO.findAll();
        booksList.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .forEach(book -> {
                    book.displayDetails();
                    System.out.println("----------------------------");
                });
    }

    public static  Books bookId(String title) {
        List<Books> booksList = booksDAO.findAll();
        for (Books book : booksList) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                return book;
            }
        }
        return null;
    }


    public void displayDetails() {
        System.out.println("ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publication Date: " + getPublicationDate());
        System.out.println("This book is " + getStatus());
        System.out.println("ISBN: " + getIsbn());
    }


    @Override
    public void borrow(String docName, String borrowerName) {
        Student student = Student.studentId(borrowerName);
        if (student == null) {
            System.out.println("Student not found");
            return;

        }

        Books book = Books.bookId(docName);
        if (book == null) {
            System.out.println("Book not found");
            return;
        }


        if (book.getStatus() != Status.available) {
            System.out.println("Book is not available for borrowing");
            return;
        }

        book.setBorrowerId(student.getId());
        book.setStatus(Status.borrowed);
        booksDAO.update(book);
        System.out.println("Book borrowed successfully ");

    }
    @Override
    public void turnBack(String docName, String borrowerName) {
        Student student = Student.studentId(borrowerName);
        if (student == null) {
            System.out.println("Student not found");
            return;
        }

        Books book = Books.bookId(docName);
        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        if (book.getBorrowerId() != student.getId()) {
            System.out.println("Book is not borrowed by this student.");
            return;
        }

        book.setBorrowerId(0);

        if (book.getBookerId() != 0) {
            int newBorrowerId = book.getBookerId();
            book.setBorrowerId(newBorrowerId);
            book.setBookerId(0);
            book.setStatus(Status.borrowed);

            booksDAO.update(book);


        } else {
            book.setStatus(Status.available);
            booksDAO.update(book);
            System.out.println("Book turned back successfully and is now available.");
        }
    }

    @Override
    public void book(String docName, String bookerName){
        Student student = Student.studentId(bookerName);
        if (student == null) {
            System.out.println("Student not found");
            return;
        }

        Books book = Books.bookId(docName);
        if (book == null) {
            System.out.println("Book not found");
            return;
        }
        if (book.getStatus() == Status.booked) {
            System.out.println("Book is already booked.");
            return;
        }

        if (book.getStatus() != Status.borrowed) {
            System.out.println("Book is available for borrowing, no need to book.");
            return;
        }



        book.setBookerId(student.getId());
        book.setStatus(Status.booked);
        booksDAO.update(book);
        System.out.println("Book booked successfully.");

    }

    @Override
    public void cancelBooking(String docName, String bookerName){
        Student student = Student.studentId(bookerName);
        if (student == null) {
            System.out.println("Student not found");
            return;
        }

        Books book = Books.bookId(docName);
        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        if (book.getBookerId() != student.getId()) {
            System.out.println("You have not booked this book.");
            return;
        }

        book.setBookerId(0);
        book.setStatus(Status.borrowed);
        booksDAO.update(book);
        System.out.println("Booking canceled successfully.");
    }

}
