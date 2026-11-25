import java.util.List;

public class Healer extends GameCharacter {
    private final int healpoint;

    public Healer(String name, int hp, int strength, int healpoint) {
        super(name, hp, strength);
        this.healpoint = Math.max(0, healpoint);
    }

    @Override
    public void printStatus() {
        super.printStatus();
        System.out.println("Healpoint: " + healpoint);
    }

    @Override
    public void selectSkill() {
        System.out.println(getName() + " select skill");
        System.out.println("(1) attack: " + getStrength() + " damage");
        System.out.println("(2) healing: lowest HP party member +" + healpoint + " HP");
        setSkill(chooseSkill());
    }

    @Override
    public void usedSkill(List<GameCharacter> party, GameCharacter target) {
        if (!isAlive()) return;
        switch (getSkill()) {
            case 1:
                if (target.isAlive()) attack(target);
                break;
            case 2:
                GameCharacter healTarget = null;
                for (GameCharacter member : party) {
                    if (member.isAlive() && (healTarget == null || member.getHealthPoint() < healTarget.getHealthPoint())) {
                        healTarget = member;
                    }
                }
                if (healTarget != null) healing(healTarget);
                break;
            default: break;
        }
    }

    public void healing(GameCharacter target) {
        if (!isAlive() || !target.isAlive()) return;
        int before = target.getHealthPoint();
        target.setHealthPoint(before + healpoint);
        System.out.println(getName() + " heals " + target.getName() + " for " + (target.getHealthPoint() - before) + " HP");
        System.out.println(target.getName() + " HP: " + target.getHealthPoint());
        System.out.println();
    }
}
