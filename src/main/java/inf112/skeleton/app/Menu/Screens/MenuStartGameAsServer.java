package inf112.skeleton.app.Menu.Screens;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import inf112.skeleton.app.Main;
import inf112.skeleton.app.Menu.GameMenu;
import inf112.skeleton.app.RenderServer;

public class MenuStartGameAsServer implements Screen {

    private Stage stage;
    private Game game;

    MenuStartGameAsServer(Game aGame) {
        game = aGame;
        stage = new Stage(new ScreenViewport());

        mainTitle();

        startButton();
        debugButton();
        backButton(aGame);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(.135f, .206f, .235f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {

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
        stage.dispose();
    }

    private void mainTitle() {
        Label title = new Label("Start game as server", GameMenu.gameSkin,"default");
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight()*2/3);
        title.setWidth(Gdx.graphics.getWidth());
        title.setFontScale(2, 2);
        stage.addActor(title);
    }

    private void startButton() {TextButton waitForIp = new TextButton("Start",GameMenu.gameSkin);
        waitForIp.setWidth(Gdx.graphics.getWidth()/2);
        waitForIp.setPosition(Gdx.graphics.getWidth()/2-waitForIp.getWidth()/2,Gdx.graphics.getHeight()/2-waitForIp.getHeight()/2);
        waitForIp.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
                cfg.setTitle("RobotRally");
                cfg.setWindowedMode(Main.finalWidth, Main.finalHeight);
                new Lwjgl3Application(new RenderServer(), cfg);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(waitForIp);
    }

    private void debugButton() {TextButton debugMode = new TextButton("Debug mode",GameMenu.gameSkin);
        debugMode.setWidth(Gdx.graphics.getWidth()/2);
        debugMode.setPosition(Gdx.graphics.getWidth()/2-debugMode.getWidth()/2,Gdx.graphics.getHeight()/4-debugMode.getHeight()/2);
        debugMode.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
                cfg.setTitle("RobotRally");
                cfg.setWindowedMode(Main.finalWidth, Main.finalHeight);
                new Lwjgl3Application(new RenderServer(), cfg);
                Main.debugmode = true;
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(debugMode);
    }

    private void backButton(Game aGame) {
        TextButton backButton = new TextButton("Back",GameMenu.gameSkin);
        backButton.setWidth(Gdx.graphics.getWidth()/2);
        backButton.setPosition(Gdx.graphics.getWidth()/2-backButton.getWidth()/2,75);
        backButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new MainMenu(aGame));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(backButton);
    }

}
