HomeWork 1

# SOLID Adventure Game

## 🚀 Project Overview
This project represents a text-based adventure game refactored to follow SOLID principles for better maintainability and modularity.

---

## 🔹 Key Features
- **Player Management**: Manages player's health, experience, inventory, and shield mechanics.
- **Combat System**: Includes random damage for enemies and dynamic interactions with shields.
- **Enemy Types**: Supports multiple types of enemies (`Goblin`, `Dragon`) with unique attributes.
- **Item Handling**: Allows the player to purchase and use health potions.
- **Randomized Damage**: Enemies deal random damage within a specified range.

---

## 🔹 Applied SOLID Principles

### **1. Single Responsibility Principle (SRP)**
Each class is responsible for one specific task:
- `Player` handles player-related attributes and actions.
- `Enemy` serves as the base class for all enemy types.
- `BattleManager` coordinates combat logic.
- `Shop` manages item purchases.

---

### **2. Open/Closed Principle (OCP)**
The system is open for extension but closed for modification:
- New enemy types (`Zombie`, `Vampire`) can be added without altering the existing `Enemy` class.

---

### **3. Dependency Inversion Principle (DIP)**
High-level modules depend on abstractions:
- Interfaces like `IAttackable` and `IPlayerActions` decouple high-level logic from specific implementations.

---

### **4. Liskov Substitution Principle (LSP)**
Subclasses can replace their parent classes:
- `Goblin` and `Dragon` are interchangeable without modifying combat logic.

---

### **5. Interface Segregation Principle (ISP)**
Interfaces are split based on specific responsibilities:
- `IAttackable` for entities that can take damage.
- `IPlayerActions` for player-specific actions.

---

## 📂 Folder Structure




📂 src
├── BattleManager.java
├── Dragon.java
├── Enemy.java
├── GameLogic.java
├── Goblin.java
├── IAttackable.java
├── IPlayerActions.java
├── Main.java
├── Player.java
├── Shop.java
