package models;

public class Monolith {
    private final float height;
    private final String material;
    private Statuette statuette;

    public Monolith(float height, String material, Statuette statuette) {
        this.height = height;
        this.material = material;
        this.statuette = statuette;
    }
}