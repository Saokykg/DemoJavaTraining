package view;

import models.*;
import models.Enum;

import java.lang.reflect.Type;
import java.util.Scanner;

public class ServerView {

    Scanner scanner = new Scanner(System.in);

    private void showHeader(){
        System.out.println(String.format("\n%-5s %-20s %-50s %-20s %-10s %-10s", "ID", "Name", "Description", "Image", "Price", "Type"));
    }

    public int choseFunction(){
        System.out.println("1. list all menu");
        System.out.println("2. list food menu");
        System.out.println("3. list drink menu");
        System.out.println("4. add food");
        System.out.println("5. add drink");
        System.out.println("6. Delete food");
        System.out.println("7. Delete drink");
        System.out.println("0. Exit");
        return Integer.parseInt(scanner.nextLine());
    }

    public void showMenuList(){
        showHeader();
        for (Menu o : Server.menuList) {
            System.out.println(o);
        }
    }

    public void showFoodMenuList(){
        showHeader();
        for (Menu o : Server.menuList) {
            if (o instanceof Food)
                System.out.println(o);
        }
    }

    public void showDrinkMenuList(){
        showHeader();
        for (Menu o : Server.menuList) {
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
        System.out.printf("1, BREAKFAST,\n2, LUNCH,\n3, DINNER\n");

        Enum.foodType type = null;
        switch (Integer.parseInt(scanner.nextLine())){
            case 1:
                type = Enum.foodType.BREAKFAST;
                break;
            case 2:
                type = Enum.foodType.LUNCH;
                break;
            case 3:
                type = Enum.foodType.DINNER;
                break;
            default:
                throw new AssertionError();
        }
        food.setType(type);

        return food;
    }

    public Drink addDrink(){
        System.out.println("1, Add soft drink \n2, Add alcohol drink\n");
        Drink drink;
        switch (Integer.parseInt(scanner.nextLine())){
            case 1:
                drink = new SoftDrink();
                break;
            case 2:
                drink = new Alcohol();
                break;
            default:
                throw new AssertionError();
        }

        System.out.print("Input name: ");
        drink.setName(scanner.nextLine());

        System.out.print("Input description: ");
        drink.setDescripton(scanner.nextLine());

        System.out.print("Input url img: ");
        drink.setImage(scanner.nextLine());

        System.out.print("Input price: ");
        drink.setPrice(Double.parseDouble(scanner.nextLine()));

        if (drink instanceof Alcohol){
            System.out.print("Input concentration: ");
            ((Alcohol) drink).setConcentration(Double.parseDouble(scanner.nextLine()));
        }

        return drink;
    }

    public int deleteMenuItem(){
        System.out.print("Input id to delete: ");
        return Integer.parseInt(scanner.nextLine());
    }

}
