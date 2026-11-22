import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monster extends GameCharacter {
    private final Random random = new Random();
    private GameCharacter target;

    public Monster(String name, int hp, int strength) {
    	super(name, hp, strength); 
    }

    @Override
    public void selectSkill(List<GameCharacter> party) {
        List<GameCharacter> aliveMembers = new ArrayList<>();
        for (GameCharacter member : party) 
        	if (member.isAlive()) 
        		aliveMembers.add(member);
        if (aliveMembers.isEmpty()) {
        	setSkill(0); 
        	return; 
        }
        if (random.nextInt(4) == 0) {
            setSkill(2);
            System.out.println(getName() + " prepares an area attack!");
        } else {
            setSkill(1);
            target = aliveMembers.get(random.nextInt(aliveMembers.size()));
            System.out.println(getName() + " targets " + target.getName());
        }
    }

    @Override
    public void usedSkill(List<GameCharacter> party) {
        if (!isAlive()) return;
        switch (getSkill()) {
            case 1:
                if (target != null && target.isAlive()) 
                	attack(target);
                else {
                    for (GameCharacter member : party) {
                        if (member.isAlive()) { 
                        	attack(member); 
                        	break; 
                        }
                    }
                }
                break;
            case 2: AOEattack(party); break;
            default: break;
        }
    }

    public void AOEattack(List<GameCharacter> party) {
        System.out.println(getName() + " attacks all living party members!");
        for (GameCharacter member : party) {
            if (member.isAlive()) dealDamage(member, getStrength() / 2, "area-attacks");
        }
    }
}

