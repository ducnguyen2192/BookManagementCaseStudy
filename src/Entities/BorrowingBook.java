package Entities;

public class BorrowingBook {
    private String borrowingBookName;
    private int borrowingBookId;
    private int borrowingBookEdition;
    private String borrowingBookAuthor;
    private int borrowDate;
    private int returnDate;

    public BorrowingBook(){}

    public int getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(int borrowDate) {
        this.borrowDate = borrowDate;
    }

    public int getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(int returnDate) {
        this.returnDate = returnDate;
    }

    public String getBorrowingBookName() {
        return borrowingBookName;
    }

    public void setBorrowingBookName(String borrowingBookName) {
        this.borrowingBookName = borrowingBookName;
    }

    public int getBorrowingBookEdition() {
        return borrowingBookEdition;
    }

    public void setBorrowingBookEdition(int borrowingBookEdition) {
        this.borrowingBookEdition = borrowingBookEdition;
    }

    public String getBorrowingBookAuthor() {
        return borrowingBookAuthor;
    }

    public void setBorrowingBookAuthor(String borrowingBookAuthor) {
        this.borrowingBookAuthor = borrowingBookAuthor;
    }

    public int getBorrowingBookId() {
        return borrowingBookId;
    }

    public void setBorrowingBookId(int borrowingBookId) {
        this.borrowingBookId = borrowingBookId;
    }

    @Override
    public String toString() {
        return "BorrowingBook{" +
                "borrowingBookName='" + borrowingBookName + '\'' +
                ", borrowingBookId=" + borrowingBookId +
                ", borrowingBookEdition=" + borrowingBookEdition +
                ", borrowingBookAuthor='" + borrowingBookAuthor + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
