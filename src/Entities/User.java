package Entities;

import java.util.ArrayList;

public class User {
    private String name;
    private int SSN;
    private int permission = 0;
    private String userName;
    private String password;
    ArrayList<BorrowingBook> borrowingBooks = new ArrayList<>();


    public User(){}

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getNumberOfAttributes(){
        return 5;
    }

    public ArrayList<BorrowingBook> getBorrowingBookList() {
        return borrowingBooks;
    }

    public void setBorrowingBookList(ArrayList<BorrowingBook> borrowingBooks) {
        this.borrowingBooks = borrowingBooks;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", SSN=" + SSN +
                ", permission=" + permission +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
