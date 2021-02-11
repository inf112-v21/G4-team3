package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

import static inf112.skeleton.app.Board.flagLayer;
import static inf112.skeleton.app.Board.playerLayer;
import static inf112.skeleton.app.Player.playerPos;


public class Render extends InputAdapter implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;

    // Displaying player
    private OrthographicCamera camera;
    private OrthogonalTiledMapRenderer renderer;
    public static final int widthPixels = 300;
    public static final int heightPixels = 300;

    public boolean pause = false;

    public Player player = new Player();
    public Board board = new Board();

    @Override
    public void create() {
        // Setup text
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);

        // Load in map layers from tmx file
        board.createMap();

        // Setup camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, board.MAP_SIZE_X, board.MAP_SIZE_Y);
        camera.position.x= board.MAP_SIZE_X/2f;
        camera.position.x= board.MAP_SIZE_Y/2f;
        camera.update();

        // Setup render
        renderer = new OrthogonalTiledMapRenderer(board.map, 1F/widthPixels);
        renderer.setView(camera);

        // Setup player cell states, including textures
        player.setPlayerState();

        // Get key input
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        renderer.render();
        board.updatePlayer();

        if (player.winCondition){
            endGame();
            // End win screen
            batch.begin();
            font.getData().setScale(4, 4);
            font.draw(batch, "You won", 140, 250);
            batch.end();
        }

        else if (player.loseCondition){
            endGame();
            // End lose screen
            batch.begin();
            font.getData().setScale(4, 4);
            font.draw(batch, "You lost", 140, 250);
            batch.end();
        }
    }

    public void endGame(){
        pause = true;
    }
    @Override
    public void resize(int width, int height) {
    }
    @Override
    public void pause() {
        pause = true;
    }
    @Override
    public void resume() {
        pause = false;
    }
    @Override
    public boolean keyUp(int keyCode){
        // Remove player sprite before moving
        playerLayer.setCell((int) playerPos.x, (int) playerPos.y, null);

        String direction = "none";
        // Move up
        if (keyCode == 19) {
            direction = "up";
        }
        // Move down
        else if (keyCode == 20) {
            direction = "down";
        }
        // Move left
        else if (keyCode == 22) {
            direction = "right";
        }
        // Move right
        else if (keyCode == 21) {
            direction = "left";
        }

        if(!pause) {
            player.move(direction);
        }
        return true;
    }
}
