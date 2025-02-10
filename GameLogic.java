import java.util.Scanner;

public class GameLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя игрока:");
        Player player = new Player(scanner.nextLine());

        Enemy[] enemies = { new Goblin(), new Dragon() };
        BattleManager battleManager = new BattleManager(scanner);
        Shop shop = new Shop(scanner);

        for (Enemy enemy : enemies) {
            shop.openShop(player);
            if (!battleManager.startBattle(player, enemy)) {
                System.out.println("Игра окончена.");
                return;
            }
        }
        System.out.println("🎉 Поздравляем! Вы победили!");
    }
}
