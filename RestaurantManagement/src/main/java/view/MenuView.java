package view;

import models.*;
import utils.MENUFUNCTION;
import utils.MENUITEMSTYPE;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {

    Scanner scanner = new Scanner(System.in);

    private void showHeader(){
        System.out.printf("\n%-4s %-20s %-30s %-30s %-10s %-10s %-10s%n", "ID", "Name", "Description", "Image", "Price", "Type", "Active");
    }

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
                menuItem = new Food(ItemsType.foodType.LUNCH);
                break;
            case BREAKFAST:
                menuItem = new Food(ItemsType.foodType.BREAKFAST);
                break;
            case DINNER:
                menuItem = new Food(ItemsType.foodType.DINNER);
                break;
            case SOFTDRINK:
                menuItem = new Drink(ItemsType.drinkType.SOFTDRINK);
                break;
            case ALCOHOL:
                menuItem = new Drink(ItemsType.drinkType.ALCOHOL);
                break;
            default:
                System.out.println("WRONG INPUT!!!");
        }

        System.out.print("Input name: ");
        menuItem.setName(scanner.nextLine());

        System.out.print("Input description: ");
        menuItem.setDescripton(scanner.nextLine());

        System.out.print("Input URL image: ");
        menuItem.setImage(scanner.nextLine());

        System.out.print("Input price: ");
        menuItem.setPrice(scanner.nextDouble());
        scanner.nextLine();

        return menuItem;
    }

    public MENUFUNCTION choseFunction(){
        boolean check;
        int choice = -1;
        MENUFUNCTION chosenFunction = null;
        do {
            int idx = 0;
            for (MENUFUNCTION function : MENUFUNCTION.values()) {
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
                chosenFunction = MENUFUNCTION.values()[choice];
            }catch (ArrayIndexOutOfBoundsException ex){
                ex.printStackTrace();
                check = true;
                System.out.println("WRONG FORMAT\nPLS try again!!!");
            }
            scanner.nextLine();
        }while (check);
        return chosenFunction;
    }

    public MenuItem selectItem(){
        MenuItemList menuItemList = new MenuItemList();
        boolean check;
        int choice = -1;
        MenuItem selectedItem = null;
        do {
            showMenuList();
            System.out.print("Input item id: ");
            check = false;
            try {
                choice = scanner.nextInt();
            }catch (InputMismatchException ex){
                ex.printStackTrace();
                check = true;
                System.out.println("WRONG FORMAT\nPLS try again!!!");
            }
            try {
                selectedItem = menuItemList.get(choice);
            }catch (ArrayIndexOutOfBoundsException ex){
                ex.printStackTrace();
                check = true;
                System.out.println("WRONG FORMAT\nPLS try again!!!");
            }
            scanner.nextLine();
        }while (check);
        return  selectedItem;
    }

    public void showMenuList(){
        showHeader();
        for (MenuItem o : MenuItemList.menuList) {
            System.out.println(o);
        }
    }

    public void showFoodMenuList(){
        showHeader();
        for (MenuItem o : MenuItemList.menuList) {
            if (o instanceof Food)
                System.out.println(o);
        }
    }

    public void showDrinkMenuList(){
        showHeader();
        for (MenuItem o : MenuItemList.menuList) {
            if (o instanceof Drink)
                System.out.println(o);
        }
    }

    public Food addFood(){
        Food food = new Food();
        System.out.print("Input name: ");
        food.setName(scanner.nextLine());

        System.out.print("Input description: ");
        food.setDescripton(scanner.nextLine());

        System.out.print("Input url img: ");
        food.setImage(scanner.nextLine());

        System.out.print("Input price: ");
        food.setPrice(Double.parseDouble(scanner.nextLine()));

        System.out.println("Chose food type: ");
        System.out.print("1, BREAKFAST,\n2, LUNCH,\n3, DINNER\n");

        ItemsType.foodType type = switch (Integer.parseInt(scanner.nextLine())) {
            case 1 -> ItemsType.foodType.BREAKFAST;
            case 2 -> ItemsType.foodType.LUNCH;
            case 3 -> ItemsType.foodType.DINNER;
            default -> throw new AssertionError();
        };
        food.setType(type);

        return food;
    }

    public Drink addDrink(){
        System.out.println("1, Add soft drink \n2, Add alcohol drink\n");
        Drink drink = switch (Integer.parseInt(scanner.nextLine())) {
            case 1 -> new Drink(ItemsType.drinkType.SOFTDRINK);
            case 2 -> new Drink(ItemsType.drinkType.ALCOHOL);
            default -> throw new AssertionError();
        };

        System.out.print("Input name: ");
        drink.setName(scanner.nextLine());

        System.out.print("Input description: ");
        drink.setDescripton(scanner.nextLine());

        System.out.print("Input url img: ");
        drink.setImage(scanner.nextLine());

        System.out.print("Input price: ");
        drink.setPrice(Double.parseDouble(scanner.nextLine()));

        return drink;
    }

    public int deleteMenuItem(){
        System.out.print("Input id to delete(input 0 to cancel): ");
        return Integer.parseInt(scanner.nextLine());
    }

}
