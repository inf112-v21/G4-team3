package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;


public class Board {

    // Layer variables
    public static TiledMap map;
    public static TiledMapTileLayer boardLayer;
    public static TiledMapTileLayer playerLayer;
    public static TiledMapTileLayer holeLayer;
    public static TiledMapTileLayer flagLayer;

    // Map size
    public static int MAP_SIZE_X;
    public static int MAP_SIZE_Y;

    // Create map layers
    public static void createMap(){
        map = new TmxMapLoader().load("assets/Testmap.tmx");
        boardLayer = (TiledMapTileLayer) map.getLayers().get("Board");
        playerLayer = (TiledMapTileLayer) map.getLayers().get("Player");
        holeLayer = (TiledMapTileLayer) map.getLayers().get("Hole");
        flagLayer = (TiledMapTileLayer) map.getLayers().get("Flag");
        MAP_SIZE_X = boardLayer.getHeight();
        MAP_SIZE_Y = boardLayer.getWidth();
    }

    // Check if player is positioned on the map
    public static boolean validPlayerMapPos(Vector2 pos){
        boolean checkX = pos.x<Board.MAP_SIZE_X && pos.x>=0;
        boolean checkY = pos.y<Board.MAP_SIZE_Y && pos.y>=0;
        return checkX && checkY;
    }

    public void updatePlayer(Player player){
        // Checks if the player is on one of the layer types. Cell is null if player is not on the layer type
        Cell holeCell = holeLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
        Cell flagCell = flagLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);

        // Set the player on the layer depending on direction
        int rotation = 0;
        if (player.dir == "North"){
            rotation = 0;
        } else if (player.dir == "West"){
            rotation = 1;
        } else if (player.dir == "South"){
            rotation = 2;
        } else if (player.dir == "East"){
            rotation = 3;
        }
        playerLayer.setCell((int) player.playerPos.x, (int) player.playerPos.y, player.playerCell.setRotation(rotation));

        // Check if player is in a hole or is outside the map. If true ends the game.
        if (holeCell != null || !validPlayerMapPos(player.playerPos)) {
            playerLayer.setCell((int) player.playerPos.x, (int) player.playerPos.y, player.playerDiedCell.setRotation(rotation));
            player.loseCondition = true;

            // Check if player has reached a flag. If true ends the game.
        } else if (flagCell != null) {
            playerLayer.setCell((int) player.playerPos.x, (int) player.playerPos.y, player.playerWonCell.setRotation(rotation));
            player.winCondition = true;
        }
    }
}
