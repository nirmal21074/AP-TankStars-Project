package com.badlogic.TankStars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
public class MainMenu implements Screen {

    TanksStars game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    OrthographicCamera camera;

    public MainMenu(TanksStars game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("2.png"));
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

        if (Gdx.input.getX()>1249 && Gdx.input.getX()<1840 && Gdx.input.getY()>325 && Gdx.input.getY()<473) {
            if(Gdx.input.isTouched())
            {
                this.OpenNewGame();
            }
        }

        if (Gdx.input.getX()>1249 && Gdx.input.getX()<1840 && Gdx.input.getY()>575 && Gdx.input.getY()<726) {
            if(Gdx.input.isTouched())
            {
                this.OpenSavedGamesMenu();
            }
        }

        if (Gdx.input.getX()>1249 && Gdx.input.getX()<1840 && Gdx.input.getY()>836 && Gdx.input.getY()<974) {
            if(Gdx.input.isTouched())
            {
                this.ExitApplication();
            }
        }
    }

    public void OpenNewGame()
    {
        game.setScreen(new CustomisationMenu(this.game));
        dispose();
    }

    public void OpenSavedGamesMenu()
    {
        game.setScreen(new LoadSavedGamesScreen(this.game));
        dispose();
    }

    public void ExitApplication()
    {
        Gdx.app.exit();
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
