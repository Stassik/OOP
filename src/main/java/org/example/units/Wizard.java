package org.example.units;


import java.util.ArrayList;
import java.util.PriorityQueue;

public abstract class Wizard extends BaseHero{
    //protected Spells[] spellsBook = new Spells[3];
    public Wizard(int x, int y, float hp, int[] damage, int def, int distance, String className, int reserve, int priority, String status) {
        super(x, y, hp, damage, def, distance, className, reserve, priority, status, '\u2695');
    }
    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> friends, PriorityQueue<BaseHero> allTeam) {

    }
}
