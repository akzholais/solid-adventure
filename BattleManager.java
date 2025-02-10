import java.util.Scanner;

public class BattleManager {
    private Scanner scanner;

    public BattleManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean startBattle(Player player, Enemy enemy) {
        System.out.println("\n=== Битва с " + enemy.getName() + " (HP: " + enemy.getHp() + ") ===");

        while (player.getHp() > 0 && enemy.getHp() > 0) {
            System.out.println("\n📌 Твои действия:\n1 - Атаковать\n2 - Использовать зелье\n3 - Активировать щит\n4 - Уклониться");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> player.attack(enemy);
                case 2 -> player.useHealthPotion();
                case 3 -> player.activateShield();
                case 4 -> { if (Math.random() < 0.5) { System.out.println("Вы уклонились!"); continue; } }
                default -> System.out.println("Неверный выбор.");
            }

            if (enemy.getHp() > 0) enemy.attack(player);
        }

        if (player.getHp() > 0) {
            System.out.println("🎉 Ты победил " + enemy.getName() + "!");
            player.gainExp(50);
            return true;
        }
        return false;
    }
}
