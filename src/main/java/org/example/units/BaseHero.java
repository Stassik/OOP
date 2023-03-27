package org.example.units;

public abstract class BaseHero {
    String name;       //Имя
    String className;   // Имя класса
    int x, y;           // Координаты
    float hp, maxHp;             // Запас здоровья / Максимальный (начальный) запас здоровьz
    int[] damage;       // Минимальная и максимальная сила удара
    int def;            // Броня
    int distance;       // Дальность удара (воздействия)

    int reserve, maxReserve;        // Думаю можно объединить стрелы (для арбалетчика и снайпера), ману (для мага и монаха) и боевой дух (для вора и копейщика)

    @Override
    public String toString() {
        return "Имя: "+ name + " | Класс: " + className + " | Здоровье: " + hp + " из "+maxHp + " | Броня: " + def + " | Запасы (стрел, маны, духа): " + reserve+ " из "+ maxReserve;
    }

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
}
