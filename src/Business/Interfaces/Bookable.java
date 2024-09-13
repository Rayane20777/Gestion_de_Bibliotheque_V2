package Business.Interfaces;

import Business.Books;
import Business.Student;

public interface Bookable {
    void book(Books docId, Student bookerId);
    void cancelBooking();
}
