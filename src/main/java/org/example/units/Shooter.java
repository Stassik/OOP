package org.example.units;

import java.util.ArrayList;
import java.util.Random;

public abstract class Shooter extends BaseHero{
    int accuracy;
    public Shooter(int x, int y, float hp, int[] damage, int def, int distance, String className, int reserve, int accuracy, int priority, String status) {
        super(x, y, hp, damage, def, distance, className, reserve, priority, status);
        this.accuracy = accuracy;

    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> friends) {
        if (this.status.equals("died")) {
            System.out.println("Мертв");
//            return;
        } else {
            BaseHero unit = findEnemy(enemies);
            if (unit != null) {
                shooting(unit, friends);
            }
            System.out.println("Игрок: " + this.toString());
            System.out.println("Игрок: " + unit.toString());
        }
    }

    private boolean findArmsman (ArrayList <BaseHero> friends) {
        for (BaseHero unit: friends) {
            if (unit.status.equals("died")) continue;
            else {
                if (unit.className.equals("Оруженосец") && unit.status.equals("stand")) {
                    System.out.println("Найден "+ unit.toString());
                    unit.status = "busy";
                    return true;
                }
            }
        }
        return false;
    }

    private void shooting(BaseHero unit, ArrayList <BaseHero> friends) {
        int[] crash = chooseDamage(friends);
        if (crash != null) {
            System.out.println("ПИФ-Паф!");
            unit.hp = unit.hp * (1 + unit.def/100) - new Random().nextInt(crash[0], crash[1]);
            if (unit.hp <= 0) {
                unit.hp = 0;
                unit.status = "died";

            }
        } else {
            System.out.println("ПРОПУСК ХОДА");
        }

    }

    // Если запаса стрел больше половины то можно использовать критический удар. Запас стрел тогда уменьшится на 5 поинтов.
    private int[] chooseDamage (ArrayList <BaseHero> friends) {
        if (findArmsman(friends)) {
            if (reserve >= maxReserve/2) {
                int[] criticalDamage = new int[] {this.damage[0]*2, this.damage[1]*2};
                System.out.println("Нанесен критический урон!");
                this.reserve -= 4;
                return criticalDamage;
            } else {
                return this.damage;
            }
        } else {
            if (reserve >= maxReserve/2) {
                int[] criticalDamage = new int[] {this.damage[0]*2, this.damage[1]*2};
                System.out.println("Нанесен критический урон!");
                this.reserve -= 5;
                return criticalDamage;
            } else if (reserve > 0){
                this.reserve--;
                return this.damage;
            } else {
                return null;
            }
        }

    }






}
