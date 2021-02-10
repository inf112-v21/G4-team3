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

    // Tutorial variables
    private TiledMap map;
    private TiledMapTileLayer boardLayer;
    private TiledMapTileLayer playerLayer;
    private TiledMapTileLayer holeLayer;
    private TiledMapTileLayer flagLayer;

    private OrthographicCamera camera;
    private OrthogonalTiledMapRenderer renderer;
    private int MAP_SIZE_X = 5;
    private int MAP_SIZE_Y = 5;
    private float widthPixels = 300;
    private float heightPixels = 300;

    // Displaying player
    private Cell playerCell;
    private Cell playerWonCell;
    private Cell playerDiedCell;
    private Vector2 playerPos = new Vector2(1,1);

    @Override
    public void create() {
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
        camera.position.x= 2.5F;
        camera.update();

        // Setup render
        renderer = new OrthogonalTiledMapRenderer(map, 1/300F);
        renderer.setView(camera);

        // Create textures for different player states
        Texture texture = new Texture("assets/player.png");
        TextureRegion texturePlayer = new TextureRegion(texture);
        TextureRegion[][] tP = texturePlayer.split(texture,300,300);

        StaticTiledMapTile playerCellTile = new StaticTiledMapTile(tP[0][0]);
        StaticTiledMapTile playerDiedCellTile = new StaticTiledMapTile(tP[0][1]);
        StaticTiledMapTile playerWonTile = new StaticTiledMapTile(tP[0][2]);

        // Create player states
        playerCell = new Cell().setTile(playerCellTile);
        playerDiedCell = new Cell().setTile(playerDiedCellTile);
        playerWonCell = new Cell().setTile(playerWonTile);

        // Start position
        playerPos.set(1,1);

        // Moving player
        Gdx.input.setInputProcessor(this);
    }

    // KeyUp
    @Override
    public boolean keyUp(int keyCode){

        // Placeholder ----
        playerLayer.setCell((int)playerPos.x, (int)playerPos.y, null);
        if (keyCode == 19){
            playerPos.y = playerPos.y + 1;
        }
        else if (keyCode == 20){
            playerPos.y = playerPos.y - 1;
        }
        else if (keyCode == 22){
            playerPos.x = playerPos.x + 1;
        }
        else if (keyCode == 21){
            playerPos.x = playerPos.x - 1;
        }
        // ------

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

        // Check player cell layer position
        playerLayer.setCell((int)playerPos.x,(int)playerPos.y,playerCell);
        Cell bl = boardLayer.getCell((int)playerPos.x,(int)playerPos.y);
        Cell hl = holeLayer.getCell((int)playerPos.x,(int)playerPos.y);
        Cell fl = flagLayer.getCell((int)playerPos.x,(int)playerPos.y);

        if (bl != null){
            if (hl != null){
                playerLayer.setCell((int)playerPos.x,(int)playerPos.y,playerDiedCell);
            }
            else if (fl != null){
                playerLayer.setCell((int)playerPos.x,(int)playerPos.y,playerWonCell);
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




}
