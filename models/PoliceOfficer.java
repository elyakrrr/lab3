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
    }

    public void shootAt(Cultist cultist) {
    }

    public void arrest(Cultist cultist) {
    }

    public void forceToDress(Cultist cultist) {
    }
        
    public void deliver(Cultist cultist, PoliceStation station) {
    }

    @Override
    public void react() {
    }

    @Override
    public void moveTo(Island island) {
    }

    public String getWeaponType() {
        return weaponType;
    }

    public int getExperience() {
        return experience;
    }
}
   