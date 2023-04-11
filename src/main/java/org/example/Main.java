package org.example;

import org.example.units.*;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static ArrayList<BaseHero> holyTeam;
    public static ArrayList<BaseHero> darkTeam;
    public static PriorityQueue<BaseHero> allTeam;

    public static void main(String[] args) {

        holyTeam = BaseHero.generateTeam(1);
        darkTeam = BaseHero.generateTeam(2);

        Scanner input = new Scanner(System.in);
        while ( BaseHero.checkedTeam(holyTeam) && BaseHero.checkedTeam(darkTeam)) {
//        while (true) {
            allTeam = BaseHero.sortedPriority(darkTeam, holyTeam);
            View.view();
//            input.nextLine();
            for (BaseHero unit : allTeam) {
                if (holyTeam.contains(unit)) {
//                    System.out.println("Игрок: " + unit.toString() + " | Ближайший враг: " + unit.findEnemy(holyTeam).toString());
                    unit.step(darkTeam, holyTeam);
                } else {
//                    System.out.println("Игрок: " + unit.toString() + " | Ближайший враг: " + unit.findEnemy(holyTeam).toString());
                    unit.step(holyTeam, darkTeam);
                }
            }
            for (BaseHero u: allTeam) {
                if (u.status.equals("busy")) {
                    u.status = "stand";
                }
            }
        }
        if (BaseHero.checkedTeam(holyTeam)) {
            System.out.println("Победила команда Света!");
        } else {
            System.out.println("Победила команда Тьмы!");
        }


//        while ( BaseHero.checkedTeam(holyTeam) && BaseHero.checkedTeam(darkTeam)) {
//            System.out.println("Команда Света:");
//            holyTeam.forEach(n -> System.out.println(n.toString()));
//            System.out.println();
//            System.out.println("Команда Тьмы:");
//            darkTeam.forEach(n -> System.out.println(n.toString()));
//            System.out.println("-".repeat(10));
//
//
//            for (BaseHero unit: allTeam) {
//                System.out.println("ХОД:");
//                if (holyTeam.contains(unit)) {
//                    System.out.println("Игрок: " + unit.toString() + " | Ближайший враг: "+ unit.findEnemy(darkTeam).toString());
//                    unit.step(darkTeam, holyTeam);
//                } else {
//                    System.out.println("Игрок: " + unit.toString() + " | Ближайший враг: "+ unit.findEnemy(holyTeam).toString());
//                    unit.step(holyTeam, darkTeam);
//                }
//            }
//            System.out.println("Очередность:");
//            while (!allTeam.isEmpty()) {
//                System.out.println(allTeam.poll().toString());
//            }
//            for (BaseHero unit: holyTeam) {
//                if (unit.status.equals("busy")) {
//                    unit.status = "stand";
//                }
//            }
//            for (BaseHero unit: darkTeam) {
//                if (unit.status.equals("busy")) {
//                unit.status = "stand";
//                }
//            }
//
//
//
//        }
//
//        if (BaseHero.checkedTeam(holyTeam)) {
//            System.out.println("Победила команда Света!");
//        } else {
//            System.out.println("Победила команда Тьмы!");
//        }
//
//    }

    }

}