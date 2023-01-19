package com.badlogic.TankStars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class PauseGameScreen implements Screen {

    TanksStars game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    OrthographicCamera camera;

    public PauseGameScreen(TanksStars game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("PauseGameScreen.png"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1880, 980);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1880, 980);
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
        game.batch.draw(backgroundTexture, 0,0, 1880, 980);
        game.batch.end();

        if (Gdx.input.getX()>660 && Gdx.input.getX()<1259 && Gdx.input.getY()>291 && Gdx.input.getY()<437) {
            if(Gdx.input.isTouched())
            {
                this.openGameScreen();
            }
        }

        if (Gdx.input.getX()>660 && Gdx.input.getX()<1259 && Gdx.input.getY()>541 && Gdx.input.getY()<695) {
            if(Gdx.input.isTouched())
            {
                this.exitToMainMenu();
            }
        }

        if (Gdx.input.getX()>660 && Gdx.input.getX()<1259 && Gdx.input.getY()>817 && Gdx.input.getY()<963) {
            if(Gdx.input.isTouched())
            {
                this.exitToMainMenu();
            }
        }
    }

    public void openGameScreen() {
        Player p1=new Player();
        Player p2=new Player();
        p1.setTank(new TankType2());
        p2.setTank(new TankType1());
        game.setScreen(new GameScreen(this.game,p1,p2));
        dispose();
    }

    public void exitToMainMenu()
    {
        game.setScreen(new MainMenu(this.game));
        dispose();
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
