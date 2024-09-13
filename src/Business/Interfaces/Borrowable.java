package Business.Interfaces;

public interface Borrowable {
    void borrow(String docName, String borrowerName);
    void turnBack(String docName, String borrowerName);
}
