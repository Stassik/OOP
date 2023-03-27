package org.example.units;

public class Sniper extends BaseHero{
    protected int accuracy;
    public Sniper(String name, int x, int y) {
        super(name, x, y, 100, new int[]{4, 7}, 15, 4, "Снайпер", 10);
        accuracy = 70;
    }
}
