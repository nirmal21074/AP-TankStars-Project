package com.badlogic.TankStars;

public class TankType2 extends Tank {
    public String spawnTank()
    {
        return "type3.gif";
    }
    public String spawnTankinGame_1()
    {
        return "Tank2.png";
    }

    public String spawnTankinGame_2()
    {
        return "Tank2_Player2.png";
    }

    public String spawnVerticalTank_1(){
        return "Tank2_uphill.png";
    }

    @Override
    public String spawnVerticalTank_2() {
        return "Tank2_Player2_uphill.png";
    }
}
