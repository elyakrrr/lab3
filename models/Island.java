package models;

import java.util.List;
import java.util.ArrayList;

public class Island {
    private Monolith monolith;
    private RingOfFire ringOfFire;
    private List<PoliceOfficer> policeOfficers;
    private List<Cultist> cultists;

    public Island() {
        this.policeOfficers = new ArrayList<>();
        this.cultists = new ArrayList<>();
    }
}