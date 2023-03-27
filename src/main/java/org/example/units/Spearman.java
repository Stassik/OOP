package org.example.units;

public class Spearman extends BaseHero{
    // Сила духа равна вначале 0. При нанесении ударов сила духа повышается на количество нанесенного урона. При достижении максимального значения духа - супер удар
    public Spearman(String name, int x, int y) {
        super(name, x, y, 100, new int[]{6, 11}, 20, 1, "Копейщик", 0);
        maxReserve = 20;
    }
}
