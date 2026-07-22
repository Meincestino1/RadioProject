package libraryManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library  {

    private LibraryManager bookCollection = new LibraryManager();
    private List<Loan> loans = new ArrayList<>(); // Liste für ausgeliehene Bücher
    private List<User> users = new ArrayList<>();

    public List<Book> searchBooksWithTitle(String title) throws InvalidSearchQueryException {
        try {
            return bookCollection.searchBooksWithTitle(title);
        } catch (InvalidSearchQueryException e) {
            System.err.println("Error while searching for books with title: " + title);
            System.err.println("Reason: " + e.getMessage());
            throw e; // Ausnahme weiterwerfen
        }
    }

    public void addBook(Book book) {
        bookCollection.addBook(book);
    }

    public void addUser (User user) {
        users.add(user);
    }

    public void removeBook(Book book)  {
        try {
            bookCollection.removeBook(book);
        } catch (BookNotFoundException e) {
            System.err.println(e.getMessage());;
        }
    }

    public void removeUsers (User user) {
        users.remove(user);
    }


    public User findUserByName(String name) throws UserNotFoundException {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        throw new UserNotFoundException("Benutzer mit dem Namen " + name + " wurde nicht gefunden.");
    }


    public User findUsersById(String id) throws UserNotFoundException {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        throw new UserNotFoundException("Benutzer mit der ID " + id + " wurde nicht gefunden.");
    }

    public void displayBooks() {
        bookCollection.displayBooks();
    }

    // Methode zum Ausleihen eines Buches
    public void borrowBook(Book book, User borrower)  {
        if (!users.contains(borrower)) {
            System.out.println("Benutzer ist nicht registriert.");
            return;
        }
        for (Loan loan : loans) {
            if (loan.getBook().equals(book.getTitle()) && loan.getNameOfBorrower().equals(borrower)) {
                System.out.println("Benutzer hat dieses Buch bereits ausgeliehen.");
                return;
            }
        }
        List<Book> foundBooks = new ArrayList<>(); // Liste von gefundenen Büchern
        try {
            foundBooks = bookCollection.searchBooksWithTitle(book.getTitle());
        } catch (InvalidSearchQueryException e) {
            System.err.println(e.getMessage());
        }
        if (!foundBooks.isEmpty()) { // Wenn die Liste nicht leer ist, wurde das Buch gefunden
            Loan loan = new Loan(foundBooks.get(0).getTitle(), borrower); // Neues Loan-Objekt erstellen
            loans.add(loan); // Loan zur Liste der Ausleihen hinzufügen
            try {
                bookCollection.removeBook(foundBooks.get(0)); // Das gefundene Buch aus der Sammlung entfernen
            } catch (BookNotFoundException e) {
                System.err.println(e.getMessage());;
            }
            System.out.println("Buch erfolgreich ausgeliehen!");
            System.out.println("Details: " + loan);
        } else {
            System.out.println("Das Buch ist nicht verfügbar.");
        }
    }

    // Methode zum Anzeigen aller ausgeliehenen Bücher
    public void displayLoans() {
        for (Loan loan : loans) {
            System.out.println(loan);
        }
    }


    public void sortBooksByTitle() {
        List<Book> books = bookCollection.getBooks(); // Hier wird nur eine Referenz erstellt unc nicht mit new eine
        Collections.sort(books, new Comparator<Book>() { // neue Liste erstellt, deshalb werden die Änderungen
            @Override                                       // auch auf der Ursprungsliste wirksam
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareTo(b2.getTitle());
            }
        });
    }

    public void sortBooksByYear() {
        List<Book> books = bookCollection.getBooks();
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return Integer.compare(b1.getYear(), b2.getYear());
            }
        });
    }

}
