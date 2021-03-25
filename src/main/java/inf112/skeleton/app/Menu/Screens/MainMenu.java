package inf112.skeleton.app.Menu.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import inf112.skeleton.app.Menu.GameMenu;

public class MainMenu implements Screen {
    private Stage stage;
    private Game game;

    public MainMenu(Game aGame) {
        game = aGame;
        stage = new Stage(new ScreenViewport());

        mainTitle();

        clientButton(aGame);
        serverButton(aGame);
        singlePlayerButton(aGame);
        exitButton();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
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

    private void mainTitle(){
        Label title = new Label("Roborally", GameMenu.gameSkin,"default");
        title.setAlignment(Align.center);
        title.setY(800);
        title.setWidth(Gdx.graphics.getWidth());
        title.setFontScale(2, 2);
        stage.addActor(title);
    }

    private void clientButton(Game aGame) {
        TextButton startAsClient = new TextButton("Play as client",GameMenu.gameSkin);
        startAsClient.setWidth(Gdx.graphics.getWidth()/2);
        startAsClient.setPosition(Gdx.graphics.getWidth()/2-startAsClient.getWidth()/2,650);
        startAsClient.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new MenuStartGameAsClient(aGame));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(startAsClient);
    }

    private void serverButton(Game aGame) {
        TextButton optionsButton = new TextButton("Play as server",GameMenu.gameSkin);
        optionsButton.setWidth(Gdx.graphics.getWidth()/2);
        optionsButton.setPosition(Gdx.graphics.getWidth()/2-optionsButton.getWidth()/2,525);
        optionsButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new MenuStartGameAsServer(aGame));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(optionsButton);
    }

    private void singlePlayerButton(Game aGame) {
        TextButton TestAsSingleplayer = new TextButton("Test game",GameMenu.gameSkin);
        TestAsSingleplayer.setWidth(Gdx.graphics.getWidth()/2);
        TestAsSingleplayer.setPosition(Gdx.graphics.getWidth()/2-TestAsSingleplayer.getWidth()/2,400);
        TestAsSingleplayer.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new MenuTestAsSingleplayer(aGame));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(TestAsSingleplayer);
    }

    private void exitButton() {TextButton exitButton = new TextButton("Exit",GameMenu.gameSkin);
        exitButton.setWidth(Gdx.graphics.getWidth()/2);
        exitButton.setPosition(Gdx.graphics.getWidth()/2-exitButton.getWidth()/2,275);
        exitButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.exit(0);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(exitButton);
    }

}