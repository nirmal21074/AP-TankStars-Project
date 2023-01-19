package com.badlogic.TankStars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

import static java.lang.Thread.sleep;

public class CustomisationMenu implements Screen {

    TanksStars game;
    Texture tankImage_1;
    Texture tankImage_2;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    OrthographicCamera camera;

    private Tank tankPlayer1;
    private Tank tankPlayer2;
    private Player p1;
    private Player p2;


    public CustomisationMenu(TanksStars game) {
        this.game=game;
        backgroundImage = new Texture(Gdx.files.internal("CustomisationScreen.png"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1920, 1080);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);

        p1=new Player();
        p2=new Player();

        tankPlayer1=new TankType1();
        tankPlayer2=new TankType1();

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta)
    {
        ScreenUtils.clear(0, 0, 0, 0);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();

        game.batch.draw(backgroundTexture, 0,0, 1920, 1080);
        this.spawnTankPlayer1();
        this.spawnTankPlayer2();
        if (Gdx.input.getX()>70 && Gdx.input.getX()<134 && Gdx.input.getY()>490 && Gdx.input.getY()<600) {
            if(Gdx.input.isTouched())
            {
                changeTank(-1,1);
                try {
                    sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (Gdx.input.getX()>727 && Gdx.input.getX()<786 && Gdx.input.getY()>490 && Gdx.input.getY()<600) {
            if(Gdx.input.isTouched())
            {
                changeTank(1,1);
                try {
                    sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (Gdx.input.getX()>1090 && Gdx.input.getX()<1180 && Gdx.input.getY()>490 && Gdx.input.getY()<600) {
            if(Gdx.input.isTouched())
            {
                changeTank(-1,2);
                try {
                    sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (Gdx.input.getX()>1750 && Gdx.input.getX()<1850 && Gdx.input.getY()>490 && Gdx.input.getY()<600) {
            if(Gdx.input.isTouched())
            {
                changeTank(1,2);
                try {
                    sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        game.batch.end();

        if (Gdx.input.getX()>17 && Gdx.input.getX()<93 && Gdx.input.getY()>30 && Gdx.input.getY()<102) {
            if(Gdx.input.isTouched())
            {
                game.setScreen(new MainMenu(this.game));
                dispose();
            }
        }

        if (Gdx.input.getX()>601 && Gdx.input.getX()<1265 && Gdx.input.getY()>897 && Gdx.input.getY()<1048) {
            if(Gdx.input.isTouched())
            {
                p1.setTank(tankPlayer1);
                p2.setTank(tankPlayer2);
                game.setScreen(new GameScreen(this.game,p1,p2));
                dispose();
            }
        }
    }

    private void spawnTankPlayer1()
    {
        tankImage_1= new Texture(Gdx.files.internal(tankPlayer1.spawnTank()));
        Rectangle tankImage1 = new Rectangle();
        tankImage1.x = 10;
        tankImage1.y = 350;
        tankImage1.width = 416;
        tankImage1.height = 416;
        game.batch.draw(tankImage_1, tankImage1.x, tankImage1.y);
    }
    private void spawnTankPlayer2()
    {
        tankImage_2= new Texture(Gdx.files.internal(tankPlayer2.spawnTank()));
        Rectangle tankImage2 = new Rectangle();
        tankImage2.x = 1000;
        tankImage2.y = 350;
        tankImage2.width = 416;
        tankImage2.height = 416;
        game.batch.draw(tankImage_2, tankImage2.x, tankImage2.y);
    }

    private void changeTank(int direction,int player_no)
    {
        if(player_no==1)
        {
            if(direction==-1)
            {
                if(tankPlayer1.spawnTank().equals("type1.gif"))
                {
                    tankPlayer1=new TankType3();
                }
                else if(tankPlayer1.spawnTank().equals("type3.gif"))
                {
                    tankPlayer1=new TankType1();
                }
                else if(tankPlayer1.spawnTank().equals("type4.gif"))
                {
                    tankPlayer1=new TankType2();
                }
            }
            else
            {
                if(tankPlayer1.spawnTank().equals("type1.gif"))
                {
                    tankPlayer1=new TankType2();
                }
                else if(tankPlayer1.spawnTank().equals("type3.gif"))
                {
                    tankPlayer1=new TankType3();
                }
                else if(tankPlayer1.spawnTank().equals("type4.gif"))
                {
                    tankPlayer1=new TankType1();
                }
            }
        }
        else
        {
            if(direction==-1)
            {
                if(tankPlayer2.spawnTank().equals("type1.gif"))
                {
                    tankPlayer2=new TankType3();
                }
                else if(tankPlayer2.spawnTank().equals("type3.gif"))
                {
                    tankPlayer2=new TankType1();
                }
                else if(tankPlayer2.spawnTank().equals("type4.gif"))
                {
                    tankPlayer2=new TankType2();
                }
            }
            else
            {
                if(tankPlayer2.spawnTank().equals("type1.gif"))
                {
                    tankPlayer2=new TankType2();
                }
                else if(tankPlayer2.spawnTank().equals("type3.gif"))
                {
                    tankPlayer2=new TankType3();
                }
                else if(tankPlayer2.spawnTank().equals("type4.gif"))
                {
                    tankPlayer2=new TankType1();
                }
            }
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
