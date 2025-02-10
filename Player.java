import java.util.Random;

public class Player implements IAttackable, IPlayerActions {
    private String name;
    private int hp = 100;
    private int attackDamage = 15;
    private int exp = 0;
    private int level = 1;
    private int healthPotions = 1;
    private int coins = 50;
    private boolean shieldActive = false;
    private int shieldDurability = 0;
    private Random random = new Random();

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void attack(IAttackable target) {
        System.out.println(name + " атакует " + target.getName() + " на " + attackDamage + " урона!");
        target.takeDamage(attackDamage);
        System.out.println("⚔ После атаки у " + target.getName() + " осталось " + target.getHp() + " HP.");
    }

    @Override
    public void takeDamage(int damage) {
        if (shieldActive && shieldDurability > 0) {
            double chance = random.nextDouble();

            if (chance < 0.50) {
                System.out.println("🛡 " + name + " полностью отразил атаку врага!");
            } else {
                damage /= 2;
                System.out.println("🛡 " + name + " уменьшил урон до " + damage + " с помощью щита!");
                hp -= damage;
            }

            shieldDurability--;
            if (shieldDurability == 0) {
                shieldActive = false;
                System.out.println("❌ Щит сломался! Его больше нельзя использовать.");
            }
            return;
        }

        hp -= damage;
        System.out.println(name + " получил " + damage + " урона! Осталось HP: " + hp);
    }

    @Override
    public void activateShield() {
        if (!shieldActive) {
            shieldActive = true;
            shieldDurability = 3;
            System.out.println(name + " активировал щит! 🛡 Он выдержит 3 удара.");
        } else {
            System.out.println("❌ Щит уже активирован!");
        }
    }

    @Override
    public void useHealthPotion() {
        if (healthPotions > 0) {
            hp = Math.min(100, hp + 20);
            healthPotions--;
            System.out.println(name + " использовал зелье. Осталось HP: " + hp + ", Зелий: " + healthPotions);
        } else {
            System.out.println("❌ Нет зелий!");
        }
    }

    @Override
    public void buyHealthPotion() {
        if (coins >= 50) {
            coins -= 50;
            healthPotions++;
            System.out.println(name + " купил зелье! Осталось монет: " + coins);
        } else {
            System.out.println("❌ Недостаточно монет!");
        }
    }

    @Override
    public void gainExp(int amount) {
        exp += amount;
        if (exp >= level * 100) {
            level++;
            exp = 0;
            System.out.println("🎉 " + name + " достиг уровня " + level);
        }
    }

    @Override public int getHp() { return hp; }
    @Override public String getName() { return name; }
}
