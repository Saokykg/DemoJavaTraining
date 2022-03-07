package view;

import java.util.Scanner;

public class MainView {
    Scanner scanner = new Scanner(System.in);

    public int getMainMenu(){
        System.out.println("__Main menu__");
        int chose;
        System.out.println("1. Server side");
        System.out.println("2. Client side");
        chose = scanner.nextInt();
        return chose;
    }
}
