package org.example.units;

public abstract class Shooter extends BaseHero{
    int accuracy;
    public Shooter(String name, int x, int y, float hp, int[] damage, int def, int distance, String className, int reserve, int accuracy) {
        super(name, x, y, hp, damage, def, distance, className, reserve);
        this.accuracy = accuracy;

    }
}
