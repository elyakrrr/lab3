package models;

import enums.State;
import enums.Mood;
import interfaces.Move;
import exceptions.NegativeHPException;

public class Cultist extends Person implements Move {
    private State state;
    private final String rank;
    private int hp;
    private boolean isInChain;
    private int energy;
    private int escapeBonus = 0;

    public Cultist(String name, String origin, String rank) {
        super(name, origin);
        this.state = State.FREE;
        this.rank = rank;
        
        switch (rank) {
            case "high":
                this.hp = 70;
                break;
            case "medium":
                this.hp = 60;
                break;
            default:
                this.hp = 50;
        }
        
        this.isInChain = false;
        this.energy = 50;
    }
    
    public Cultist(String name, String origin, String rank, int hp, int energy) {
        super(name, origin);
        this.state = State.FREE;
        this.rank = rank;
        this.hp = hp;
        this.isInChain = false;
        this.energy = energy;
    }

    public boolean resist() {
        int power = Person.random.nextInt(50); 
        
        if (rank.equals("high")) {
            power += 20; 
        }
        
        if (power > 30) {
            System.out.println(getName() + " яростно сопротивляется с силой " + power + "!");
            
            increaseEnergy(-10);
            decreaseHp(8);
            
            if (state == State.ARRESTED) {
                escapeBonus = power / 8;
                System.out.println("Сопротивление увеличивает шанс побега на " + escapeBonus);
            }
            
            return true;
        } else {
            System.out.println(getName() + " не сопротивляется.");
            return false;
        }
    }

    public void joinRitual(RingOfFire ring) {
        if (ring.getIntensity() > 0) {
            System.out.println(getName() + " присоединяется к ритуалу.");
            int randomEnergyGain = Person.random.nextInt(16) + 5;
            increaseEnergy(randomEnergyGain);
            
            if (getEnergy() > 15) {
                System.out.println(getName() + " имеет достаточно энергии для усиления ритуала!");
                react();
            }
        } else {
            System.out.println("Ритуал еще не начался.");
        }
    }

    public void tryToEscape() {
        int escapeChance = Person.random.nextInt(100);
        int energyBonus = getEnergy();
        int totalBonus = energyBonus + escapeBonus;
        
        if ((escapeChance + totalBonus) > 70) {
            state = State.FUGITIVE;
            System.out.println(getName() + " сбежал!");
            escapeBonus = 0;
        } else {
            System.out.println(getName() + " не смог сбежать.");
        }
    }
        
    public boolean carryWounded(Cultist woundedCultist) {
        if (state == State.ARRESTED && woundedCultist.getState() == State.WOUNDED_ARRESTED) {
            if (energy < 20) {
                System.out.println(getName() + " не хватает энергии для переноса " + woundedCultist.getName() + "!");
                return false;
            }
            
            System.out.println(getName() + " переносит раненого культиста " + woundedCultist.getName() + ".");
            
            increaseEnergy(-20);
            System.out.println(getName() + " тратит 20 энергии на перенос. Осталось энергии: " + energy);
            
            return true;
        }
        return false;
    }

    public void increaseEnergy(int amount) {
        energy += amount;
        if (energy > 100) energy = 100;
        if (energy < 0) energy = 0;
    }

    public void decreaseHp(int amount) {
        if (amount <= 0) {
            return;
        }
        
        int newHp = hp - amount;
        
        if (newHp < 0) {
            throw new NegativeHPException("HP не может быть отрицательным!");
        }
        
        hp = newHp;
        
        if (hp == 0) {
            state = State.KILLED;
            System.out.println(getName() + " был убит.");
        } else {
            System.out.println(getName() + " получает " + amount + " урона. HP: " + hp);
        }
    }
    
    @Override
    public void react() {
        int moodChance = Person.random.nextInt(100);
        if (moodChance < 70) {
            setMood(Mood.RAGING);
        } else {
            setMood(Mood.PANIC);
        }
    }

    @Override
    public void moveTo(Island island) {
        System.out.println(getName() + " появляется на острове.");
        island.addCultist(this);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getRank() {
        return rank;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isInChain() {
        return isInChain;
    }

    public void setInChain(boolean inChain) {
        isInChain = inChain;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEscapeBonus() {
        return escapeBonus;
    }

    public void setEscapeBonus(int escapeBonus) {
        this.escapeBonus = escapeBonus;
    }
    
    public boolean isAlive() {
        return state != State.KILLED;
    }
}