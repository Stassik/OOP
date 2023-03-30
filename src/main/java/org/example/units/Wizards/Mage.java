package org.example.units.Wizards;


import org.example.units.Wizard;

public class Mage extends Wizard {

    public Mage(int x, int y) {
        super(getName(), x, y, 100, new int[]{2, 5}, 10, 4, "Маг", 15);
//        spellsBook[0] = new Spells("Фаербол");
//        spellsBook[1] = new Spells("Яд");
//        spellsBook[2] = new Spells("Защита");

    }

    @Override
    public void step() {

    }
}
