package org.example;

import org.example.units.BaseHero;

import java.util.ArrayList;
import java.util.Random;

public interface GameInterface {
    void step(ArrayList<BaseHero> list);
    String getInfo();
}
