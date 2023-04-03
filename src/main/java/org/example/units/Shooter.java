package org.example.units;

import org.example.GameInterface;

import java.util.ArrayList;
import java.util.Random;

public abstract class Shooter extends BaseHero{
    int accuracy;
    public Shooter(int x, int y, float hp, int[] damage, int def, int distance, String className, int reserve, int accuracy) {
        super(x, y, hp, damage, def, distance, className, reserve);
        this.accuracy = accuracy;

    }

    @Override
    public void step(ArrayList<BaseHero> enemy) {
        if (this.hp <= 0) {
            return;
        } else if (this.reserve <= 0 && this.hp > 0) {
            this.x ++;
            System.out.println("Игрок: " + this.getInfo());
        } else {
            BaseHero unit = findEnemy(enemy);
            if (unit != null) {
                shooting(unit);
            } else {
                this.x ++;
            }
            System.out.println("Игрок: " + this.getInfo());
            System.out.println("Игрок: " + unit.getInfo());
        }
    }

    private void shooting(BaseHero unit) {
        System.out.println("ПИФ-Паф!");
        int[] crash = chooseDamage();
        unit.hp = unit.hp * (1 + unit.def/100) - new Random().nextInt(crash[0], crash[1]);
    }

    // Если запаса стрел больше половины то можно использовать критический удар. Запас стрел тогда уменьшится на 5 поинтов.
    private int[] chooseDamage () {
        if (reserve >= maxReserve/2) {
            int[] criticalDamage = new int[] {this.damage[0]*2, this.damage[1]*2};
            System.out.println("Нанесен критический урон!");
            this.reserve -= 5;
            return criticalDamage;
        } else {
            this.reserve--;
            return this.damage;

        }
    }




}
