import java.util.List;
import java.util.Scanner;

public class GameCharacter {
    protected static final Scanner scan = new Scanner(System.in);
    private final String name;
    private final int maxHealthPoint;
    private int healthPoint;
    private int strength;
    private int skill;

    public GameCharacter() { this("No name yet", 100, 10); }
    public GameCharacter(String name) { this(name, 100, 10); }
    public GameCharacter(String name, int hp, int strength) {
        this.name = name;
        this.maxHealthPoint = Math.max(1, hp);
        this.healthPoint = this.maxHealthPoint;
        this.strength = Math.max(0, strength);
    }

    public void printStatus() {
        System.out.println("Name: " + name);
        System.out.println("Health point: " + healthPoint + "/" + maxHealthPoint);
        System.out.println("Strength: " + strength);
    }

    public void selectSkill() { }
    public void selectSkill(List<GameCharacter> party) { }
    public void usedSkill(GameCharacter target) { }
    public void usedSkill(List<GameCharacter> party) { }
    public void usedSkill(List<GameCharacter> party, GameCharacter target) { usedSkill(target); }

    protected int chooseSkill() {
        while (true) {
            System.out.print("Select skill (1-2): ");
            if (scan.hasNextInt()) {
                int choice = scan.nextInt();
                if (choice == 1 || choice == 2) 
                	return choice;
            } else {
                scan.next();
            }
            System.out.println("Please enter 1 or 2.");
        }
    }

    public void attack(GameCharacter target) { 
    	dealDamage(target, strength, "attack");
    }

    protected void dealDamage(GameCharacter target, int amount, String action) {
        if (!isAlive() || target == null || !target.isAlive()) return;
        int damage = Math.max(0, amount);
        
        target.setHealthPoint(target.getHealthPoint() - damage);
        System.out.println(name + " " + action + " " + target.getName() + " (damage: " + damage + ")");
        System.out.println(target.getName() + " HP: " + target.getHealthPoint());
        if (!target.isAlive()) 
        	System.out.println(target.getName() + " Dead!");
        System.out.println();
    }

    public String getName() { return name; }
    
    public int getHealthPoint() { return healthPoint; }
    public int getMaxHealthPoint() { return maxHealthPoint; }
    public void setHealthPoint(int hp) { healthPoint = Math.max(0, Math.min(maxHealthPoint, hp)); }
    
    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = Math.max(0, strength); }
    
    public int getSkill() { return skill; }
    public void setSkill(int skill) { this.skill = skill; }
    
    public boolean isAlive() { return healthPoint > 0; }
    public int getAlive() { return isAlive() ? 1 : 0; }
    public void setAlive(int alive) { if (alive == 0) setHealthPoint(0); }
}

