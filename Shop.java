import java.util.Scanner;

public class Shop {
    private Scanner scanner;

    public Shop(Scanner scanner) {
        this.scanner = scanner;
    }

    public void openShop(IPlayerActions player) {
        System.out.println("\n=== Магазин ===\n1 - Купить зелье за 50 монет\n2 - Выйти");
        while (true) {
            int choice = scanner.nextInt();
            if (choice == 1) player.buyHealthPotion();
            else if (choice == 2) break;
            else System.out.println("Неверный выбор.");
        }
    }
}
