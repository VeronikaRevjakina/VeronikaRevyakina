package hw3.enums.DifferentElements;

public enum CheckboxForces {
    WATER("Water"),
    EARTH("Earth"),
    FIRE("Fire"),
    WIND("Wind");

    final String force;

    CheckboxForces(String force) {
        this.force = force;
    }

    public String getForce() {
        return force;
    }

}
