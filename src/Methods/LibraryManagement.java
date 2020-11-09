package Methods;

import Entities.Book;
import Entities.BorrowingBook;
import Entities.Library;
import Entities.User;

import java.io.IOException;
import java.util.Scanner;

public class LibraryManagement {
    Scanner input = new Scanner(System.in);
    public User searchByUserName(Library lib, String userName){
        for (User m : lib.getMemberList()) {
            if (userName.equals(m.getUserName())){
                return m;
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

    public void adminManagement(Library lib, int memberMenuChoice, User member) throws IOException {
        switch(memberMenuChoice) {
            case 1:
                addBook(lib);
                System.out.println();
                break;
            case 2:
                for (Book b: lib.getBookList()) {
                    System.out.println(b.toString());
                }
                break;
            case 3:
                System.out.print("input book id: ");
                int bookId = Integer.parseInt(input.nextLine());
                updateBookById(lib, bookId);
                break;
            case 4:
                showAllMember(lib);
                break;
            case 5:
                System.out.print("input member user name: ");
                String userName = input.nextLine();
                if(userName.equals("admin")){
                    System.out.print("cannot change info of this person");
                    break;
                } else {
                    updateMemberInfo(lib,userName);
                }
                break;
            case 6:
                ImportBookList importBook = new ImportBookList();
                importBook.importBook(lib);
                ImportMemberList importMemberList = new ImportMemberList();
                importMemberList.importMemberList(lib);
                break;

            case 7:
                ExportBookList exportBook = new ExportBookList();
                exportBook.exportToExcel(lib);
                ExportMemberList exportMemberList = new ExportMemberList();
                exportMemberList.exportToMemberList(lib);
                break;
            case 8:
                showAllBorrowingBook(member);
                BorrowingBook bb = borrowBook(lib, member);
                member.getBorrowingBookList().add(bb);
                break;
            case 9:
                returnBook(lib, member);
                break;
            case 10:
                hideBook(lib);
                break;
            case 11:
                deleteBook(lib);
                break;
            case 0:
                break;
        }

    }

    public void studentManagement(Library lib, int choice, User member) throws IOException {
        switch(choice){
            case 1:
                for (Book b: lib.getBookList()) {
                    if(b.getBookQuantity() == 0 || b.getIsShow() == false){
                        continue;
                    } else {
                        System.out.println(b.toString());
                    }
                }
                break;
            case 2:
                System.out.print("input book Id: ");
                int bookId = Integer.parseInt(input.nextLine());
                System.out.println(searchBookById(lib, bookId).toString());
                break;
            case 3:
                searchBookByName(lib, choice, member);
                break;
            case 4:
                searchBookByAuthor(lib,choice, member);
                break;
            case 5:
                showAllBorrowingBook(member);
                BorrowingBook bb = borrowBook(lib, member);
                if (bb == null) {

                } else {
                    member.getBorrowingBookList().add(bb);
                }
                break;
            case 6:
                returnBook(lib, member);
                break;
            case 7:
                showAllBorrowingBook(member);
            case 0:
                break;
        }
    }

    public void addBook(Library lib){
        Book b = new Book();
        System.out.print("input book name: ");
        String bookName = input.nextLine();
        int bookId = createNewBookId(lib) + 1;
        System.out.print("input book edition: ");
        int bookEdition = Integer.parseInt(input.nextLine());
        System.out.print("input book author: ");
        String bookAuthor = input.nextLine();
        System.out.print("input book quantity: ");
        int bookQuantity = Integer.parseInt(input.nextLine());

        if(checkExistingBook(bookName, bookEdition, bookAuthor, bookId, lib) == null){
            b.setBookName(bookName);
            b.setBookId(bookId);
            b.setBookQuantity(bookQuantity);
            b.setBookEdition(bookEdition);
            b.setBookAuthor(bookAuthor);
            lib.getBookList().add(b);
            System.out.println("you have successfully created this book!");
            System.out.println(b.toString());
        } else {
            System.out.print("this book is already in our collection");
            System.out.print("Do you want to add more copies to this book (yes/no): ");
            String addMoreCopies = input.nextLine();
            if(addMoreCopies.equals("yes")){
                checkExistingBook(bookName, bookEdition, bookAuthor, bookId, lib).setBookQuantity(checkExistingBook(bookName, bookEdition, bookAuthor,bookId, lib).getBookQuantity()+bookQuantity);
            } else {
                addBook(lib);
            }
        }
    }



    public int createNewBookId(Library lib){
        int maxBookId = 0;
        for (int i = 0; i < lib.getBookList().size(); i++) {
            if(maxBookId < lib.getBookList().get(i).getBookId()){
                maxBookId = lib.getBookList().get(i).getBookId();
            }
        }
        return maxBookId;
    }

    public Book checkExistingBook(String bookName, int bookEdition, String bookAuthor, int bookId, Library lib){
        for (Book b: lib.getBookList()) {
            if(bookName.equals(b.getBookName()) && bookEdition == b.getBookEdition() && bookAuthor.equals(b.getBookAuthor())){
                return b;
            }
        }
        return null;
    }

    public Book searchBookById(Library lib, int bookId){
        try {
            for (Book b: lib.getBookList()) {
                if(bookId == b.getBookId()){
                    return b;
                }
            }
        } catch (NullPointerException e){
            System.out.print("there are no book with that id at our library");
        }
        return null;
    }

    public void searchBookByName(Library lib, int choice, User member) throws IOException {
            System.out.print("input book name: ");
            String bookName = input.nextLine();
            for (Book b: lib.getBookList()) {
                if(bookName.equals(b.getBookName())){
                    System.out.println(b.toString());
                } else {
                    studentManagement(lib, choice, member);
                }
            }

    }

    public void searchBookByAuthor(Library lib, int choice, User member) throws IOException {
            System.out.print("input author name: ");
            String authorName = input.nextLine();
            for (Book b: lib.getBookList()) {
                if(authorName.equals(b.getBookAuthor())){
                    System.out.println(b.toString());
                } else {
                    studentManagement(lib, choice, member);
                }
            }
    }

    public BorrowingBook searchBorrowingBookById(User member, int borrowingBookId){
        for (BorrowingBook bb: member.getBorrowingBookList()) {
            if(bb.getBorrowingBookId() == borrowingBookId){
                return bb;
            }
        }
        return null;
    }

    public BorrowingBook borrowBook(Library lib, User member){
        System.out.print("input book Id: ");
        int bookId = Integer.parseInt(input.nextLine());

        for (BorrowingBook bb1: member.getBorrowingBookList()) {
            if(bb1.getBorrowingBookId() == bookId){
                System.out.print("you can rent only 1 copy of each book");
                return null;
            }
        }

        Book b = searchBookById(lib,bookId);
        BorrowingBook bb = new BorrowingBook();
        if(b.getBookQuantity() == 0){
            System.out.print("there are no more copies of this book. please rent another one");
            return null;
        } else {
            System.out.print("input borrow date: ");
            int borrowDate = Integer.parseInt(input.nextLine());
            bb.setBorrowingBookName(b.getBookName());
            bb.setBorrowingBookAuthor(b.getBookAuthor());
            bb.setBorrowingBookEdition(b.getBookEdition());
            bb.setBorrowingBookId(b.getBookId());
            bb.setBorrowDate(borrowDate);
            int returnDate = borrowDate + 14;
            bb.setReturnDate(returnDate);
            bookDecreaseByOne(lib, bookId);
            System.out.print(bb.toString());
        }
        return bb;
    }

    public String returnBook(Library lib, User member){
        if(member.getBorrowingBookList().isEmpty()){
            System.out.println("you haven't borrowed any book");
            return null;
        }
        showAllBorrowingBook(member);
        System.out.print("input borrowing book id: ");
        int borrowingBookId = Integer.parseInt(input.nextLine());
        bookIncreaseByOne(lib, borrowingBookId);
        member.getBorrowingBookList().remove(searchBorrowingBookById(member, borrowingBookId));
        return null;
    }

    public void bookDecreaseByOne(Library lib, int bookId){
        Book b = searchBookById(lib, bookId);
        b.setBookQuantity(b.getBookQuantity()-1);
    }

    public void bookIncreaseByOne(Library lib, int bookId){
        Book b = searchBookById(lib, bookId);
        b.setBookQuantity(b.getBookQuantity()+1);
    }

    public void showAllBorrowingBook(User member){
        for (BorrowingBook bb: member.getBorrowingBookList()) {
            System.out.println(bb.toString());
        }
    }

    public void updateBookById(Library lib, int bookId){
        if(searchBookById(lib, bookId) == null){
            System.out.print("there are no book with such id");
        } else {
            System.out.println("please choose which attribute do you want to update?");
            System.out.println("1. Book name");
            System.out.println("2. Book quantity");
            System.out.println("3. Book edition");
            System.out.println("4. Book author");

            int choice = Integer.parseInt(input.nextLine());

            switch(choice) {
                case 1:
                    System.out.print("please input new book name: ");
                    String newBookName = input.nextLine();
                    searchBookById(lib, bookId).setBookName(newBookName);
                    break;
                case 2:
                    System.out.print("please input new book quantity: ");
                    int newBookQuantity = Integer.parseInt(input.nextLine());
                    searchBookById(lib, bookId).setBookQuantity(newBookQuantity);
                    break;
                case 3:
                    System.out.print("please input new book edition: ");
                    int newBookEdition = Integer.parseInt(input.nextLine());
                    searchBookById(lib, bookId).setBookEdition(newBookEdition);
                    break;
                case 4:
                    System.out.print("please input new book author name: ");
                    String newAuthorName = input.nextLine();
                    searchBookById(lib, bookId).setBookAuthor(newAuthorName);
                    break;
                default:
                    System.out.print("there are no such option");
                    break;
            }
        }
    }

    public void showAllMember(Library lib){
        for (User m : lib.getMemberList()) {
            System.out.println(m.toString());
        }
    }

    public String updateMemberInfo(Library lib, String userName){
        User member = new User();
        member = searchByUserName(lib, userName);
        System.out.println("which attribute do you want to update?");
        System.out.println("1. Member name");
        System.out.println("2. Member SSN");
        System.out.println("3. Member user name");
        System.out.println("4. Member password");
        System.out.println("5. Member permission");
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                System.out.print("input new member name: ");;
                String newName = input.nextLine();
                member.setName(newName);
                break;
            case 2:
                System.out.print("input new member SSN: ");
                int newSSN = Integer.parseInt(input.nextLine());
                member.setSSN(newSSN);
                break;
            case 3:
                System.out.print("input new user name: ");
                String newUserName = input.nextLine();
                member.setUserName(newUserName);
                break;
            case 4:
                System.out.print("input new password");
                String newPassword = input.nextLine();
                member.setPassword(newPassword);
                break;
            case 5:
                System.out.print("do you want to change this person permission (1 = admin, 2 = student)? yes/no");
                String choice1 = input.nextLine();
                switch (choice1) {
                    case "yes":
                        User b = searchByUserName(lib, userName);
                        if(b.getPermission() == 1){
                            b.setPermission(0);
                        } else {
                            b.setPermission(1);
                        }
                        break;
                    case "no":
                        break;
                }
                break;
        }
        return "" + member.toString();
    }

    public void hideBook(Library lib){
        System.out.println("input book id to hide from user: ");
        int bookId = Integer.parseInt(input.nextLine());
        for (Book b: lib.getBookList()) {
            if(b.getBookId() == bookId){
                b.setIsShown(false);
            }
        }
    }

    public void deleteBook(Library lib){
        System.out.println("input book id to delete: ");
        int bookId = Integer.parseInt(input.nextLine());
        Book b1 = new Book();
        for (Book b: lib.getBookList()) {
            if(b.getBookId() == bookId){
                b1 = b;
            }
        }
        lib.getBookList().remove(b1);
    }

}
