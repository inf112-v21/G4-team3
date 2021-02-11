package inf112.skeleton.app;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;

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

import static inf112.skeleton.app.Board.playerLayer;

public class Player{

    public static Vector2 playerPos = new Vector2(0,0);
    public static boolean loseCondition = false;
    public static boolean winCondition = false;
    public static Cell playerCell;
    public static Cell playerWonCell;
    public static Cell playerDiedCell;

    // Check if player is positioned on the map
    public static boolean validPlayerMapPos(Vector2 pos){
        boolean checkX = playerPos.x<Board.MAP_SIZE_X && playerPos.x>=0;
        boolean checkY = playerPos.y<Board.MAP_SIZE_Y && playerPos.y>=0;
        return checkX && checkY;
    }

    public static void setPlayerState(){
        // Split player.png into 3 textures
        Texture texture = new Texture("assets/player.png");
        TextureRegion texturePlayer = new TextureRegion(texture);
        TextureRegion[][] tP = texturePlayer.split(texture,Render.widthPixels, Render.heightPixels);

        // Get the textures for the different player states
        StaticTiledMapTile playerCellTile = new StaticTiledMapTile(tP[0][0]);
        StaticTiledMapTile playerDiedCellTile = new StaticTiledMapTile(tP[0][1]);
        StaticTiledMapTile playerWonTile = new StaticTiledMapTile(tP[0][2]);

        // Create player states
        playerCell = new TiledMapTileLayer.Cell().setTile(playerCellTile);
        playerDiedCell = new TiledMapTileLayer.Cell().setTile(playerDiedCellTile);
        playerWonCell = new TiledMapTileLayer.Cell().setTile(playerWonTile);
    }

    public static void move(int keyCode){
        // -------- Placeholder movement --------
        // Using arrow keys
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

}
