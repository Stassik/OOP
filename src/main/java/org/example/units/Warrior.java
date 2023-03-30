package org.example.units;

public abstract class Warrior extends BaseHero{
    public Warrior(String name, int x, int y, float hp, int[] damage, int def, int distance, String className, int reserve) {
        super(name, x, y, hp, damage, def, distance, className, reserve);
    }
}
