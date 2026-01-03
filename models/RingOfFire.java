package models;

public class RingOfFire {
    private int intensity;

    public RingOfFire() {
        this.intensity = Person.random.nextInt(10) + 1;
    }

public boolean obscureVisibility(Monolith monolith) {
        return intensity > 5;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
    }
}