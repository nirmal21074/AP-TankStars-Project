package com.badlogic.TankStars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.io.Serializable;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class GameScreen implements Screen, Serializable
{
    TanksStars game;
    private Texture backgroundImage;
    private Texture surfaceImage;
    private Texture shooterImage;
    private Texture shooterImage2;
    private Texture tank1_Image;
    private Texture tank2_Image;
    private Texture missile_Image;
    private ShapeRenderer shape1;
    private int[][] surfaceArray;
    private TextureRegion backgroundTexture;
    private Player p1;
    private Player p2;
    OrthographicCamera camera;
    private Rectangle tank1;
    private Rectangle tank2;
    private Rectangle healthbar1;
    private Rectangle healthbar2;
    private Rectangle shooter1;
    private Rectangle shooter2;
    private Rectangle Tile;
    private Rectangle missile;
    private boolean turn;
    private Rectangle TankRectangle;
    private Player playerTurn;
    private Tank TankInOperation;
    private int power;
    private int final_x;
    private int final_y;

//    public GameScreen_1(TanksStars game) {
//        this.game = game;
//        backgroundImage = new Texture(Gdx.files.internal("GameScreen.png"));
//        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1880, 980);
//        camera = new OrthographicCamera();
//        camera.setToOrtho(false, 1880, 980);
//        surfaceArray=new Rectangle[10][40];
//        shape1= new ShapeRenderer();
//        shape2= new ShapeRenderer();
//    }
    public GameScreen(TanksStars game, Player p_1, Player p_2)
    {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("GameScreen.png"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1880, 980);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1880, 980);
        shape1= new ShapeRenderer(); // for drawing shapes!

        //MAKING SURFACE ARRAY
        surfaceArray=new int[10][40];
        for(int i=0; i<10; i++)
        {
            for(int j=0; j<40; j++)
            {
                surfaceArray[i][j]=1; // HERE i is the vertical tile and j is horizontal tile
            }
        }

//        for(int i=0; i<4; i++)
//        {
//            for(int j=0; j<20; j++)
//            {
//                surfaceArray[i][j]=0;
//            }
//        }

        // MAKING ELEMENTS FOR THE GAMESCREEN
        shooter1=new Rectangle();
        shooter2=new Rectangle();
        tank1=new Rectangle();
        tank2=new Rectangle();
        healthbar1=new Rectangle();
        healthbar2=new Rectangle();
        missile=new Rectangle();

        Tile = new Rectangle();
        surfaceImage=new Texture(Gdx.files.internal("Tile.png"));

        // MAKING PLAYERS FOR THE GAME
        p1=p_1;
        p2=p_2;

        // SETTING POSITIONS OF TANK AND SHOOTER WHEN THE GAME SCREEN JUST OPENS
        tank1.x=343;
        tank1.y=1080-675;
        tank1.width=200;
        tank1.height=143;

        tank2.x=1920-343;
        tank2.y=1080-675;
        tank2.width=200;
        tank2.height=143;

        shooter1.x=450;
        shooter1.y=1080-650;
        shooter1.width=267;
        shooter1.height=249;

        shooter2.x=1300;
        shooter2.y=1080-650;
        shooter2.width=267;
        shooter2.height=249;

        p1.setPos("onground");
        p2.setPos("onground");

        // SET TURN OF PLAYER 1 AND 2 BY VARIABLE 'turn'-> true or false and playerTurn storing p1 or p2.
        turn=true;
        playerTurn=p1;
        TankRectangle=tank1;

//        missile.x=960;
//        missile.y=700;


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
        shape1.setProjectionMatrix(camera.combined);

        shape1.begin(ShapeRenderer.ShapeType.Filled);
        game.batch.begin();
        game.batch.draw(backgroundTexture, 0,0, 1880, 980);

        spawnTank1();
        spawnTank2();
        spawnShooter();
        spawnSurface();
        //spawnMissile();
        spawnHealthBarPlayer1();

        game.batch.end();
        shape1.end();

        if (Gdx.input.getX()>37 && Gdx.input.getX()<113 && Gdx.input.getY()>34 && Gdx.input.getY()<99)
        {
            if(Gdx.input.isTouched())
            {
                this.OpenPauseGameScreen();
            }
        }

        if(hasTile((int)(TankRectangle.x+TankRectangle.width+48),(int)TankRectangle.y)==1 && playerTurn.getPos().equals("onground"))
        {
            playerTurn.setPos("uphill");
        }

        if(playerTurn.getPos().equals("uphill")&&hasTile((int) TankRectangle.getX(), (int) TankRectangle.y)==-1)
        {
            playerTurn.setPos("onground");
        }

        if(Gdx.input.isKeyPressed(22))
        {
            if(TankRectangle.x>0 && TankRectangle.x<(1920-TankRectangle.width))
            {
                if(playerTurn.getPos().equals("uphill"))
                {
                    TankRectangle.y+=5+Gdx.graphics.getDeltaTime();
                }
                else if(playerTurn.getPos().equals("onground"))
                {
                    TankRectangle.x+=5+Gdx.graphics.getDeltaTime();
                }
            }
            else
            {
                TankRectangle.x-=20;
            }
        }
        if(Gdx.input.isKeyPressed(21))
        {
            if(TankRectangle.x>0 && TankRectangle.x<(1920-TankRectangle.width))
            {
                if(playerTurn.getPos().equals("downhill"))
                {
                    TankRectangle.y-=5+Gdx.graphics.getDeltaTime();
                }
                else if(playerTurn.getPos().equals("onground"))
                {
                    TankRectangle.x-=5+Gdx.graphics.getDeltaTime();
                }
            }
            else
            {
                TankRectangle.x+=20;
            }
        }

        if(Gdx.input.isKeyPressed(66))
        {
            if(turn==true)
            {
                playerTurn=p2;
                TankRectangle=tank2;
                turn=false;
            }
            else
            {
                playerTurn=p1;
                TankRectangle=tank1;
                turn=true;
            }
            launchProjectile(TankRectangle,final_x,final_y,turn);
            try
            {
                sleep(400);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            if(turn==true)
            {
                playerTurn=p2;
                TankRectangle=tank2;
                turn=false;
            }
            else
            {
                playerTurn=p1;
                TankRectangle=tank1;
                turn=true;
            }
        }

    }

    public void OpenPauseGameScreen()
    {
        game.setScreen(new PauseGameScreen(this.game));
        dispose();
    }

    public void moveTank()
    {

    }

    public void calculateProjectile(Rectangle r)
    {

    }

    public void launchProjectile(Rectangle r,float final_x,float final_y,boolean direction)// left -> 0 and right -> 1
    {
        missile.x=r.x;
        missile.y=r.y;
        if(direction==false)
        {
            while(missile.x>=final_x && missile.y>=final_y)
            {
                if(missile.x>final_x)
                {
                    missile.x+=100*Gdx.graphics.getDeltaTime();
                }
                if(missile.y>final_y)
                {
                    missile.y+=100*Gdx.graphics.getDeltaTime();
                }

                game.batch.begin();
                spawnMissile();
                game.batch.end();
            }
        }
        else
        {
            while(missile.x<=final_x && missile.y<=final_y)
            {
                if(missile.x<final_x)
                {
                    missile.x+=100*Gdx.graphics.getDeltaTime();
                }
                if(missile.y<final_y)
                {
                    missile.y+=100*Gdx.graphics.getDeltaTime();
                }

                game.batch.begin();
                spawnMissile();
                game.batch.end();
            }
        }
    }

    public void spawnMissile()
    {
        missile_Image = new Texture(Gdx.files.internal("unnamed.png"));
        game.batch.draw(missile_Image,missile.x,missile.y);
    }

    public void spawnTank1()
    {
        if(hasTile((int)(tank1.x-10),(int)(tank1.y-100))==-1)
        {
            tank1.y-=48;
        }
        if(p1.getPos().equals("uphill")&&hasTile((int)(tank1.x+tank1.height),(int)(tank1.y-tank1.width))==-1)
        {
            p1.setPos("onground");
        }

        if(p1.getPos().equals("uphill"))
        {
            tank1_Image = new Texture(Gdx.files.internal(p1.getTank().spawnVerticalTank_1()));
        }
        else
        {
            tank1_Image = new Texture(Gdx.files.internal(p1.getTank().spawnTankinGame_1()));
        }
        game.batch.draw(tank1_Image, tank1.x, tank1.y);
    }

    public void spawnTank2()
    {
        if(hasTile((int)(tank2.x-10),(int)(tank2.y-100))==-1)
        {
            tank2.y-=48;
        }
        if(p2.getPos().equals("uphill")&&hasTile((int)(tank2.x+tank2.height),(int)(tank2.y-tank2.width))==-1)
        {
            p2.setPos("onground");
        }

        if(p2.getPos().equals("uphill"))
        {
            tank2_Image = new Texture(Gdx.files.internal(p2.getTank().spawnVerticalTank_2()));
        }
        else
        {
            tank2_Image = new Texture(Gdx.files.internal(p2.getTank().spawnTankinGame_2()));
        }
        game.batch.draw(tank2_Image,tank2.x,tank2.y);
    }

    public void spawnSurface()
    {
        for(int i=0; i<1920; i+=48)
        {
            for(int j=384; j>=0; j-=48)
            {
                if(surfaceArray[(384-j)/48][(i/48)]==1)
                {
                    Tile.x = i;
                    Tile.y = j;
                    Tile.width = 48;
                    Tile.height = 48;
                    game.batch.draw(surfaceImage, Tile.x, Tile.y);
                }
            }
        }
    }

    public void spawnShooter()
    {
        shooterImage = new Texture(Gdx.files.internal("shooter.png"));
        Rectangle shooter = new Rectangle();
        shooter.x = 450;
        shooter.y = 1080-650;
        shooter.width = 267;
        shooter.height = 249;
        game.batch.draw(shooterImage, shooter.x, shooter.y);
        shooterImage2 = new Texture(Gdx.files.internal("shooter_player2.png"));
        shooter.x = 1300;
        shooter.y = 1080-650;
        shooter.width = 267;
        shooter.height = 249;
        game.batch.draw(shooterImage2, shooter.x, shooter.y);
    }

    public void spawnHealthBarPlayer1()
    {
        shape1.setColor(Color.PURPLE);
        shape1.rect(302,900,500,60);
        shape1.setColor(Color.PURPLE);
        shape1.rect(1200,900,500,60);
    }

    public int hasTile(int x,int y)
    {
        try
        {
            if(surfaceArray[(384-y)/48][x/48]==1)
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
        catch(Exception e)
        {
            return -1;
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
