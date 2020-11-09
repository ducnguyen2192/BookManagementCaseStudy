package Methods;

import Entities.Library;
import Entities.User;

import java.io.IOException;
import java.util.Scanner;

public class SignIn {
    Scanner input = new Scanner(System.in);

    public void SignInSignUp(Library lib, LibraryManagement mm, Menus menu) throws IOException {
        do{
            System.out.println("========== Sign In ==========");
            System.out.println("1. sign in");
            System.out.println("2. register");
            int choice = Integer.parseInt(input.nextLine());
            switch(choice) {
                case 1:
                    int memberMenuChoice;
                    User member = signIn(lib, mm);
                    do{
                        if(mm.isAdmin(lib, member.getUserName())){
                            System.out.println("");
                            memberMenuChoice = menu.openAdminMenu();
                            if(memberMenuChoice == 0){
                                SignInSignUp(lib, mm, menu);
                            } else {
                                mm.adminManagement(lib, memberMenuChoice, member);
                            }

                        } else{
                            System.out.println("");
                            memberMenuChoice = menu.openStudentMenu();
                            if(memberMenuChoice == 0) {
                                SignInSignUp(lib, mm, menu);
                            } else {
                                mm.studentManagement(lib, memberMenuChoice, member);
                            }
                        }
                    } while(true);
                case 2:
                    System.out.println("please sign up a new account");
                    lib.getMemberList().add(signUp(lib));
                    System.out.println("you have successfully signed up for a new account!");
                    break;
                default:
                    System.out.println("there are no such option");
                    break;
            }
        }while(true);
    }

    public User signIn(Library lib, LibraryManagement mm) {
        System.out.print("user name: ");
        String userName = input.nextLine();
        System.out.print("password: ");
        String password = input.nextLine();
        User m = new User();
        if(isInputValueMatched(lib, userName, password) == true) {
            m = mm.searchByUserName(lib, userName);
        } else{
            System.out.println("username or password is wrong");
            m = signIn(lib, mm);
        }
        return m;
    }


    public boolean isInputValueMatched(Library lib, String userName, String password) {
        for (User m : lib.getMemberList()) {
            if (userName.equals(m.getUserName()) && password.equals(m.getPassword())){
                return true;
            }
        }
        return false;
    }

    public User signUp(Library lib){
        System.out.print("input name:");
        String name = input.nextLine();
        System.out.print("input SSN:");
        int SSN = Integer.parseInt(input.nextLine());
        System.out.print("input userName: ");
        String userName = input.nextLine();
        System.out.print("input password: ");
        String password = input.nextLine();
        User m = new User();

        if(isExistingSSN(lib, SSN)){
            m.setName(name);
            m.setSSN(SSN);
            m.setUserName(userName);
            m.setPassword(password);
        } else {
            System.out.println("this ssn has already been used.");
            m = signUp(lib);
        }
        return m;
    }

    public boolean isExistingSSN(Library lib, int SSN){
        for (User m: lib.getMemberList()) {
            if(SSN == m.getSSN()){
                return false;
            }
        }
        return true;
    }
}
