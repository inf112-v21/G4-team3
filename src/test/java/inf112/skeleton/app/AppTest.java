package inf112.skeleton.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import com.badlogic.gdx.math.Vector2;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */

    public Player player = new Player();

    @BeforeEach
    void getTestMap(){
        player.playerPos = new Vector2(0,0);
    }

    @Test
    public void testMovementUp() {
        Vector2 expectedPosition = new Vector2(0,1);
        player.move(19);
        assertEquals(player.playerPos, expectedPosition);
    }
    @Test
    public void testMovementDown(){
        Vector2 expectedPosition = new Vector2(0,-1);
        player.move(20);
        assertEquals(player.playerPos, expectedPosition);
    }
    @Test
    public void testMovementRight() {
        Vector2 expectedPosition = new Vector2(1,0);
        player.move(22);
        assertEquals(player.playerPos, expectedPosition);
    }

    @Test
    public void testMovementLeft() {
        Vector2 expectedPosition = new Vector2(-1,0);
        player.move(21);
        assertEquals(player.playerPos, expectedPosition);
    }

    @Test
    public void testIfRobotDiesOfFaling(){
        Board board = new Board();
        board.createMap();

        player.playerPos = new Vector2(2,2);

        //assertEquals();
        assertTrue(true);
    }


}


/*
    HelloWorld test1;

    @BeforeEach
    void getTestMap(){
        test1 = new HelloWorld();
    };

    //@Test
    public void outOfMapEndGameTest(){
        HelloWorld test1 = new HelloWorld();

        test1.playerPos = new Vector2(-1,-1);
        //test1.updatePlayer();
        assertTrue(!test1.validPlayerMapPos(test1.playerPos));
    }

    @Test
    public void outOfMapEndGameTest2(){
        test1 = new HelloWorld();
        //map = new TmxMapLoader().load("assets/Testmap.tmx");
        test1.createMap();
        test1.setPlayerState();

        test1.playerPos = new Vector2(-1,-1);

        test1.updatePlayer();

        System.out.println(test1.loseCondition);

        assertTrue(!test1.loseCondition);

    }

    //@Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
*/

