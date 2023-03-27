package org.example.units;

public class Arbalester extends BaseHero{
    protected int accuracy;
    public Arbalester(String name, int x, int y) {
        super(name, x, y, 100, new int[]{4, 7}, 15, 4, "Арбалетчик", 10);
        accuracy = 70;
    }
}
