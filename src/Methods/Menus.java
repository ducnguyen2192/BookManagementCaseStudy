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
        System.out.println("7. Check all borrowed books");
        return Integer.parseInt(input.nextLine());
    }

    public int openAdminMenu(){
        System.out.println("=========== Student Menu ============");
        System.out.println("1. Add new book");
        System.out.println("2. Update book by Id");
        System.out.println("3. Show all books");
        System.out.println("4. Show all borrowing books");
        System.out.println("5. Add new card");
        System.out.println("6. Update student info");
        System.out.println("7. Import book and member from excel");
        System.out.println("8. Export book and member from excel");
        System.out.println("9. Show all members");
        System.out.println("0. sign out");
        return Integer.parseInt(input.nextLine());
    }


}
