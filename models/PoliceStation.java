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

public void addCultist(Cultist cultist) {
    }

    public List<PoliceOfficer> getPoliceOfficers() {
        return policeOfficers;
    }

    public void setPoliceOfficers(List<PoliceOfficer> policeOfficers) {
    }

    public List<Cultist> getCultists() {
        return cultists;
    }

    public void setCultists(List<Cultist> cultists) {
    }
}