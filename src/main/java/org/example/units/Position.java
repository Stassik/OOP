package org.example.units;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Position {
    protected int x, y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected void changePosition(BaseHero enemy, BaseHero unit, PriorityQueue<BaseHero> allTeam) {
        if (enemy.pos.y > unit.pos.y) {
            if (checkingForEmptinessY(unit.pos, allTeam, 1)) {
                unit.pos.y++;
            } else {
                changePositionX(enemy, unit, allTeam);
            }
        } else if (enemy.pos.y < unit.pos.y) {
            if (checkingForEmptinessY(unit.pos, allTeam, -1)) {
                unit.pos.y--;
            } else {
                changePositionX(enemy, unit, allTeam);
            }
        } else {
            changePositionX(enemy, unit, allTeam);
        }
    }

    private void changePositionX(BaseHero enemy, BaseHero unit, PriorityQueue<BaseHero> allTeam) {
        if (enemy.pos.x > unit.pos.x && checkingForEmptinessX(unit.pos, allTeam, 1)) {
            unit.pos.x++;
        } else if (enemy.pos.x < unit.pos.x && checkingForEmptinessX(unit.pos, allTeam, -1)) {
            unit.pos.x--;
        }
    }

    private boolean checkingForEmptinessX(Position pos, PriorityQueue<BaseHero> allTeam, int sign) {
        int newPosX = pos.x + sign;;
        for (BaseHero unit: allTeam) {
            if (!unit.status.equals("died")) {
                if ((newPosX == unit.pos.x) && (pos.y == unit.pos.y) ) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean checkingForEmptinessY(Position pos, PriorityQueue<BaseHero> allTeam, int sign) {
        int newPosY = pos.y + sign;;
        for (BaseHero unit: allTeam) {
            if (unit.hp > 0) {
                if ((newPosY == unit.pos.y) && (pos.x == unit.pos.x)) {
                    return false;
                }
            }
        }
        return true;
    }
}
