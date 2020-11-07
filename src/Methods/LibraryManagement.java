package Methods;

import Entities.Book;
import Entities.BorrowingBook;
import Entities.Library;
import Entities.Member;
import javafx.scene.LightBase;

import java.util.Scanner;

public class LibraryManagement {
    Scanner input = new Scanner(System.in);
    public Member searchByUserName(Library lib, String userName){
        for (Member m : lib.getMemberList()) {
            if (userName.equals(m.getUserName())){
                return m;
            } else {
                System.out.println("there are no such member in our library");
            }
        }
        return null;
    }

    public boolean isAdmin(Library lib, String userName){
        if(searchByUserName(lib, userName).getPermission() != 1){
            return false;
        }
        return true;
    }

    public void adminManagement(Library lib, int memberMenuChoice){
        switch(memberMenuChoice) {
            case 1:
                addBook(lib);
                break;
            case 3:
                for (Book b: lib.getBookList()) {
                    System.out.println(b.toString());
                }
                break;
            case 8:
                ExportBook exportBook = new ExportBook();
                exportBook.exportToExcel(lib);
                ExportMemberList exportMemberList = new ExportMemberList();
                exportMemberList.exportToMemberList(lib);
                break;
            case 9:
                for (Member member: lib.getMemberList()) {
                    System.out.println(member);
                }
                break;
            case 0:
                break;
        }

    }
    public void studentManagement(Library lib, int choice){
        switch(choice){
            case 1:
                for (Book b: lib.getBookList()) {
                    System.out.println(b.toString());
                }
                break;
            case 2:
                System.out.println(searchBookById(lib).toString());
                break;
            case 3:
                System.out.println(searchBookByName(lib).toString());
                break;
            case 4:

        }
    }

    public void addBook(Library lib){
        Book b = new Book();
        System.out.print("input book name: ");
        String bookName = input.nextLine();
        System.out.print("input book Id: ");
        double bookId = Double.parseDouble(input.nextLine());
        System.out.print("input book edition: ");
        double bookEdition = Double.parseDouble(input.nextLine());
        System.out.print("input book author: ");
        String bookAuthor = input.nextLine();
        System.out.print("input book quantity: ");
        double bookQuantity = Double.parseDouble(input.nextLine());

        if(checkExistingBook(bookName, bookEdition, bookAuthor, bookId, lib) == null){
            b.setBookName(bookName);
            b.setBookId(bookId);
            b.setBookQuantity(bookQuantity);
            b.setBookEdition(bookEdition);
            b.setBookAuthor(bookAuthor);
            lib.getBookList().add(b);
        } else {
            System.out.println("this book is already in our collection");
            System.out.println("Do you want to add more copies to this book (yes/no): ");
            String addMoreCopies = input.nextLine();
            if(addMoreCopies.equals("yes")){
                checkExistingBook(bookName, bookEdition, bookAuthor, bookId, lib).setBookQuantity(checkExistingBook(bookName, bookEdition, bookAuthor,bookId, lib).getBookQuantity()+bookQuantity);
            } else {
                addBook(lib);
            }
        }
    }

    public Book checkExistingBook(String bookName, double bookEdition, String bookAuthor, double bookId, Library lib){
        for (Book b: lib.getBookList()) {
            if(bookName.equals(b.getBookName()) && bookEdition == b.getBookEdition() && bookAuthor.equals(b.getBookAuthor())){
                return b;
            }
        }
        return null;
    }

    public Book searchBookById(Library lib){
        System.out.println("input book id: ");
        double bookId = Double.parseDouble(input.nextLine());
        for (Book b: lib.getBookList()) {
            if(bookId == b.getBookId()){
                return b;
            } else {
                System.out.println("there are no book with that id in our library");
            }
        }
        return null;
    }
    
    public Book searchBookByName(Library lib){
        String bookName = input.nextLine();
        for (Book b: lib.getBookList()) {
            if(bookName.equals(b.getBookName())){
                return b;
            } else{
                System.out.println("there are no book with that name in our library");
            }
        }
        return null;
    }

    public void searchBookByAuthor(Library lib){
        String bookAuthor = input.nextLine();
        for (Book b: lib.getBookList()) {
            if(bookAuthor.equals(b.getBookAuthor())){
                System.out.println(b);
            } else{
                System.out.println("there are no book by that author in our library");
            }
        }
    }

    public BorrowingBook borrowBook(Library lib){
        BorrowingBook bb = (BorrowingBook) searchBookById(lib);
        System.out.println("input borrow date: ");
        double borrowDate = Double.parseDouble(input.nextLine());
        bb.setBorrowDate(borrowDate);
        double returnDate = borrowDate + 14;
        bb.setReturnDate(returnDate);
        return bb;
    }

    public Member searchMemberByUserName(Library lib){

    }


}
