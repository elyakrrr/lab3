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

    public Monolith getMonolith() {
        return monolith;
    }

    public void setMonolith(Monolith monolith) {
        this.monolith = monolith;
    }

    public RingOfFire getRingOfFire() {
        return ringOfFire;
    }

    public void setRingOfFire(RingOfFire ringOfFire) {
        this.ringOfFire = ringOfFire;
    }

    public List<PoliceOfficer> getPoliceOfficers() {
        return policeOfficers;
    }

    public void addPoliceOfficer(PoliceOfficer officer) {
        this.policeOfficers.add(officer);
    }

    public List<Cultist> getCultists() {
        return cultists;
    }

    public void addCultist(Cultist cultist) {
        this.cultists.add(cultist);
    }
}