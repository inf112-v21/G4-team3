package inf112.skeleton.app.Menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import inf112.skeleton.app.Menu.Screens.MainMenu;

public class GameMenu extends Game {
    static public Skin gameSkin;

    @Override
    public void create() {
        gameSkin = new Skin(Gdx.files.internal("assets/MenuSkins/glassy/skin/glassy-ui.json"));
        this.setScreen(new MainMenu(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {

    }


}
