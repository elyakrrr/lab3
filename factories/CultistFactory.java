package factories;

import models.Cultist;

public class CultistFactory extends PersonFactory {
    private String rank;
    private int baseHp;
    private int baseEnergy;
    
    public CultistFactory(String rank) {
        this.rank = rank;
    }