package view;

import utils.MENUITEMFUNCTION;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {
    Scanner scanner = new Scanner(System.in);

    public int showMainMenu(){
        boolean check;
        int choice = -1;
        do {
            int idx = 0;
            for (MENUITEMFUNCTION function : MENUITEMFUNCTION.values()) {
                System.out.printf("%d, %s\n",idx++, function);
            }
            System.out.print("Input your choice: ");
            check = false;
            try {
                choice = scanner.nextInt();
            }catch (InputMismatchException ex){
                ex.printStackTrace();
                check = true;
                System.out.println("SOMETHING WRONG\nPLS try again!!!");
            }
            scanner.nextLine();
        }while (check);
        System.out.println();

        return choice;

    }
}
