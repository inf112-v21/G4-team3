package inf112.skeleton.app;

import com.badlogic.gdx.math.Vector2;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveTest extends AppTest{

    @Test
    public void testMovement1UpInnNordenDir() {
        Vector2 expectedPosition = new Vector2(0,1);
        player.move(CardMovement.Movement.MOVE1);
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testMovement2UpInnNordenDir() {
        Vector2 expectedPosition = new Vector2(0,2);
        player.move(CardMovement.Movement.MOVE2);
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testMovement3UpInnNordenDir() {
        Vector2 expectedPosition = new Vector2(0,3);
        player.move(CardMovement.Movement.MOVE3);
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testMovementBackup() {
        Vector2 expectedPosition = new Vector2(0,-1);
        player.move(CardMovement.Movement.BACKUP);
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testMovement1InnEastDir() {
        player.dir = 90;
        Vector2 expectedPosition = new Vector2(1,0);
        player.move(CardMovement.Movement.MOVE1);
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testMovement1InnSouthDir() {
        player.dir = 180;
        Vector2 expectedPosition = new Vector2(0,-1);
        player.move(CardMovement.Movement.MOVE1);
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testMovement1InnWestDir() {
        player.dir = 270;
        Vector2 expectedPosition = new Vector2(-1,0);
        player.move(CardMovement.Movement.MOVE1);
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testRotationLeft() {
        int expectedDir = 270;
        player.move(CardRotation.Rotation.ROTATELEFT);
        assertEquals(expectedDir, player.dir);
    }

    @Test
    public void testRotationRight() {
        int expectedDir = 90;
        player.move(CardRotation.Rotation.ROTATERIGHT);
        assertEquals(expectedDir, player.dir);
    }

    @Test
    public void testRotationUturn() {
        int expectedDir = 180;
        player.move(CardRotation.Rotation.UTURN);
        assertEquals(expectedDir, player.dir);
    }
}
