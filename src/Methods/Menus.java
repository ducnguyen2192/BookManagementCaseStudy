package Methods;

import java.util.Scanner;

public class Menus {
    Scanner input = new Scanner(System.in);
    public int openStudentMenu(){
        System.out.println("=========== Student Menu ============");
        System.out.println("1. Show all book");
        System.out.println("2. Search book by id");
        System.out.println("3. Search book by name");
        System.out.println("4. Search book by author");
        System.out.println("5. Borrow book");
        System.out.println("6. Return book");
        System.out.println("7. Show all borrowed books");
        System.out.println("0. Sign out");
        return Integer.parseInt(input.nextLine());
    }

    public int openAdminMenu(){
        System.out.println("=========== Admin Menu ============");
        System.out.println("1. Add new book");
        System.out.println("2. Show all books");
        System.out.println("3. Update book by Id");
        System.out.println("4. Show all members");
        System.out.println("5. Update member info");
        System.out.println("6. Import book and member from excel");
        System.out.println("7. Export book and member from excel");
        System.out.println("8. Borrow book");
        System.out.println("9. Return book");
        System.out.println("10. Hide book");
        System.out.println("11. Delete book from database");
        System.out.println("0. sign out");
        return Integer.parseInt(input.nextLine());
    }



}
