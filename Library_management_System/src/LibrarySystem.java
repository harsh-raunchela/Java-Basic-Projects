import java.io.*;
import java.util.*;

public class LibrarySystem {
    private List<Book> books;
    private final String BOOK_FILE = "books_data.txt";

    public LibrarySystem() {
        this.books = new ArrayList<>();
        loadBooks();
    }
    //we will add addBook functionality
    public void addBook(int id, String title, String author) {
        books.add(new Book(id, title, author));
        saveBooks();
        System.out.println("Book added successfully!");
    }

    public void removeBook(int id) {
        books.removeIf(book -> book.getid() == id);
        saveBooks();
        System.out.println("Book removed successfully!");
    }

    public Book searchBook(int id) {
        for (Book book : books) {
            if(book.getid() == id) {
                return book;
            }
        }
        return null;
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void saveBooks() {
        try (ObjectOutputStream out  = new ObjectOutputStream(new FileOutputStream(BOOK_FILE))){
            out.writeObject(books);
        }catch (IOException e){
            System.out.println("Error while saving books"  + e.getMessage());
        }
    }
    public void loadBooks() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(BOOK_FILE))){
            books = (List<Book>) in.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println("No previous book data found, Starting fresh books");
        }
    }
}
