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
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public abstract class BaseHero implements GameInterface {
    public String name;       //Имя
    protected String className;   // Имя класса
    protected int x, y;           // Координаты
    protected float hp, maxHp;             // Запас здоровья / Максимальный (начальный) запас здоровьz
    protected int[] damage;       // Минимальная и максимальная сила удара
    protected int def;            // Броня
    protected int distance;       // Дальность удара (воздействия)

    int priority; // Приоритет

    public String status;

    protected int reserve, maxReserve;        // Думаю можно объединить стрелы (для арбалетчика и снайпера), ману (для мага и монаха) и боевой дух (для вора и копейщика)

//    @Override
//    public String toString() {
//        return ;
//    }

    public BaseHero (int x, int y, float hp, int[] damage, int def, int distance, String className, int reserve, int priority, String status) {
        this.name = getName();
        this.x = x;
        this.y = y;
        this.hp = this.maxHp = hp;
        this.damage = damage;
        this.def = def;
        this.distance = distance;
        this.className = className;
        this.reserve = this.maxReserve = reserve;
        this.priority = priority;
        this.status = status;


    }
    @Override
    public String getInfo() {
        String str = className;
        return str;
    }

    @Override
    public String toString() {
        String str = className + " " + name + " Координаты: "+x+" "+y + " Здоровье: " + hp + " Запас: " + reserve+ " Статус: " + status;
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

    public BaseHero findEnemy(ArrayList<BaseHero> enemies) {
        double minDist = Math.sqrt((enemies.get(0).x - this.x) * (enemies.get(0).x - this.x) + (enemies.get(0).y - this.y) * (enemies.get(0).y - this.y));
        double dist;
        BaseHero closestUnit = enemies.get(0);
        for (BaseHero unit: enemies) {
            if (unit.status.equals("died")) continue;
            else {
                dist = Math.sqrt((unit.x - this.x) * (unit.x - this.x) + (unit.y - this.y) * (unit.y - this.y));
                if (dist < minDist) {
                    minDist = dist;
                    closestUnit = unit;
                }
            }
        }
        if (closestUnit == null) return null;
        return closestUnit;
    }

//    protected void died (ArrayList <BaseHero> enemies) {
//        for (BaseHero unit: enemies) {
//            if (unit.hp <= 0) {
//                enemies.remove(unit);
//            }
//        }
//    }

    public static PriorityQueue<BaseHero> sortedPriority(ArrayList<BaseHero> enemies, ArrayList<BaseHero> friends) {

        PriorityQueue<BaseHero> sortedList = new PriorityQueue<>(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero o1, BaseHero o2) {
                if (o1.hp > 0 || o2.hp > 0) {
                    if (o1.priority == o2.priority) {
                        int per2 = (int) (o2.hp*100/(o2.maxHp));
                        int per1 = (int) (o1.hp*100/(o1.maxHp));
                        return per2 - per1;
                    }
                    return o2.priority - o1.priority;
                }
            return 0;
            }
        });
        sortedList.addAll(enemies);
        sortedList.addAll(friends);
        return sortedList;
    }

    public static boolean checkedTeam (ArrayList<BaseHero> team) {
        for (BaseHero unit: team) {
            if (!unit.status.equals("died")) return true;
        }
        return false;
    }



}
