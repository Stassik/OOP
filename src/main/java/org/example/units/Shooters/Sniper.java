package org.example.units.Shooters;

import org.example.units.Shooter;

public class Sniper extends Shooter {
    public Sniper(int x, int y) {
        super(getName(), x, y, 100, new int[]{4, 7}, 15, 4, "Снайпер", 10, 70);
    }

    @Override
    public void step() {

    }
}
