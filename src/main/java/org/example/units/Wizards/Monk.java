package org.example.units.Wizards;
import org.example.units.Wizard;

public class Monk extends Wizard {
    public Monk(int x, int y) {
        super(getName(), x, y, 100, new int[]{2, 5}, 10, 4, "Монах", 15);
//        spellsBook[0] = new Spells("Фаербол");
//        spellsBook[1] = new Spells("Лечение");
//        spellsBook[2] = new Spells("Увеличение силы духа");

    }

    @Override
    public void step() {

    }
}
