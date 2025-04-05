import java.io.*;
import java.util.*;

public class User implements Serializable {
    private String userId;
    private String name;
    private List<String> issuedBooks;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public List<String> getIssuedBooks() { return issuedBooks; }

    public void issueBook(String bookId) {
        issuedBooks.add(bookId);
    }

    public void returnBook(String bookId) {
        issuedBooks.remove(bookId);
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + ", Issued Books: " + issuedBooks;
    }
}
