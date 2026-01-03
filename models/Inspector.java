package models;

import records.InterrogationResults;
import records.RaidResults;

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
  
  public RaidResults count(List<Cultist> cultists) {
        int arrested = 0;
        int killed = 0;
        int wounded = 0;
        int escaped = 0;
        
        for (Cultist cultist : cultists) {
            switch (cultist.getState()) {
                case ARRESTED -> arrested++;
                case KILLED -> killed++;
                case WOUNDED_ARRESTED -> wounded++;
                case FUGITIVE -> escaped++;
            }
        }
        
        return new RaidResults(arrested, killed, wounded, escaped);
    }

  public InterrogationResults interrogate(Cultist cultist) {
        return new InterrogationResults("Негритянский фетишизм", "Продвижение своей религии");
    }
}
