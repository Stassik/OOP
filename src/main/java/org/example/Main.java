package org.example;

import org.example.units.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<BaseHero> units = new ArrayList<>();
        units.add(new Mage("Иван", 1, 2));
        units.add(new Sniper("Вася", 2, 5));
        units.add(new Spearman("Игнат", 3, 3));
        units.add(new Robber("Филипп", 3, 7));
        units.add(new Monk("Иосиф", 8, 2));
        units.add(new Arbalester("Иннокентий", 7, 4));
        units.add(new Armsman("Федот", 4, 7));


        units.forEach(n -> System.out.println(n));
    }
}