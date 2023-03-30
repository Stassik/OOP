package org.example.units;

public abstract class Shooter extends BaseHero{
    int accuracy;
    public Shooter(int x, int y, float hp, int[] damage, int def, int distance, String className, int reserve, int accuracy) {
        super(x, y, hp, damage, def, distance, className, reserve);
        this.accuracy = accuracy;

    }

    @Override
    public void step() {

    }
}
