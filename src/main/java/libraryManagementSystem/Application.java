package libraryManagementSystem;

import com.drew.metadata.adobe.AdobeJpegReader;

import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        // Erstelle ein paar Bücher
        Book robinHoodBook = new Book("Robin Hood", "Micky", 1980);
        Book captainCiaoCiaoBook = new Book("Captain Ciao Ciao", "Ullenboom", 2020);
        Book drachenbuch = new Book("Der kleine Drache", "Dragon", 2005);
        Book KönigDerLoewen = new Book("König der Löwen", "Lion", 2023);

        // Erstelle eine Bibliothek und füge Bücher hinzu
        Library myLibrary = new Library();
        myLibrary.addBook(robinHoodBook);
        myLibrary.addBook(captainCiaoCiaoBook);
        myLibrary.addBook(drachenbuch);
        myLibrary.addBook(KönigDerLoewen);
        Address mickysAdress = new Address("Via del pastore", "Merano", "80336", "Bella Italia");
        User micky = new User("Michael G.", mickysAdress, "lala@lele.mumu");

        // Bücher suchen und anzeigen
        try {
            myLibrary.searchBooksWithTitle("Robin Hood");
        } catch (InvalidSearchQueryException e) {
            System.err.println("Fehler bei der Suche: " + e.getMessage());
        }
        System.out.println("Vor dem Namen sortieren");
        myLibrary.displayBooks();
        myLibrary.sortBooksByTitle();
        System.out.println("Nach dem Namen sortieren");
        myLibrary.displayBooks();
        System.out.println("Nach dem Jahr sortieren");
        myLibrary.sortBooksByYear();
        myLibrary.displayBooks();
        myLibrary.borrowBook(drachenbuch, micky);
        myLibrary.borrowBook(captainCiaoCiaoBook, micky);
        myLibrary.displayBooks();
    }

}
