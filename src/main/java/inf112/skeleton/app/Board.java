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
    public TiledMapTileLayer boardLayer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer playerLayer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer holeLayer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer flag1Layer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer flag2Layer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer flag3Layer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer laserLayer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer beltNorthLayer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer beltWestLayer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer beltSouthLayer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer beltEastLayer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer fixLayer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer extraLifeLayer = new TiledMapTileLayer(1,1,1,1);


    // Map size
    public int MAP_SIZE_X;
    public int MAP_SIZE_Y;

    // Create map layers
    public void createMap(){
        map = new TmxMapLoader().load("assets/Testmap4.tmx");
        boardLayer = (TiledMapTileLayer) map.getLayers().get("Board");
        playerLayer = (TiledMapTileLayer) map.getLayers().get("Player");
        holeLayer = (TiledMapTileLayer) map.getLayers().get("Hole");
        flag1Layer = (TiledMapTileLayer) map.getLayers().get("Flag1");
        flag2Layer = (TiledMapTileLayer) map.getLayers().get("Flag2");
        flag3Layer = (TiledMapTileLayer) map.getLayers().get("Flag3");
        laserLayer = (TiledMapTileLayer) map.getLayers().get("Laser");
        beltNorthLayer = (TiledMapTileLayer) map.getLayers().get("BeltNorth");
        beltWestLayer = (TiledMapTileLayer) map.getLayers().get("BeltWest");
        beltSouthLayer = (TiledMapTileLayer) map.getLayers().get("BeltSouth");
        beltEastLayer = (TiledMapTileLayer) map.getLayers().get("BeltEast");
        fixLayer = (TiledMapTileLayer) map.getLayers().get("Fix");
        extraLifeLayer = (TiledMapTileLayer) map.getLayers().get("ExtraLife");

        MAP_SIZE_Y = boardLayer.getHeight();
        MAP_SIZE_X = boardLayer.getWidth();
    }

    public void setSize(int x, int y){
        MAP_SIZE_Y = x;
        MAP_SIZE_X = y;

        boardLayer = new TiledMapTileLayer(x,y,1,1);
        playerLayer = new TiledMapTileLayer(x,y,1,1);
        holeLayer = new TiledMapTileLayer(x,y,1,1);
        flag1Layer = new TiledMapTileLayer(x,y,1,1);
        flag2Layer = new TiledMapTileLayer(x,y,1,1);
        flag3Layer = new TiledMapTileLayer(x,y,1,1);
        laserLayer = new TiledMapTileLayer(x,y,1,1);
        beltNorthLayer = new TiledMapTileLayer(x,y,1,1);
        beltWestLayer = new TiledMapTileLayer(x,y,1,1);
        beltSouthLayer = new TiledMapTileLayer(x,y,1,1);
        beltEastLayer = new TiledMapTileLayer(x,y,1,1);
        fixLayer = new TiledMapTileLayer(x,y,1,1);
        extraLifeLayer = new TiledMapTileLayer(x,y,1,1);

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

        // Rotate player sprite
        int rotation = getRotation(player);
        if (player.playerTexture != null) {
            playerLayer.setCell((int) player.playerPos.x, (int) player.playerPos.y, player.playerCell.setRotation(rotation));
        }

        // Do something depending on what tile the player is on
        checkForCheckPoints(player);
        checkLaser(player);
        loseLifeIfNoHP(player);
        beltMovement(player);
        fixer(player);
        extraLife(player);

        // Check if player is in a hole or is outside the map. If true removes a life.
        if (holeCell != null || !validPlayerMapPos(player.playerPos)) {
            player.addLife(-1);
            if (player.getLife()>0){
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
                player.addCheckPoint();
            }
        }
        else if (player.visitedCheckPoints.size() == 1){
            Cell flag2Cell = flag2Layer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            if (flag2Cell != null) {
                player.addCheckPoint();
            }
        }
        else if (player.visitedCheckPoints.size() == 2){
            Cell flag3Cell = flag3Layer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            if (flag3Cell != null) {
                player.addCheckPoint();
            }
        }
        // Check if player has reached all flags. If true ends the game.
        if (player.visitedCheckPoints.size() == 3) {
            playerWon(player);
        }
    }

    public void checkLaser(Player player){
        Cell laser = laserLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
        if (laser != null){
            player.addHP(-1);
        }
    }

    public void fixer(Player player){
        Cell fix = fixLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
        if (fix != null){
            player.setHP(player.getMaxHP());
        }
    }

    public void extraLife(Player player){
        Cell extraLife = fixLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
        if (extraLife != null){
            player.setLife(player.getLife() + 1);
        }
    }

    public void loseLifeIfNoHP(Player player){
        if (player.getCurrentHP() == 0){
            player.addLife(-1);
        }
    }

    public void beltMovement(Player player){
        Cell beltNorth = beltNorthLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
        Cell beltWest = beltWestLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
        Cell beltSouth = beltSouthLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
        Cell beltEast = beltEastLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
        int posX = (int)player.getPosition().x;
        int posY = (int)player.getPosition().y;

        if (beltNorth != null){
            player.move(posX, posY+1);
        }else if (beltWest != null){
            player.move(posX-1, posY);
        }else if (beltSouth != null){
            player.move(posX, posY-1);
        }else if (beltEast != null){
            player.move(posX+1, posY);
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
        if (player.playerTexture != null) {
            playerLayer.setCell((int) player.playerPos.x, (int) player.playerPos.y, player.playerDiedCell.setRotation(rotation));
        }
        player.loseCondition = true;
    }

    public void playerWon(Player player){
        int rotation = getRotation(player);
        if (player.playerTexture != null) {
            playerLayer.setCell((int) player.playerPos.x, (int) player.playerPos.y, player.playerWonCell.setRotation(rotation));
        }
        player.winCondition = true;
    }
}
