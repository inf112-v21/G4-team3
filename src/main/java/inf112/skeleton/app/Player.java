package inf112.skeleton.app;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;

import java.io.Serializable;


public class Player implements Serializable {
    public static final long serialVersionUID = 6529685098267757690L;


    public Vector2 playerPos = new Vector2(1,1);
    public boolean loseCondition = false;
    public boolean winCondition = false;
    public int dir = 0;


    public Player(Vector2 pos){
        this.playerPos = pos;
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
