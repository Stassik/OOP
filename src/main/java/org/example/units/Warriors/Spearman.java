package org.example.units.Warriors;

import org.example.units.Warrior;

public class Spearman extends Warrior {
    // Сила духа равна вначале 0. При нанесении ударов сила духа повышается на количество нанесенного урона. При достижении максимального значения духа - супер удар
    public Spearman(int x, int y) {
        super(getName(), x, y, 100, new int[]{6, 11}, 20, 1, "Копейщик", 0);
        maxReserve = 20;
    }

    @Override
    public void step() {

    }


}
