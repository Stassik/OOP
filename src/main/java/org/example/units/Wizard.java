package org.example.units;


public abstract class Wizard extends BaseHero{
    //protected Spells[] spellsBook = new Spells[3];
    public Wizard(int x, int y, float hp, int[] damage, int def, int distance, String className, int reserve) {
        super(x, y, hp, damage, def, distance, className, reserve);
    }
    @Override
    public void step() {

    }
}
