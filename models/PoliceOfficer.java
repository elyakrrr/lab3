package models;

import enums.Mood;
import interfaces.Move;	
import enums.State;

public class PoliceOfficer extends Person implements Move {
    private final String weaponType;
    private final int experience;

    public PoliceOfficer(String name, String origin, String weaponType, int experience) {
        super(name, origin);
        this.weaponType = weaponType;
        this.experience = experience;
    }
 
 public void witnessRitual() {
        int shockLevel = Person.random.nextInt(100);
        if (shockLevel > 70) {
            setMood(Mood.SHOCKED);
        } else if (shockLevel > 40) {
            setMood(Mood.PANIC);
        } else {
            setMood(Mood.CALM);
        }
    }

    public void shootAt(Cultist cultist) {
        if (!cultist.isAlive()) {
            System.out.println(cultist.getName() + " уже мертв!");
            return;
        }
        
        int baseChance = experience;
        int randomChance = Person.random.nextInt(41) - 20;
        int finalChance = baseChance + randomChance;
        
        if (finalChance > 50) {
            int damage = Person.random.nextInt(31) + 15;
            
            System.out.println(getName() + " стреляет в " + cultist.getName() + "!");
            cultist.decreaseHp(damage);
            
            if (cultist.getState() != State.KILLED) {
                int effectChance = Person.random.nextInt(100);
                if (effectChance > 60) {
                    cultist.setState(State.WOUNDED_ARRESTED);
                    System.out.println(getName() + " ранил " + cultist.getName());
                }
            }
        } else {
            System.out.println(getName() + " промахнулся по " + cultist.getName());
        }
    }

    public void arrest(Cultist cultist) {
        if (!cultist.isAlive()) {
            System.out.println(cultist.getName() + " мертв, арест невозможен.");
            return;
        }
        
        if (cultist.getState() == State.FREE) {
            cultist.setState(State.ARRESTED);
            System.out.println(getName() + " арестовал " + cultist.getName());
        }
    }

    public void forceToDress(Cultist cultist) {
        if (!cultist.isAlive()) {
            System.out.println(cultist.getName() + " мертв, нельзя надеть цепи.");
            return;
        }
        
        if (cultist.getState() == State.ARRESTED || cultist.getState() == State.WOUNDED_ARRESTED) {
            cultist.setInChain(true);
            System.out.println(cultist.getName() + " теперь в цепочке.");
        }
    }
        
    public void deliver(Cultist cultist, PoliceStation station) {
        if (!cultist.isAlive()) {
            System.out.println(cultist.getName() + " мертв, доставка невозможена.");
            return;
        }
        
        System.out.println(getName() + " доставляет " + cultist.getName() + " в полицейский участок.");
        station.addCultist(cultist);
        
        cultist.setInChain(false);
        System.out.println(cultist.getName() + " цепи сняты в участке.");
    }

    @Override
    public void react() {
        int reaction = Person.random.nextInt(100);
        if (reaction > 80) {
            setMood(Mood.PANIC);
        } else {
            setMood(Mood.CALM);
        }
    }

    @Override
    public void moveTo(Island island) {
        System.out.println(getName() + " появляется на острове.");
        island.addPoliceOfficer(this);
    }

    public String getWeaponType() {
        return weaponType;
    }

    public int getExperience() {
        return experience;
    }
}