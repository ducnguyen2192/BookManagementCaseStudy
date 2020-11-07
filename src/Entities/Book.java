package Entities;

public class Book {
    private String bookName;
    private double bookId;
    private double bookQuantity;
    private double bookEdition;
    private String bookAuthor;

    public Book(){

    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getBookId() {
        return bookId;
    }

    public void setBookId(double bookId) {
        this.bookId = bookId;
    }

    public Double getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(double bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public double getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(double bookEdition) {
        this.bookEdition = bookEdition;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getNumberOfAttributes() {
        return 5;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookId=" + bookId +
                ", bookQuantity=" + bookQuantity +
                ", bookEdition=" + bookEdition +
                ", bookAuthor='" + bookAuthor + '\'' +
                '}';
    }
}
