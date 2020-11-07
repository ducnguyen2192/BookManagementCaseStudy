package Entities;

public class BorrowingBook extends Book {
    private double borrowDate;
    private double returnDate;

    public BorrowingBook(){}

    public double getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(double borrowDate) {
        this.borrowDate = borrowDate;
    }

    public double getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(double returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BorrowingBook{" +
                "borrowedDate='" + borrowDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
