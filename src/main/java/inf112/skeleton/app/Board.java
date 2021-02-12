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

import static inf112.skeleton.app.Player.playerPos;

public class Board {

    // Layer variables
    public static TiledMap map;
    public static TiledMapTileLayer boardLayer;
    public static TiledMapTileLayer playerLayer;
    public static TiledMapTileLayer holeLayer;
    public static TiledMapTileLayer flagLayer;

    // Map size
    public static int MAP_SIZE_X = 5;
    public static int MAP_SIZE_Y = 5;

    // Create map layers
    public static void createMap(){
        map = new TmxMapLoader().load("assets/Testmap.tmx");
        boardLayer = (TiledMapTileLayer) map.getLayers().get("Board");
        playerLayer = (TiledMapTileLayer) map.getLayers().get("Player");
        holeLayer = (TiledMapTileLayer) map.getLayers().get("Hole");
        flagLayer = (TiledMapTileLayer) map.getLayers().get("Flag");
    }

    // Check if player is positioned on the map
    public static boolean validPlayerMapPos(Vector2 pos){
        boolean checkX = pos.x<Board.MAP_SIZE_X && pos.x>=0;
        boolean checkY = pos.y<Board.MAP_SIZE_Y && pos.y>=0;
        return checkX && checkY;
    }

    public void updatePlayer(Player player){
        // Set the player on the layer
        playerLayer.setCell((int) player.playerPos.x, (int) player.playerPos.y, player.playerCell);

        // Checks if the player is on one of the layer types. Cell is null if player is not on the layer type
        Cell boardCell = boardLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
        Cell holeCell = holeLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
        Cell flagCell = flagLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);

        // Check if player is in a hole or is outside the map. If true ends the game.
        if (holeCell != null || !validPlayerMapPos(player.playerPos)) {
            playerLayer.setCell((int) player.playerPos.x, (int) player.playerPos.y, player.playerDiedCell);
            player.loseCondition = true;

            // Check if player has reached a flag. If true ends the game.
        } else if (flagCell != null) {
            playerLayer.setCell((int) player.playerPos.x, (int) player.playerPos.y, player.playerWonCell);
            player.winCondition = true;
        }
    }
}
