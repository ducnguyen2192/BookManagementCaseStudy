package Main;

import Entities.*;
import Methods.*;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        Menus menu = new Menus();
        LibraryManagement mm = new LibraryManagement();
        ArrayList<User> members = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();
        Library lib = new Library(members, books);
        SignIn signIn = new SignIn();

        ImportBookList importBook = new ImportBookList();
        importBook.importBook(lib);
        ImportMemberList importMemberList = new ImportMemberList();
        importMemberList.importMemberList(lib);

        signIn.SignInSignUp(lib, mm, menu);
    }
}
