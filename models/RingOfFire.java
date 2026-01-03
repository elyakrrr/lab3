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
        this.intensity = intensity;
        if (this.intensity < 0) {
            this.intensity = 0;
        }
        if (this.intensity > 10) {
            this.intensity = 10;
        }
    }
}