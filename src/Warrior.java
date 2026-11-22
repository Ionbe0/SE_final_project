public class Warrior extends GameCharacter {
    public Warrior(String name, int hp, int strength) { super(name, hp, strength); }

    @Override
    public void selectSkill() {
        System.out.println(getName() + " select skill");
        System.out.println("(1) attack: " + getStrength() + " damage");
        System.out.println("(2) strengthDown: enemy strength -" + Math.max(1, getStrength() / 10));
        setSkill(chooseSkill());
    }

    @Override
    public void usedSkill(GameCharacter target) {
        if (!isAlive() || !target.isAlive()) return;
        switch (getSkill()) {
            case 1: attack(target); break;
            case 2: strengthDown(target); break;
            default: break;
        }
    }

    public void strengthDown(GameCharacter target) {
        int reduction = Math.min(target.getStrength(), Math.max(1, getStrength() / 10));
        target.setStrength(target.getStrength() - reduction);
        System.out.println(getName() + " lowers " + target.getName() + " strength by " + reduction);
        System.out.println(target.getName() + " strength: " + target.getStrength());
        System.out.println();
    }
}
