package view;

import utils.ITEMFUNCTION;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ItemView {

    Scanner scanner = new Scanner(System.in);

    public ITEMFUNCTION choseFunction(){
        boolean check;
        int choice = -1;
        ITEMFUNCTION chosenFunction = null;
        do {
            int idx = 0;
            for (ITEMFUNCTION function : ITEMFUNCTION.values()) {
                System.out.printf("%d, %s\n",idx++, function);
            }
            System.out.print("Input your choice: ");
            check = false;
            try {
                choice = scanner.nextInt();
            }catch (InputMismatchException ex){
                ex.printStackTrace();
                check = true;
                System.out.println("WRONG FORMAT\nPLS try again!!!");
            }
            try {
                chosenFunction = ITEMFUNCTION.values()[choice];
            }catch (ArrayIndexOutOfBoundsException ex){
                ex.printStackTrace();
                check = true;
                System.out.println("WRONG FORMAT\nPLS try again!!!");
            }
            scanner.nextLine();
        }while (check);
        return chosenFunction;
    }
}
