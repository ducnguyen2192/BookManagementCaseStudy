package Main;

import Entities.*;
import Methods.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Menus menu = new Menus();
        LibraryManagement mm = new LibraryManagement();
        ArrayList<Member> members = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();
        Library lib = new Library(members, books);
        SignInSignUp signInSignUp = new SignInSignUp();

        ImportBook importBook = new ImportBook();
        importBook.importBook(lib);
        ImportMemberList importMemberList = new ImportMemberList();
        importMemberList.importMemberList(lib);

        do{
            System.out.println("========== Menu ==========");
            System.out.println("1. sign in");
            System.out.println("2. sign up");
            int choice = Integer.parseInt(input.nextLine());
            switch(choice) {
                case 1:
                    int memberMenuChoice;
                    Member m = signInSignUp.signInUsername(lib, mm);
                    do{
                        if(mm.isAdmin(lib, m.getUserName())){
                            memberMenuChoice = menu.openAdminMenu();
                            if(memberMenuChoice == 0){
                                main(null);
                            } else {
                                mm.adminManagement(lib, memberMenuChoice);
                            }

                        } else{
                            memberMenuChoice = menu.openStudentMenu();
                            if(memberMenuChoice == 0) {
                                main(null);
                            } else {
                                mm.studentManagement(lib, memberMenuChoice);
                            }
                        }
                    } while(true);
                case 2:
                    System.out.println("please sign up a new account");
                    lib.getMemberList().add(signInSignUp.signUp(lib));
                    break;
            }
        }while(true);
    }
}
