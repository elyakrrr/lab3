package factories;

import models.Cultist;

public class CultistFactory extends PersonFactory {
    private String rank;
    private int baseHp;
    private int baseEnergy;
    
    public CultistFactory(String rank) {
        this.rank = rank;
        
        switch (rank) {
            case "high":
                this.baseHp = 70;
                this.baseEnergy = 60;
                break;
            case "medium":
                this.baseHp = 60;
                this.baseEnergy = 50;
                break;
            default:
                this.baseHp = 50;
                this.baseEnergy = 40;
        }
    }

@Override
    public Cultist createPerson(String name, String origin) {
        return new Cultist(name, origin, rank, baseHp, baseEnergy);
    }
}