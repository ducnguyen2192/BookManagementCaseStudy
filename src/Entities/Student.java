package Entities;

import java.util.ArrayList;

public class Student extends User {
    ArrayList<BorrowingBook> borrowingBooks = new ArrayList<>();
    public Student(){}

    public ArrayList<BorrowingBook> getBorrowingBooks() {
        return borrowingBooks;
    }

    public void setBorrowingBooks(ArrayList<BorrowingBook> borrowingBooks) {
        this.borrowingBooks = borrowingBooks;
    }
}
