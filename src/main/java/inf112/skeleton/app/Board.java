package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;

import javax.swing.*;


public class Board {

    // Layer variables
    public TiledMap map;
    public TiledMapTileLayer boardLayer;
    public TiledMapTileLayer playerLayer;
    public TiledMapTileLayer holeLayer;
    public TiledMapTileLayer flag1Layer;
    public TiledMapTileLayer flag2Layer;
    public TiledMapTileLayer flag3Layer;

    // Map size
    public int MAP_SIZE_X;
    public int MAP_SIZE_Y;

    // Create map layers
    public void createMap(){
        map = new TmxMapLoader().load("assets/Testmap2.tmx");
        boardLayer = (TiledMapTileLayer) map.getLayers().get("Board");
        playerLayer = (TiledMapTileLayer) map.getLayers().get("Player");
        holeLayer = (TiledMapTileLayer) map.getLayers().get("Hole");
        flag1Layer = (TiledMapTileLayer) map.getLayers().get("Flag1");
        flag2Layer = (TiledMapTileLayer) map.getLayers().get("Flag2");
        flag3Layer = (TiledMapTileLayer) map.getLayers().get("Flag3");
        MAP_SIZE_Y = boardLayer.getHeight();
        MAP_SIZE_X = boardLayer.getWidth();
    }

    // Check if player is positioned on the map
    public boolean validPlayerMapPos(Vector2 pos){
        boolean checkX = pos.x<MAP_SIZE_X && pos.x>=0;
        boolean checkY = pos.y<MAP_SIZE_Y && pos.y>=0;
        return checkX && checkY;
    }

    public void updatePlayer(Player player){

        // Checks if the player is on one of the layer types. Cell is null if player is not on the layer type
        Cell holeCell = holeLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
        //Cell flagCell = flagLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);

        //Cell test = holeLayer.setCell();

        // Rotate player sprite
        int rotation = getRotation(player);
        playerLayer.setCell((int) player.playerPos.x, (int) player.playerPos.y, player.playerCell.setRotation(rotation));

        //System.out.println("size"+holeCell);
        checkForCheckPoints(player);

        // Check if player is in a hole or is outside the map. If true removes a life.
        if (holeCell != null || !validPlayerMapPos(player.playerPos)) {
            player.addLife(-1);
            System.out.println(player.getLife());
            if (player.getLife()>0){
                System.out.println(player.checkPoint);
                player.move(player.checkPoint);
            }
        }

        if(player.getLife()==0){
            playerDied(player);
        }
    }

    public void checkForCheckPoints(Player player){
        if (player.visitedCheckPoints.size() == 0){
            Cell flag1Cell = flag1Layer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            if (flag1Cell != null) {
                player.addCheckPoint("CheckPoint1");
            }
        }

        else if (player.visitedCheckPoints.size() == 1){
            Cell flag2Cell = flag2Layer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            if (flag2Cell != null) {
                player.addCheckPoint("CheckPoint2");
            }
        }

        else if (player.visitedCheckPoints.size() == 2){
            Cell flag3Cell = flag3Layer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            if (flag3Cell != null) {
                player.addCheckPoint("CheckPoint3");
            }
        }
        // Check if player has reached all flags. If true ends the game.
        else if (player.visitedCheckPoints.size() == 3) {
            playerWon(player);
        }
    }

    public int getRotation(Player player){
        // Set the player on the layer depending on direction
        int rotation = 0;
        if (player.dir == 0){
            rotation = 0;
        } else if (player.dir == 270){
            rotation = 1;
        } else if (player.dir == 180){
            rotation = 2;
        } else if (player.dir == 90){
            rotation = 3;
        }
        return rotation;
    }

    public void playerDied(Player player){
        int rotation = getRotation(player);
        playerLayer.setCell((int) player.playerPos.x, (int) player.playerPos.y, player.playerDiedCell.setRotation(rotation));
        player.loseCondition = true;
    }

    public void playerWon(Player player){
        int rotation = getRotation(player);
        playerLayer.setCell((int) player.playerPos.x, (int) player.playerPos.y, player.playerWonCell.setRotation(rotation));
        player.winCondition = true;
    }
}
