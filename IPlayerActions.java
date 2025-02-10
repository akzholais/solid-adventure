public interface IPlayerActions {
    void attack(IAttackable target);
    void activateShield();
    void useHealthPotion();
    void buyHealthPotion();
    void gainExp(int amount);
}
