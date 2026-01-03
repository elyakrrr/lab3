package factories;

import models.PoliceOfficer;

public class PoliceOfficerFactory extends PersonFactory {
    private String weaponType;
    private int experience;
    
    public PoliceOfficerFactory(String weaponType, int experience) {
        this.weaponType = weaponType;
        this.experience = experience;
    }

@Override
    public PoliceOfficer createPerson(String name, String origin) {
        return new PoliceOfficer(name, origin, weaponType, experience);
    }
}