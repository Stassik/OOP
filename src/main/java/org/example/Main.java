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
    public static ArrayList<BaseHero> lightTeam;
    public static ArrayList<BaseHero> darkTeam;
    public static void main(String[] args) {



        lightTeam = BaseHero.generateTeam(1);
        darkTeam = BaseHero.generateTeam(2);


        System.out.println("Команда Света:");
        lightTeam.forEach(n -> System.out.println(n.getInfo()));
        System.out.println();
        System.out.println("Команда Тьмы:");
        darkTeam.forEach(n -> System.out.println(n.getInfo()));

        System.out.println("Игрок: " + lightTeam.get(7).getInfo() + " | Ближайший враг: "+ lightTeam.get(7).findEnemy(darkTeam).getInfo());
    }



}