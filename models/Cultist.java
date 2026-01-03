package models;

import enums.State;
import enums.Mood;
import interfaces.Move;

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

 public boolean resist() {     
    }

    public void joinRitual(RingOfFire ring) {
    }

    public void tryToEscape() {
    }
        
    public boolean carryWounded(Cultist woundedCultist) {
    }

    public void increaseEnergy(int amount) {
    }

    public void decreaseHp(int amount) {
    }
    
    @Override
    public void react() {
    }

    @Override
    public void moveTo(Island island) {
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
    }
}