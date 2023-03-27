package org.example.units;

public class Armsman extends  BaseHero{
    //Непонятно откуда беруться у него стрелы и как он их передает... Он куда-то за ними ходит и потом должен дойти до лучника чтобы передать
    //или есть какой-то запас этих стрел и они передаются "по воздуху"?
    public Armsman(String name, int x, int y) {
        super(name, x, y, 100, new int[]{1, 3}, 0, 1, "Оруженосец", 0);
    }
}
