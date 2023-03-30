package org.example.units;

import org.example.GameInterface;
import org.example.Names;

import java.util.Random;

public abstract class BaseHero implements GameInterface {
    protected String name;       //Имя
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

    public BaseHero (String name, int x, int y, float hp, int[] damage, int def, int distance, String className, int reserve) {
        this.name = name;
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
        String str = "Я "+name+". Я " + className + "!";
        return str;
    }
    public static String getName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }


}
