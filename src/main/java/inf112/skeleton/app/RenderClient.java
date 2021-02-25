package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class RenderClient extends RenderServer {

    public Client client = new Client();

    @Override
    public void setUpGame(){
        client = new Client();
        try {
            client.setUpClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
        gameLogic = new GameLogic(client, player1, player2, board);
    }

    @Override
    public void simulateRound() {
        try {
            // Delete previous player textures before moving
            board.playerLayer.setCell((int) player1.playerPos.x, (int) player1.playerPos.y, null);
            board.playerLayer.setCell((int) player2.playerPos.x, (int) player2.playerPos.y, null);
            ArrayList<Player> playerStates = gameLogic.doRoundClient();
            player1 = playerStates.get(0);
            player2 = playerStates.get(1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkWinCondition() {
        if (player2.winCondition || player1.loseCondition){
            endGame();
            // End win screen
            batch.begin();
            font.getData().setScale(4, 4);
            font.draw(batch, "Player 1 lost, you won", 140, 250);
            batch.end();
        }
        else if (player1.winCondition || player2.loseCondition){
            endGame();
            // End win screen
            batch.begin();
            font.getData().setScale(4, 4);
            font.draw(batch, "Player 1 won, you LOST", 140, 250);
            batch.end();
        }
    }

}
