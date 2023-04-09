package org.example;

import org.example.units.*;
import org.example.units.Shooters.Arbalester;
import org.example.units.Shooters.Sniper;
import org.example.units.Warriors.Robber;
import org.example.units.Warriors.Spearman;
import org.example.units.Wizards.Mage;
import org.example.units.Wizards.Monk;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<BaseHero> lightTeam;
        ArrayList<BaseHero> darkTeam;

        lightTeam = BaseHero.generateTeam(1);
        darkTeam = BaseHero.generateTeam(2);
        while ( BaseHero.checkedTeam(lightTeam) && BaseHero.checkedTeam(darkTeam)) {
            System.out.println("Команда Света:");
            lightTeam.forEach(n -> System.out.println(n.toString()));
            System.out.println();
            System.out.println("Команда Тьмы:");
            darkTeam.forEach(n -> System.out.println(n.toString()));
            System.out.println("-".repeat(10));
            PriorityQueue<BaseHero> sortedListUnits = BaseHero.sortedPriority(darkTeam, lightTeam);

            for (BaseHero unit: sortedListUnits) {
                System.out.println("ХОД:");
                if (lightTeam.contains(unit)) {
                    System.out.println("Игрок: " + unit.toString() + " | Ближайший враг: "+ unit.findEnemy(darkTeam).toString());
                    unit.step(darkTeam, lightTeam);
                } else {
                    System.out.println("Игрок: " + unit.toString() + " | Ближайший враг: "+ unit.findEnemy(lightTeam).toString());
                    unit.step(lightTeam, darkTeam);
                }
            }
            System.out.println("Очередность:");
            while (!sortedListUnits.isEmpty()) {
                System.out.println(sortedListUnits.poll().toString());
            }
            for (BaseHero unit: lightTeam) {
                if (unit.status.equals("busy")) {
                    unit.status = "stand";
                }
            }
            for (BaseHero unit: darkTeam) {
                if (unit.status.equals("busy")) {
                unit.status = "stand";
                }
            }



        }

        if (BaseHero.checkedTeam(lightTeam)) {
            System.out.println("Победила команда Света!");
        } else {
            System.out.println("Победила команда Тьмы!");
        }

    }



}