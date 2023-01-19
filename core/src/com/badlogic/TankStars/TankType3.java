package com.badlogic.TankStars;

public class TankType3 extends Tank {
    public String spawnTank()
    {
        return "type4.gif";
    }
    public String spawnTankinGame_1()
    {
        return "Tank3.png";
    }

    public String spawnTankinGame_2()
    {
        return "Tank3_Player2.png";
    }

    public String spawnVerticalTank_1(){
        return "Tank3_uphill.png";
    }

    @Override
    public String spawnVerticalTank_2() {
        return "Tank3_Player2_uphill.png";
    }
}
