package view;

import utils.MAINFUNCTION;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {
    Scanner scanner = new Scanner(System.in);

    public MAINFUNCTION choseFunction(){
        boolean check;
        int choice = -1;
        MAINFUNCTION chosenFunction = null;
        do {
            int idx = 0;
            for (MAINFUNCTION function : MAINFUNCTION.values()) {
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
            try {
                chosenFunction = MAINFUNCTION.values()[choice];
            }catch (ArrayIndexOutOfBoundsException ex){
                ex.printStackTrace();
                check = true;
                System.out.println("SOMETHING WRONG\nPLS try again!!!");
            }
            scanner.nextLine();
        }while (check);
        return chosenFunction;
    }
}
