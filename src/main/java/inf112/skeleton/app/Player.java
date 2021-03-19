package inf112.skeleton.app;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;

import java.util.ArrayList;


public class Player {

    public Vector2 playerPos;
    public Vector2 checkPoint;
    public boolean loseCondition = false;
    public boolean winCondition = false;
    public int dir = 0; //take this in as a parameter
    public Cell playerCell;
    public Cell playerWonCell;
    public Cell playerDiedCell;
    public String playerTexture; //take this in as a parameter
    public int HP = 5;
    public int life = 3;
    //public ArrayList<String> visitedCheckPoints = new ArrayList<>();
    public ArrayList<Vector2> visitedCheckPoints = new ArrayList<>();

    public Player(Vector2 pos, String texture){
        this.playerPos = pos;
        this.checkPoint = pos;
        this.playerTexture = texture;
    }

    public void setTexture(String textureName){
        this.playerTexture = textureName;
    }

    public void addCheckPoint(){
        visitedCheckPoints.add(playerPos);
        this.checkPoint = playerPos;
    }

    public void setCheckPoint(Vector2 checkPoint){
        this.checkPoint = checkPoint;
    }

    public void move(Vector2 newPos){
        this.playerPos = newPos;
    }

    public void move(int x, int y){
        this.playerPos = new Vector2(x,y);
    }

    public Vector2 getPosition(){
        return playerPos;
    }

    public void setHP(int HP){
        this.HP = HP;
    }

    public void addLife(int val){
        life = life + val;
    }

    public int getLife(){
        return this.life;
    }

    public void setLife(int life){
        this.life=life;
    }

    public Vector2 getCheckPoint(){
        return checkPoint;
    }

    public boolean playerLost(){
        return loseCondition;
    }

    public boolean playerWon(){
        return winCondition;
    }

    public void setPlayerState(){
        if(!(playerTexture==null)) {
            // Split player.png into 3 textures
            Texture texture = new Texture(playerTexture);
            TextureRegion texturePlayer = new TextureRegion(texture);
            TextureRegion[][] texturePlayerSplit = texturePlayer.split(texture, RenderServer.widthPixels, RenderServer.heightPixels);

            // Get the textures for the different player states
            StaticTiledMapTile playerCellTile = new StaticTiledMapTile(texturePlayerSplit[0][0]);
            StaticTiledMapTile playerDiedCellTile = new StaticTiledMapTile(texturePlayerSplit[0][1]);
            StaticTiledMapTile playerWonTile = new StaticTiledMapTile(texturePlayerSplit[0][2]);

            // Create player states
            playerCell = new TiledMapTileLayer.Cell().setTile(playerCellTile);
            playerDiedCell = new TiledMapTileLayer.Cell().setTile(playerDiedCellTile);
            playerWonCell = new TiledMapTileLayer.Cell().setTile(playerWonTile);
        }
    }

    public void move(Enum ChosenMovement) {

        if(ChosenMovement == CardMovement.Movement.MOVE1
                || ChosenMovement == CardMovement.Movement.MOVE2
                || ChosenMovement == CardMovement.Movement.MOVE3
                || ChosenMovement == CardMovement.Movement.BACKUP){
            relocation(ChosenMovement);
        }
        else if(ChosenMovement == CardRotation.Rotation.ROTATERIGHT
                || ChosenMovement == CardRotation.Rotation.ROTATELEFT
                || ChosenMovement == CardRotation.Rotation.UTURN){
            rotate(ChosenMovement);
        }
    }

    public void rotate(Enum ChosenMovement){
        if (ChosenMovement == CardRotation.Rotation.ROTATERIGHT) {
            dir += 90;
        } else if (ChosenMovement == CardRotation.Rotation.ROTATELEFT) {
            dir += 270;
        } else if (ChosenMovement == CardRotation.Rotation.UTURN) {
            dir += 180;
        }
        dir = (dir % 360 + 360) % 360;
    }

    public void relocation(Enum ChosenMovement){
        int move = 0;
        if (ChosenMovement == CardMovement.Movement.MOVE1) {
            move = 1;
        } else if (ChosenMovement == CardMovement.Movement.MOVE2) {
            move = 2;
        } else if (ChosenMovement == CardMovement.Movement.MOVE3) {
            move = 3;
        } else if (ChosenMovement == CardMovement.Movement.BACKUP) {
            move = -1;
        }

        if(dir == 0){
            playerPos.y = playerPos.y + move;
        }
        else if(dir == 90){
            playerPos.x = playerPos.x + move;
        }
        else if(dir == 180){
            playerPos.y = playerPos.y - move;
        }
        else if(dir == 270){
            playerPos.x = playerPos.x - move;
        }
    }
}
