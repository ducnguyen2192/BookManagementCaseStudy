package Methods;

import Entities.Library;
import Entities.Member;

import java.util.Scanner;

public class SignInSignUp {
    Scanner input = new Scanner(System.in);

    public Member signInUsername(Library lib, LibraryManagement mm) {
        String userName;
        String password;
        System.out.print("user name: ");
        userName = input.nextLine();
        System.out.print("password: ");
        password = input.nextLine();
        if(isInputValueMatched(lib, userName, password) == true) {
            return mm.searchByUserName(lib, userName);
        }
        return null;
    }


    public boolean isInputValueMatched(Library lib, String userName, String password) {
        for (Member m : lib.getMemberList()) {
            if (userName.equals(m.getUserName()) && password.equals(m.getPassword())){
                return true;
            }
        }
        return false;
    }

    public Member signUp(Library lib){
        System.out.println("input name:");
        String name = input.nextLine();
        System.out.println("input SSN:");
        int SSN = Integer.parseInt(input.nextLine());
        System.out.println("input userName");
        String userName = input.nextLine();
        System.out.println("input password");
        String password = input.nextLine();
        if(isExistingSSN(lib, SSN)){
            Member member = new Member();
            member.setName(name);
            member.setSSN(SSN);
            member.setUserName(userName);
            member.setPassword(password);
            return member;
        } else {
            System.out.println("you've already had an account with us. please sign in again");
            signUp(lib);
        }
        return null;
    }



    public boolean isExistingSSN(Library lib, int SSN){
        for (Member m: lib.getMemberList()) {
            if(SSN == m.getSSN()){
                return false;
            }
        }
        return true;
    }
}
