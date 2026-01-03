package models;

import java.util.List;
import java.util.ArrayList;

public class PoliceStation {
    private List<PoliceOfficer> policeOfficers;
    private List<Cultist> cultists;

    public PoliceStation() {
        this.policeOfficers = new ArrayList<>();
        this.cultists = new ArrayList<>();
    }
}