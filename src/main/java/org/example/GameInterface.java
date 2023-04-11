package org.example;

import org.example.units.BaseHero;

import java.util.ArrayList;

public interface GameInterface {
    void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> friends);
    char getInfo();
    float getHp();
    int[] getCoords();
}
