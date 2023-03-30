package org.example.units.Warriors;

import org.example.units.Warrior;

public class Robber extends Warrior {
    public Robber(int x, int y) {
        super(getName(), x, y, 100, new int[]{6, 11}, 20, 1, "Разбойник", 0);
        maxReserve = 20;
    }

    @Override
    public void step() {

    }
}
