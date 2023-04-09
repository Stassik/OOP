package org.example.units.Warriors;

import org.example.units.Warrior;

public class Robber extends Warrior {
    public Robber(int x, int y) {
        super(x, y, 100, new int[]{6, 11}, 20, 1, "Разбойник", 0, 10, "stand");
        maxReserve = 20;
    }
}
