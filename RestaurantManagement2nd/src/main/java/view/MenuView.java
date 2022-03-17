package view;

import models.*;
import utils.MAINFUNCTION;
import utils.MENUITEMFUNCTION;
import utils.MENUITEMSTYPE;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {
    Scanner scanner = new Scanner(System.in);

    public MENUITEMFUNCTION showMainMenu(){
        boolean check;
        int choice = -1;
        MENUITEMFUNCTION chosen = null;
        do {
            int idx = 0;
            for (MENUITEMFUNCTION function : MENUITEMFUNCTION.values()) {
                System.out.printf("%d, %s\n",idx++, function);
            }
            System.out.println();
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
                chosen = MENUITEMFUNCTION.values()[choice];
            }catch (IndexOutOfBoundsException ex){
                ex.printStackTrace();
                check=true;
            }
            scanner.nextLine();
        }while (check);
        System.out.println();

        return chosen;

    }

    MenuItemList menuItemList = new MenuItemList();

    public MenuItem inputNewMenuItem(){
        boolean check;
        int choice = -1;
        MENUITEMSTYPE chosenType = null;
        do {
            int idx = 0;
            for (MENUITEMSTYPE function : MENUITEMSTYPE.values()) {
                System.out.printf("%d, %s\n",idx++, function);
            }
            System.out.println();
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
                chosenType = MENUITEMSTYPE.values()[choice];
            }catch (IndexOutOfBoundsException ex){
                ex.printStackTrace();
                check=true;
            }
            scanner.nextLine();
        }while (check);

        MenuItem menuItem = null;
        switch (chosenType){
            case LUNCH:
                menuItem = new Food(ItemType.FOOD.LUNCH);
                break;
            case BREAKFAST:
                menuItem = new Food(ItemType.FOOD.BREAKFAST);
                break;
            case DINNER:
                menuItem = new Food(ItemType.FOOD.DINNER);
                break;
            case SOFTDRINK:
                menuItem = new Drink(ItemType.DRINK.SOFTDRINK);
                break;
            case ALCOHOL:
                menuItem = new Drink(ItemType.DRINK.ALCOHOL);
                break;
        }
        System.out.print("Input item name: ");
        menuItem.setName(scanner.nextLine());
        System.out.println();
    }

    public void showFullMenu(){
        this.menuItemList.showFullMenu();
    }

    public void showFoodMenu(){
        this.menuItemList.showFoodMenu();
    }

    public void showDrinkMenu(){
        this.menuItemList.showDrinkMenu();
    }
}
