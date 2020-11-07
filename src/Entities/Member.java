package Entities;

import java.util.ArrayList;

public class Member {
    private String name;
    private double SSN;
    private double permission = 0;
    private String userName;
    private String password;
    ArrayList<BorrowingBook> borrowingBooks = new ArrayList<>();


    public Member(){}

    public double getSSN() {
        return SSN;
    }

    public void setSSN(double SSN) {
        this.SSN = SSN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public double getPermission() {
        return permission;
    }

    public void setPermission(double permission) {
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

    public ArrayList<BorrowingBook> getBorrowingBooks() {
        return borrowingBooks;
    }

    public void setBorrowingBooks(ArrayList<BorrowingBook> borrowingBooks) {
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
