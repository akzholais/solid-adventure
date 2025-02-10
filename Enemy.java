import java.util.Random;

public abstract class Enemy implements IAttackable {
    protected String name;
    protected int hp;
    protected int minAttackDamage;
    protected int maxAttackDamage;
    private Random random = new Random();

    public Enemy(String name, int hp, int minAttackDamage, int maxAttackDamage) {
        this.name = name;
        this.hp = hp;
        this.minAttackDamage = minAttackDamage;
        this.maxAttackDamage = maxAttackDamage;
    }

    public void attack(Player player) {
        int damage = random.nextInt(maxAttackDamage - minAttackDamage + 1) + minAttackDamage;
        System.out.println(name + " атакует " + player.getName() + " на " + damage + " урона!");
        player.takeDamage(damage);
        System.out.println("💥 После атаки у " + player.getName() + " осталось " + player.getHp() + " HP.");
    }

    @Override public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(name + " получил " + damage + " урона! Осталось HP: " + hp);
    }
    @Override public int getHp() { return hp; }
    @Override public String getName() { return name; }
}
