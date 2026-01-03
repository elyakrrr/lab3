package factories;

import models.Cultist;

public class CultistFactory extends PersonFactory {
    private String rank;
    private int baseHp;
    private int baseEnergy;
    
    public CultistFactory(String rank) {
        this.rank = rank;
    }

@Override
    public Cultist createPerson(String name, String origin) {
        return new Cultist(name, origin, rank, baseHp, baseEnergy);
    }
}