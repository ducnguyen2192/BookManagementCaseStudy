package Entities;

import java.util.ArrayList;

public class Library {
    ArrayList<User> members;
    ArrayList<Book> books;
//    private static final Library libInstance = new Library();


    public Library(ArrayList<User> members, ArrayList<Book> books){
        this.members = members;
        this.books = books;
    }

//    public Library getInstance(ArrayList<Member> members, ArrayList<Book> books){
//        this.members = members;
//        return libInstance;
//    }

    public ArrayList<User> getMemberList() {
        return members;
    }

    public void setMemberList(ArrayList<User> members) {
        this.members = members;
    }

    public ArrayList<Book> getBookList() {
        return books;
    }
}
