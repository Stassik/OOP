package org.example.units;

import org.example.Spells;

import java.util.ArrayList;

public class Mage extends Wizard{

    public Mage(String name, int x, int y) {
        super(name, x, y, 100, new int[]{2, 5}, 10, 4, "Маг", 15);
        spellsBook[0] = new Spells("Фаербол");
        spellsBook[1] = new Spells("Яд");
        spellsBook[2] = new Spells("Защита");

    }
}
