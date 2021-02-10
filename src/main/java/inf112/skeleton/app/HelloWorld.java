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
import com.badlogic.gdx.math.Vector2;


public class HelloWorld extends InputAdapter implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;

    // Layer variables
    private TiledMap map;
    public TiledMapTileLayer boardLayer;
    public TiledMapTileLayer playerLayer;
    public TiledMapTileLayer holeLayer;
    public TiledMapTileLayer flagLayer;

    private OrthographicCamera camera;
    private OrthogonalTiledMapRenderer renderer;
    private final int MAP_SIZE_X = 5;
    private final int MAP_SIZE_Y = 5;
    private final int widthPixels = 300;
    private final int heightPixels = 300;

    // Displaying player
    public Cell playerCell;
    public Cell playerWonCell;
    public Cell playerDiedCell;
    public Vector2 playerPos = new Vector2(0,0);

    // End condition
    public boolean loseCondition = false;
    public boolean winCondition = false;

    // Pause
    public boolean pause = false;

    @Override
    public void create() {
        // Setup text
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);

        // Create map layers
        map = new TmxMapLoader().load("assets/Testmap.tmx");
        boardLayer = (TiledMapTileLayer) map.getLayers().get("Board");
        playerLayer = (TiledMapTileLayer) map.getLayers().get("Player");
        holeLayer = (TiledMapTileLayer) map.getLayers().get("Hole");
        flagLayer = (TiledMapTileLayer) map.getLayers().get("Flag");

        // Setup camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, MAP_SIZE_X, MAP_SIZE_Y);
        camera.position.x= MAP_SIZE_X/2f;
        camera.position.x= MAP_SIZE_Y/2f;
        camera.update();

        // Setup render
        renderer = new OrthogonalTiledMapRenderer(map, 1F/widthPixels);
        renderer.setView(camera);

        // Split player.png into 3 textures
        Texture texture = new Texture("assets/player.png");
        TextureRegion texturePlayer = new TextureRegion(texture);
        TextureRegion[][] tP = texturePlayer.split(texture,widthPixels,heightPixels);

        // Get the textures for the different player states
        StaticTiledMapTile playerCellTile = new StaticTiledMapTile(tP[0][0]);
        StaticTiledMapTile playerDiedCellTile = new StaticTiledMapTile(tP[0][1]);
        StaticTiledMapTile playerWonTile = new StaticTiledMapTile(tP[0][2]);

        // Create player states
        playerCell = new Cell().setTile(playerCellTile);
        playerDiedCell = new Cell().setTile(playerDiedCellTile);
        playerWonCell = new Cell().setTile(playerWonTile);

        // Get key input(?)
        Gdx.input.setInputProcessor(this);
    }

    // KeyUp
    @Override
    public boolean keyUp(int keyCode){

        if(!pause) {
            // -------- Placeholder movement --------
            // Using arrow keys
            playerLayer.setCell((int) playerPos.x, (int) playerPos.y, null); // Remove player sprite before moving
            // Move up
            if (keyCode == 19) {
                playerPos.y = playerPos.y + 1;
            }
            // Move down
            else if (keyCode == 20) {
                playerPos.y = playerPos.y - 1;
            }
            // Move left
            else if (keyCode == 22) {
                playerPos.x = playerPos.x + 1;
            }
            // Move right
            else if (keyCode == 21) {
                playerPos.x = playerPos.x - 1;
            }
        }
        // ------------------------------------------
        return true;
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
        updatePlayer();
    }

    // Check if player is positioned on the map
    public boolean validPlayerMapPos(Vector2 pos){
        boolean checkX = playerPos.x<MAP_SIZE_X && playerPos.x>=0;
        boolean checkY = playerPos.y<MAP_SIZE_Y && playerPos.y>=0;
        return checkX && checkY;
    }

    // Update the player based on the current map layer
    public void updatePlayer(){
        // Set the player on the layer
        playerLayer.setCell((int) playerPos.x, (int) playerPos.y, playerCell);

        // Checks if the player is on one of the layer types. Cell is null if player is not on the layer type
        Cell boardCell = boardLayer.getCell((int) playerPos.x, (int) playerPos.y);
        Cell holeCell = holeLayer.getCell((int) playerPos.x, (int) playerPos.y);
        Cell flagCell = flagLayer.getCell((int) playerPos.x, (int) playerPos.y);

        // Check if player is in a hole or is outside the map. If true ends the game.
        if (holeCell != null || !validPlayerMapPos(playerPos)) {
            playerLayer.setCell((int) playerPos.x, (int) playerPos.y, playerDiedCell);
            loseCondition = true;
            endGame();

            // End lose screen
            batch.begin();
            font.getData().setScale(4, 4);
            font.draw(batch, "You lost", 140, 200);
            batch.end();


        // Check if player has reached a flag. If true ends the game
        } else if (flagCell != null) {
            playerLayer.setCell((int) playerPos.x, (int) playerPos.y, playerWonCell);
            winCondition = true;
            endGame();

            // End win screen
            batch.begin();
            font.getData().setScale(4, 4);
            font.draw(batch, "You won", 140, 200);
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
}
