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

    public void influence(Cultist cultist) {
        if (statuette != null) {
            int randomAmount = Person.random.nextInt(21) + 5;
            cultist.increaseEnergy(randomAmount);
            System.out.println(cultist.getName() + " находится под влиянием монолита. Энергия увеличена на " + randomAmount + ".");
        } else {
            System.out.println("На монолите нет статуэтки.");
        }
    }

    public float getHeight() {
        return height;
    }

    public String getMaterial() {
        return material;
    }

    public Statuette getStatuette() {
        return statuette;
    }

    public void setStatuette(Statuette statuette) {
        this.statuette = statuette;
    }
}