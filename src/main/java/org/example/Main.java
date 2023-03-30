package org.example;

import org.example.units.*;
import org.example.units.Shooters.Arbalester;
import org.example.units.Shooters.Sniper;
import org.example.units.Warriors.Robber;
import org.example.units.Warriors.Spearman;
import org.example.units.Wizards.Mage;
import org.example.units.Wizards.Monk;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ArrayList<BaseHero> lightTeam;
        ArrayList<BaseHero> darkTeam;

        lightTeam = generateTeam("lightTeam");
        darkTeam = generateTeam("darkTeam");


        System.out.println("Команда Света:");
        lightTeam.forEach(n -> System.out.println(n.getInfo()));
        System.out.println();
        System.out.println("Команда Тьмы:");
        darkTeam.forEach(n -> System.out.println(n.getInfo()));
    }


    private static ArrayList<BaseHero> generateTeam(String team) {
        ArrayList<BaseHero> units = new ArrayList<>();
        int minX;
        int maxX;
        if (team.contains("lightTeam")) {
            minX = 1;
            maxX = 6;
        } else {
            minX = 6;
            maxX = 11;
        }
        for (int i = 1; i <= 10; i++ ) {
            switch (new Random().nextInt(7)) {
                case 0:
                    units.add(new Armsman(new Random().nextInt(minX, maxX), new Random().nextInt(11)));
                    break;
                case 1:
                    units.add(new Mage(new Random().nextInt(minX, maxX), new Random().nextInt(11)));
                    break;
                case 2:
                    units.add(new Monk(new Random().nextInt(minX, maxX), new Random().nextInt(11)));
                    break;
                case 3:
                    units.add(new Arbalester(new Random().nextInt(minX, maxX), new Random().nextInt(11)));
                    break;
                case 4:
                    units.add(new Sniper(new Random().nextInt(minX, maxX), new Random().nextInt(11)));
                    break;
                case 5:
                    units.add(new Robber(new Random().nextInt(minX, maxX), new Random().nextInt(11)));
                    break;
                default:
                    units.add(new Spearman(new Random().nextInt(minX, maxX), new Random().nextInt(11)));
            }
        }
        return units;
    }
}