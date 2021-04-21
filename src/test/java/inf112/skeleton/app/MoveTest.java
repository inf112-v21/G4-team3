package inf112.skeleton.app;

import com.badlogic.gdx.math.Vector2;
import org.junit.Before;

public class MoveTest{

    // Initiate class instances
    public Player player = new Player(new Vector2(1,1), 0, null);
    public Board board = new Board();

    @Before
    public void setPlayerPosition(){
        player.playerPos = new Vector2(0,0);
        player.dir = 0;
    }
/*
    @Test
    public void testMovement1UpInnNordenDir() {
        Vector2 expectedPosition = new Vector2(0,1);
        player.move(CardMovement.Movement.MOVE1, board);
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testMovement2UpInnNordenDir() {
        Vector2 expectedPosition = new Vector2(0,2);
        player.move(CardMovement.Movement.MOVE2, board);
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testMovement3UpInnNordenDir() {
        Vector2 expectedPosition = new Vector2(0,3);
        player.move(CardMovement.Movement.MOVE3, baord);
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testMovementBackup() {
        Vector2 expectedPosition = new Vector2(0,-1);
        player.move(CardMovement.Movement.BACKUP, board);
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testMovement1InnEastDir() {
        player.dir = 90;
        Vector2 expectedPosition = new Vector2(1,0);
        player.move(CardMovement.Movement.MOVE1, board);
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testMovement1InnSouthDir() {
        player.dir = 180;
        Vector2 expectedPosition = new Vector2(0,-1);
        player.move(CardMovement.Movement.MOVE1, board);
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testMovement1InnWestDir() {
        player.dir = 270;
        Vector2 expectedPosition = new Vector2(-1,0);
        player.move(CardMovement.Movement.MOVE1, board);
        assertEquals(expectedPosition, player.playerPos);
    }

    @Test
    public void testRotationLeft() {
        int expectedDir = 270;
        player.move(CardRotation.Rotation.ROTATELEFT, board);
        assertEquals(expectedDir, player.dir);
    }

    @Test
    public void testRotationRight() {
        int expectedDir = 90;
        player.move(CardRotation.Rotation.ROTATERIGHT, board);
        assertEquals(expectedDir, player.dir);
    }

    @Test
    public void testRotationUturn() {
        int expectedDir = 180;
        player.move(CardRotation.Rotation.UTURN, board);
        assertEquals(expectedDir, player.dir);
    }

    // Open application for testing purposes. my be needed for future
    public static void openApplication() {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("Lukk vinduet for at testen skal kjøre");
        cfg.setWindowedMode(500, 500);
        new Lwjgl3Application(new RenderServer(), cfg);
    }

 */
}
