package org.example.units;

public class Robber extends Warrior{
    public Robber(String name, int x, int y) {
        super(name, x, y, 100, new int[]{6, 11}, 20, 1, "Разбойник", 0);
        maxReserve = 20;
    }
}
