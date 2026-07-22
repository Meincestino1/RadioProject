package libraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {

    private List<Book> books = new ArrayList<>(); // Komposition

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) throws BookNotFoundException {
        if (!books.contains(book)) {
            throw new BookNotFoundException("Book not found");
        }
        books.remove(book);
        System.out.println("Book removed");
    }

    public List<Book> searchBooksWithTitle(String bookName) throws InvalidSearchQueryException {
        if (bookName == null || bookName.trim().isEmpty()) {
            throw new InvalidSearchQueryException("Search query cannot be null or empty");
        }
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(bookName.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        if (foundBooks.isEmpty()) {
            System.out.println("Book not found");
        } else {
            System.out.println("Buch gefunden");
        }
        return foundBooks;
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
