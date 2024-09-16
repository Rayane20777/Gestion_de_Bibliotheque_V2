package Business.Interfaces;

import Business.Books;
import Business.Student;

public interface Bookable {
    void book(String docName, String bookerName);
    void cancelBooking();
}
