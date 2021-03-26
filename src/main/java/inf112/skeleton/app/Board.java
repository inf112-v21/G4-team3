package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    public TiledMapTileLayer wallNorthLayer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer wallWestLayer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer wallEastLayer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer wallSouthLayer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer wallNorthEastLayer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer wallNorthWestLayer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer wallSouthEastLayer = new TiledMapTileLayer(1,1,1,1);
    public TiledMapTileLayer wallSouthWestLayer = new TiledMapTileLayer(1,1,1,1);
    public List<String> layerNames;
    public List<TiledMapTileLayer> layerObjects;

    // Map size
    public int MAP_SIZE_X;
    public int MAP_SIZE_Y;

    public Player player;



    public void addLayers(){
        layerNames = Arrays.asList("Board", "Player", "Hole", "Flag1", "Flag2", "Flag3", "Laser",
                "BeltNorth", "BeltWest", "BeltSouth", "BeltEast", "Fix", "ExtraLife");
        layerObjects = Arrays.asList(boardLayer, playerLayer, holeLayer, flag1Layer, flag2Layer,
                flag3Layer, laserLayer, beltNorthLayer, beltWestLayer, beltSouthLayer, beltEastLayer,
                fixLayer, extraLifeLayer);
    }

    // Create map layers
    public void createMap(){
        map = new TmxMapLoader().load("assets/Testmap4.tmx");

        /*
        addLayers();
        int nLayers = layerObjects.size();
        //TiledMapTileLayer layer2;
        for (int i=0; i<nLayers; i++){
        //for(TiledMapTileLayer layer : layerObjects)
            TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(layerNames.get(i));
            TiledMapTileLayer layer2 = layerObjects.get(i);
            //layerObjects.set(i, layer);
            layer2 = layer;
            //layerNames.get(i) = "das";
            //layerObjects.get(i) = new TiledMapTileLayer(1,1,1,1);
            System.out.println(layerObjects.get(i));
            //layerObjects.get(i) = (TiledMapTileLayer) map.getLayers().get(layerNames.get(i));
            //layer = (TiledMapTileLayer) map.getLayers().get(layerNames.get(i));
        }
         */

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
        wallNorthLayer = (TiledMapTileLayer) map.getLayers().get("WallNorth");
        wallWestLayer = (TiledMapTileLayer) map.getLayers().get("WallWest");
        wallSouthLayer = (TiledMapTileLayer) map.getLayers().get("WallSouth");
        wallEastLayer = (TiledMapTileLayer) map.getLayers().get("WallEast");
        wallNorthEastLayer = (TiledMapTileLayer) map.getLayers().get("WallNorthEast");
        wallNorthWestLayer = (TiledMapTileLayer) map.getLayers().get("WallNorthWest");
        wallSouthEastLayer = (TiledMapTileLayer) map.getLayers().get("WallSouthEast");
        wallSouthWestLayer = (TiledMapTileLayer) map.getLayers().get("WallSouthWest");

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
        wallNorthLayer = new TiledMapTileLayer(x,y,1,1);
        wallWestLayer = new TiledMapTileLayer(x,y,1,1);
        wallEastLayer = new TiledMapTileLayer(x,y,1,1);
        wallSouthLayer = new TiledMapTileLayer(x,y,1,1);
        wallNorthEastLayer = new TiledMapTileLayer(x,y,1,1);
        wallNorthWestLayer = new TiledMapTileLayer(x,y,1,1);
        wallSouthEastLayer = new TiledMapTileLayer(x,y,1,1);
        wallSouthWestLayer = new TiledMapTileLayer(x,y,1,1);
    }

    // Check if player is positioned on the map
    public boolean validPlayerMapPos(Vector2 pos){
        boolean checkX = pos.x<MAP_SIZE_X && pos.x>=0;
        boolean checkY = pos.y<MAP_SIZE_Y && pos.y>=0;
        return checkX && checkY;
    }

    public void updateBoard(Player player){
        this.player = player;

        // Do something depending on what tile the player is on
        // Game order:
        // 1. Player action
        updatePlayer();

        // 2. Board movement
        checkBeltMovement();
        checkPlayerOnMapOrInHole();

        // 3. Laser
        checkLaser();

        // 4. Rest of board elements
        checkFixer();
        checkExtraLife();
        checkLoseLifeIfNoHP();
        checkForCheckPoints();
        checkIfPlayerLost();

        System.out.println("Current HP: "+player.getCurrentHP());
        System.out.println("Lives: "+player.getLife());
    }

    public int getRotation(){
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

    private void updatePlayer() {
        if (player.playerTexture != null) {
            try {
                TimeUnit.SECONDS.sleep((long)0.8);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Rotate player sprite
        int rotation = getRotation();
        if (player.playerTexture != null) {
            playerLayer.setCell((int) player.playerPos.x, (int) player.playerPos.y, player.playerCell.setRotation(rotation));
        }
    }

    public void deletePlayerTexture(Player player){
        if (player.playerTexture != null){
            // Delete previous player texture
            playerLayer.setCell((int) player.playerPos.x, (int) player.playerPos.y, null);
        }
    }

    private void checkPlayerOnMapOrInHole() {
        // Checks if the player is on one of the layer types. Cell is null if player is not on the layer type
        Cell holeCell = holeLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);

        // Check if player is in a hole or is outside the map. If true removes a life.
        if (holeCell != null || !validPlayerMapPos(player.playerPos)) {
            player.addLife(-1);
            if (player.getLife()>0){
                playerLostLifeActions();
            }
        }
    }

    private void playerLostLifeActions(){
        deletePlayerTexture(player);
        setRestOfCardsToNull();
        player.move((int)player.getCheckPoint().x, (int)player.getCheckPoint().y);
        player.setHP(player.getMaxHP());
        player.dir = player.orgDir;
        updatePlayer();
    }

    private void setRestOfCardsToNull(){
        int n = player.getCurrentCards().size();
        for(int i=0; i<n; i++){
            player.pickedCards.set(i,null);
        }
    }

    private void checkIfPlayerLost() {
        if(player.getLife()==0){
            playerDied();
        }
    }

    private void checkForCheckPoints(){
        if (player.visitedCheckPoints.size() == 0){
            Cell flag1Cell = flag1Layer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            if (flag1Cell != null) {
                player.addCheckPoint(player.getPosition());
            }
        }
        else if (player.visitedCheckPoints.size() == 1){
            Cell flag2Cell = flag2Layer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            if (flag2Cell != null) {
                player.addCheckPoint(player.getPosition());
            }
        }
        else if (player.visitedCheckPoints.size() == 2){
            Cell flag3Cell = flag3Layer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            if (flag3Cell != null) {
                player.addCheckPoint(player.getPosition());
            }
        }
        // Check if player has reached all flags. If true ends the game.
        if (player.visitedCheckPoints.size() == 3) {
            playerWon(player);
        }
    }

    private void checkLaser(){
        Cell laser = laserLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
        if (laser != null){
            player.addHP(-1);
        }
    }

    private void checkFixer(){
        Cell fix = fixLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
        if (fix != null){
            player.setHP(player.getMaxHP());
        }
    }

    private void checkExtraLife(){
        Cell extraLife = fixLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
        if (extraLife != null){
            player.setLife(player.getLife() + 1);
        }
    }

    private void checkLoseLifeIfNoHP(){
        if (player.getCurrentHP() == 0){
            player.addLife(-1);
            playerLostLifeActions();
        }
    }

    private void checkBeltMovement(){
        Cell beltNorth = beltNorthLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
        Cell beltWest = beltWestLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
        Cell beltSouth = beltSouthLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
        Cell beltEast = beltEastLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
        int posX = (int)player.getPosition().x;
        int posY = (int)player.getPosition().y;

        if (beltNorth != null){
            deletePlayerTexture(player);
            player.move(posX, posY+1);
            updatePlayer();
        }else if (beltWest != null){
            deletePlayerTexture(player);
            player.move(posX-1, posY);
            updatePlayer();
        }else if (beltSouth != null){
            deletePlayerTexture(player);
            player.move(posX, posY-1);
            updatePlayer();
        }else if (beltEast != null){
            deletePlayerTexture(player);
            player.move(posX+1, posY);
            updatePlayer();
        }
    }

    private void playerDied(){
        if (player.playerTexture != null) {
            int rotation = getRotation();
            playerLayer.setCell((int) player.playerPos.x, (int) player.playerPos.y, player.playerDiedCell.setRotation(rotation));
        }
        player.loseCondition = true;
    }

    private void playerWon(Player player){
        if (player.playerTexture != null) {
            int rotation = getRotation();
            playerLayer.setCell((int) player.playerPos.x, (int) player.playerPos.y, player.playerWonCell.setRotation(rotation));
        }
        player.winCondition = true;
    }

    public boolean canGo(Player player){
        int dir = player.dir;
        boolean cango = true;
        if(dir == 0){
            Cell wallNorth = wallNorthLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            Cell wallNorthEast = wallNorthLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            Cell wallNorthWest = wallWestLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            Cell wallSouth = wallSouthLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y + 1);
            Cell wallSouthEast = wallSouthLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y + 1);
            Cell wallSouthWest = wallEastLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y + 1);
            System.out.println(wallNorth);
            System.out.println(wallNorthWest);
            if(wallSouthWest != null ||
                    wallNorth != null ||
                    wallNorthEast != null ||
                    wallNorthWest != null ||
                    wallSouthEast != null ||
                    wallSouth != null){
                cango = false;
            }
        }
        else if(dir == 90){
            Cell wallEast = wallEastLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            Cell wallNorthEast = wallNorthLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            Cell wallNorthWest = wallWestLayer.getCell((int) player.playerPos.x +1 , (int) player.playerPos.y);
            Cell wallWest = wallWestLayer.getCell((int) player.playerPos.x + 1, (int) player.playerPos.y);
            Cell wallSouthEast = wallSouthLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            Cell wallSouthWest = wallEastLayer.getCell((int) player.playerPos.x + 1, (int) player.playerPos.y);
            if(wallSouthWest != null ||
                    wallEast != null ||
                    wallNorthEast != null ||
                    wallNorthWest != null ||
                    wallSouthEast != null ||
                    wallWest != null){
                cango = false;
            }
        }
        else if(dir == 180){
            Cell wallNorth = wallNorthLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y - 1);
            Cell wallNorthEast = wallNorthLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y - 1);
            Cell wallNorthWest = wallWestLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y - 1);
            Cell wallSouth = wallSouthLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            Cell wallSouthEast = wallSouthLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            Cell wallSouthWest = wallEastLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            if(wallSouthWest != null ||
                    wallNorth != null ||
                    wallNorthEast != null ||
                    wallNorthWest != null ||
                    wallSouthEast != null ||
                    wallSouth != null){
                cango = false;
            }
        }
        else if(dir == 270){
            Cell wallEast = wallEastLayer.getCell((int) player.playerPos.x - 1 , (int) player.playerPos.y);
            Cell wallNorthEast = wallNorthLayer.getCell((int) player.playerPos.x - 1, (int) player.playerPos.y);
            Cell wallNorthWest = wallWestLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            Cell wallWest = wallWestLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            Cell wallSouthEast = wallSouthLayer.getCell((int) player.playerPos.x - 1, (int) player.playerPos.y);
            Cell wallSouthWest = wallEastLayer.getCell((int) player.playerPos.x, (int) player.playerPos.y);
            if(wallSouthWest != null ||
                    wallEast != null ||
                    wallNorthEast != null ||
                    wallNorthWest != null ||
                    wallSouthEast != null ||
                    wallWest != null){
                cango = false;
            }
        }
        //System.out.println("dir" + player.dir);
        //System.out.println("x:" +(int) player.playerPos.x + "y:" + (int) player.playerPos.y);
        //System.out.println(cango);
        return cango;
    }
}
