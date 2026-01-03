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
}
   