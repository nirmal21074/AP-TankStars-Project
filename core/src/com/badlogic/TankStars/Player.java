package com.badlogic.TankStars;

public class Player {

    private Tank tank;
    private int health;
    private int fuel;
    private String pos;

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public int getFuel() {
        return fuel;
    }

    public int getHealth() {
        return health;
    }

    public Tank getTank() {
        return tank;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }


}
