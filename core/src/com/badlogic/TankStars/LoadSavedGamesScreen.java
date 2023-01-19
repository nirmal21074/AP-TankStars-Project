package com.badlogic.TankStars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class LoadSavedGamesScreen implements Screen {

    TanksStars game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    OrthographicCamera camera;

    public LoadSavedGamesScreen(TanksStars game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("SavedGamesScreen.png"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1920, 1080);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 0);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundTexture, 0,0, 1920, 1080);
        game.batch.end();

        if (Gdx.input.getX()>235 && Gdx.input.getX()<1523 && Gdx.input.getY()>290 && Gdx.input.getY()<431) {
            if(Gdx.input.isTouched())
            {
                Player p1=new Player();
                Player p2=new Player();
                p1.setTank(new TankType2());
                p2.setTank(new TankType1());

                game.setScreen(new GameScreen(this.game,p1,p2));
                dispose();
            }
        }

        if (Gdx.input.getX()>235 && Gdx.input.getX()<1523 && Gdx.input.getY()>480 && Gdx.input.getY()<623) {
            if(Gdx.input.isTouched())
            {
                Player p1=new Player();
                Player p2=new Player();
                p1.setTank(new TankType2());
                p2.setTank(new TankType1());
                game.setScreen(new GameScreen(this.game,p1,p2));
                dispose();
            }
        }

        if (Gdx.input.getX()>235 && Gdx.input.getX()<1523 && Gdx.input.getY()>680 && Gdx.input.getY()<820) {
            if(Gdx.input.isTouched())
            {
                Player p1=new Player();
                Player p2=new Player();
                p1.setTank(new TankType2());
                p2.setTank(new TankType1());
                game.setScreen(new GameScreen(this.game,p1,p2));
                dispose();
            }
        }

        if (Gdx.input.getX()>235 && Gdx.input.getX()<1523 && Gdx.input.getY()>878 && Gdx.input.getY()<1017) {
            if(Gdx.input.isTouched())
            {
                Player p1=new Player();
                Player p2=new Player();
                p1.setTank(new TankType2());
                p2.setTank(new TankType1());
                game.setScreen(new GameScreen(this.game,p1,p2));
                dispose();
            }
        }

        if (Gdx.input.getX()>0 && Gdx.input.getX()<130 && Gdx.input.getY()>0 && Gdx.input.getY()<130) {
            if(Gdx.input.isTouched())
            {
                game.setScreen(new MainMenu(this.game));
                dispose();
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
