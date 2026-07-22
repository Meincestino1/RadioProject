package libraryManagementSystem;

import java.time.LocalDate;

public class Loan {

    private String book;
    private User borrower;
    private LocalDate loanDate;


    public Loan(String book, User borrower) {
        this.book = book;
        this.borrower = borrower;
        this.loanDate = LocalDate.now();
    }

    public String getBook() {
        return book;
    }

    public User getNameOfBorrower() {
        return borrower;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    @Override
    public String toString() {
        return String.format("Loan{book=%s, borrower='%s', loanDate=%s}", book, borrower, loanDate);
    }
}
