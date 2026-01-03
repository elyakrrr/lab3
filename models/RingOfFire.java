package models;

public class RingOfFire {
    private int intensity;

    public RingOfFire() {
        this.intensity = Person.random.nextInt(10) + 1;
    }
}