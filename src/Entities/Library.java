package Entities;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Library {
    ArrayList<Member> members;
    ArrayList<Book> books;
//    private static final Library libInstance = new Library();


    public Library(ArrayList<Member> members, ArrayList<Book> books){
        this.members = members;
        this.books = books;
    }

//    public Library getInstance(ArrayList<Member> members, ArrayList<Book> books){
//        this.members = members;
//        return libInstance;
//    }

    public ArrayList<Member> getMemberList() {
        return members;
    }

    public void setMemberList(ArrayList<Member> members) {
        this.members = members;
    }

    public ArrayList<Book> getBookList() {
        return books;
    }
}
