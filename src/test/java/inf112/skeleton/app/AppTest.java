package inf112.skeleton.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */

    // Initiate a player class instance
    public Player player = new Player();

    public Board board = new Board();

    @Before
    public void setPlayerPosition(){
        player.playerPos = new Vector2(0,0);
    }

    @Test
    public void testMovementUp() {
        Vector2 expectedPosition = new Vector2(0,1);
        player.move("up");
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testMovementDown(){
        Vector2 expectedPosition = new Vector2(0,-1);
        player.move("down");
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testMovementRight() {
        Vector2 expectedPosition = new Vector2(1,0);
        player.move("right");
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testMovementLeft() {
        Vector2 expectedPosition = new Vector2(-1,0);
        player.move("left");
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testIfPlayerIsOnMap(){
        Board board = new Board();
        board.MAP_SIZE_X = 4;
        board.MAP_SIZE_X = 4;
        player.playerPos = new Vector2(3,1);
        assertTrue(board.validPlayerMapPos(player.playerPos));
    }

    @Test
    public void testIfPlayerIsNotOnMap(){
        Board board = new Board();
        board.MAP_SIZE_X = 4;
        board.MAP_SIZE_X = 4;
        player.playerPos = new Vector2(-1,-1);
        assertTrue(!board.validPlayerMapPos(player.playerPos));
    }

    // testen åpner et windu som må lukkas før testen kjører, fungerer ellers
    //@Test
    public void testIfGameRegisterIfRobotLosesOfStandingOnHole(){
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("close");
        cfg.setWindowedMode(500, 500);
        new Lwjgl3Application(new Render(), cfg);

        player.playerPos = new Vector2(2,2);
        board.updatePlayer(player);
        //assertEquals();
        assertTrue(player.loseCondition);
    }

    // testen åpner et windu som må lukkas før testen kjører, fungerer ellers
    //@Test
    public void testIfGameRegisterRobotWinnsByWisitingFlag(){
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("close");
        cfg.setWindowedMode(500, 500);
        new Lwjgl3Application(new Render(), cfg);
        player.playerPos = new Vector2(4,4); //flag position
        board.updatePlayer(player);
        //assertEquals();
        assertTrue(player.winCondition);
    }


}


