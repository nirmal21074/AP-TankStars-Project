package com.badlogic.TankStars;

import com.badlogic.gdx.Screen;

public class TankType1 extends Tank
{
    public String spawnTank()
    {
        return "type1.gif";
    }

    public String spawnTankinGame_1()
    {
        return "Tank1.png";
    }

    public String spawnTankinGame_2()
    {
        return "Tank1_Player2.png";
    }
    public String spawnVerticalTank_1(){
        return "Tank1_uphill.png";
    }

    @Override
    public String spawnVerticalTank_2() {
        return "Tank1_Player2_uphill.png";
    }
}
