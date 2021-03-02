package inf112.skeleton.app;

import com.badlogic.gdx.math.Vector2;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveTest extends AppTest{



    @BeforeClass
    public void runApplication2Times() {
        AppTest appTest = new AppTest();
        openApplication();
    }

    @Test
    public void testMovement1UpInnNordenDir() {
        //openApplication();
        player.playerPos = new Vector2(0,0);
        Vector2 expectedPosition = new Vector2(0,1);
        player.move(CardMovement.Movement.MOVE1);
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testMovement1InnEastDir() {
        openApplication();
        player.playerPos = new Vector2(0,0);
        player.dir = 90;
        Vector2 expectedPosition = new Vector2(1,0);
        player.move(CardMovement.Movement.MOVE1);
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testMovement1InnSouthDir() {
        openApplication();
        player.playerPos = new Vector2(0,0);
        player.dir = 180;
        Vector2 expectedPosition = new Vector2(0,-1);
        player.move(CardMovement.Movement.MOVE1);
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testMovement1InnWestDir() {
        openApplication();
        player.playerPos = new Vector2(0,0);
        player.dir = 270;
        Vector2 expectedPosition = new Vector2(-1,0);
        player.move(CardMovement.Movement.MOVE1);
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testRotationLeft() {
        openApplication();
        player.playerPos = new Vector2(0,0);
        player.dir = 0;
        int expectedDir = 270;
        player.move(CardRotation.Rotation.ROTATELEFT);
        assertEquals(expectedDir, player.dir);
    }

    @Test
    public void testRotationRight() {
        openApplication();
        player.playerPos = new Vector2(0,0);
        player.dir = 0;
        int expectedDir = 90;
        player.move(CardRotation.Rotation.ROTATERIGHT);
        assertEquals(expectedDir, player.dir);
    }

    @Test
    public void testRotationUturn() {
        openApplication();
        player.playerPos = new Vector2(0,0);
        player.dir = 0;
        int expectedDir = 180;
        player.move(CardRotation.Rotation.UTURN);
        assertEquals(expectedDir, player.dir);
    }
}
