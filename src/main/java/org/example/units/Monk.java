package org.example.units;

import org.example.Spells;

public class Monk extends BaseHero{
    protected Spells[] spellsBook = new Spells[3];
    public Monk(String name, int x, int y) {
        super(name, x, y, 100, new int[]{2, 5}, 10, 4, "Монах", 15);
        spellsBook[0] = new Spells("Фаербол");
        spellsBook[1] = new Spells("Лечение");
        spellsBook[2] = new Spells("Увеличение силы духа");

    }
}
