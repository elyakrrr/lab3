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
    }
}