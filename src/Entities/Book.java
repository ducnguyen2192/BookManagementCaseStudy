package Entities;

public class Book {
    private String bookName;
    private int bookId;
    private int bookQuantity;
    private int bookEdition;
    private String bookAuthor;
    private boolean isShown = true;

    public Book(){

    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public int getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(int bookEdition) {
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

    public boolean isShown() {
        return isShown;
    }

    public void setIsShown(boolean shown) {
        isShown = shown;
    }

    public boolean getIsShow(){
        return isShown;
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
