import controller.MainController;
import models.*;
import models.Enum;
import view.MainView;

public class app {
    public static void main(String[] args) {
        System.out.printf("%20s %s\n", "hossssssssas", "291873");
        System.out.printf("%-20s %s\n", "hossssssssa222s", "29187322");
        System.out.printf("%-20s %s\n", "hossssssssas222", "29187322");


        Alcohol d = new Alcohol("Voca", "nong do con cao", "https://img.com.vn",  3000000, 40);

        Food f = new Food("trung chien", "thom ngon bo duong", "https://img2.com.vn",  10000, Enum.foodType.BREAKFAST);

        Server.menuList.add(f);
        MainView view = new MainView();
        MainController mainController = new MainController(view);
        mainController.start();
    }
}
