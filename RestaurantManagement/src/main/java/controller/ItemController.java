package controller;

import models.MenuItem;
import view.ItemView;

import java.util.Scanner;

public class ItemController {
    public ItemView view;
    public MenuItem item;

    Scanner scanner = new Scanner(System.in);

    public ItemController(ItemView view, MenuItem menuItem){
        this.view = view;
        this.item = menuItem;
    }

    public void access(){
        switch (view.choseFunction()){
            case EDIT -> edit();
            case DISABLE -> disable();
            case ENABLE -> enable();
        }
    }

    private void edit(){
        System.out.println("EDITING (Enter blank = skip)");
        String tmp;
        System.out.print("Input name: ");
        tmp = scanner.nextLine();

        if (tmp!="")
            this.item.setName(tmp);
        System.out.print("Input description: ");
        tmp = scanner.nextLine();

        if (tmp!="")
            this.item.setDescripton(tmp);

        System.out.print("Input URL image: ");
        tmp = scanner.nextLine();
        if (tmp!="")
            this.item.setImage(tmp);

        System.out.print("Input price: ");
        tmp = scanner.nextLine();
        if (tmp!="")
            this.item.setPrice(Double.parseDouble(tmp));
        scanner.nextLine();
        System.out.println("Success");
    }

    private void disable(){
        if (!this.item.getActive())
            System.out.println("Item already disable!");
        else
            this.item.setActive(false);
    }

    private void enable(){
        if (this.item.getActive())
            System.out.println("Item already enable!");
        else
            this.item.setActive(true);
    }
}
