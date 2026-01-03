package models;

import java.util.List;

public class Inspector extends PoliceOfficer {
    public Inspector(String name, String origin, String weaponType, int experience) {
        super(name, origin, weaponType, experience);
    }

public Statuette take(Monolith monolith) {
        Statuette statuette = monolith.getStatuette();
        monolith.setStatuette(null);
        System.out.println(getName() + " забирает статуэтку с монолита.");
        return statuette;
    }
}
