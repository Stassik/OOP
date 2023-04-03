package org.example.units;

import org.example.GameInterface;
import org.example.Names;
import org.example.units.Shooters.Arbalester;
import org.example.units.Shooters.Sniper;
import org.example.units.Warriors.Robber;
import org.example.units.Warriors.Spearman;
import org.example.units.Wizards.Mage;
import org.example.units.Wizards.Monk;

import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero implements GameInterface {
    public String name;       //Имя
    protected String className;   // Имя класса
    protected int x, y;           // Координаты
    float hp, maxHp;             // Запас здоровья / Максимальный (начальный) запас здоровьz
    int[] damage;       // Минимальная и максимальная сила удара
    int def;            // Броня
    int distance;       // Дальность удара (воздействия)

    protected int reserve, maxReserve;        // Думаю можно объединить стрелы (для арбалетчика и снайпера), ману (для мага и монаха) и боевой дух (для вора и копейщика)

//    @Override
//    public String toString() {
//        return ;
//    }

    public BaseHero (int x, int y, float hp, int[] damage, int def, int distance, String className, int reserve) {
        this.name = getName();
        this.x = x;
        this.y = y;
        this.hp = this.maxHp = hp;
        this.damage = damage;
        this.def = def;
        this.distance = distance;
        this.className = className;
        this.reserve = this.maxReserve = reserve;


    }
    @Override
    public String getInfo() {
        String str = "Я "+name+". Я " + className + "! Координаты: "+x+" "+y + " Мое здоровье: " + hp + " Мой запас: " + reserve;
        return str;
    }
    private String getName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }
    public static ArrayList<BaseHero> generateTeam(int team) {
        ArrayList<BaseHero> units = new ArrayList<>();
        int posX;
        if (team == 1) {
            posX = 0;

        } else {
            posX = 9;
        }
        for (int i = 0; i < 10; i++ ) {
            switch (new Random().nextInt(7)) {
                case 0:
                    units.add(new Armsman(posX, i));
                    break;
                case 1:
                    units.add(new Mage(posX, i));
                    break;
                case 2:
                    units.add(new Monk(posX, i));
                    break;
                case 3:
                    units.add(new Arbalester(posX, i));
                    break;
                case 4:
                    units.add(new Sniper(posX, i));
                    break;
                case 5:
                    units.add(new Robber(posX, i));
                    break;
                default:
                    units.add(new Spearman(posX, i));
            }
        }
        return units;
    }

    public BaseHero findEnemy(ArrayList<BaseHero> enemy) {
        double minDist = Math.sqrt((enemy.get(0).x - this.x) * (enemy.get(0).x - this.x) + (enemy.get(0).y - this.y) * (enemy.get(0).y - this.y));
        double dist;
        BaseHero closestUnit = enemy.get(0);
        for (BaseHero unit: enemy) {
            if (unit.hp <= 0) continue;
            else {
                dist = Math.sqrt((unit.x - this.x) * (unit.x - this.x) + (unit.y - this.y) * (unit.y - this.y));
                if (dist < minDist) {
                    minDist = dist;
                    closestUnit = unit;
                }
            }
        }
        return closestUnit;
    }


}
