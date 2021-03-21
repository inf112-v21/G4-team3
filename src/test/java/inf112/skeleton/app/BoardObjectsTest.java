package inf112.skeleton.app;

import com.badlogic.gdx.math.Vector2;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;

import static org.junit.Assert.assertEquals;

public class BoardObjectsTest {

    public Board board;
    public GameLogic gameLogic;
    public Player player;

    @Before
    public void setUp(){
        // Initiate board and player
        board = new Board();
        board.setSize(20, 20);
        player = new Player(new Vector2(0,0), null);
        gameLogic = new GameLogic(null, player, null, board);
    }

    public void setUpCheckPoints(){
        Cell flag1 = new Cell();
        Cell flag2 = new Cell();
        Cell flag3 = new Cell();
        board.flag1Layer.setCell(2,2,flag1);
        board.flag2Layer.setCell(4,4,flag2);
        board.flag3Layer.setCell(6,6,flag3);
    }

    public void setUpConveyorBelts(){
        Cell beltNorth = new Cell();
        Cell beltWest = new Cell();
        Cell beltSouth = new Cell();
        Cell beltEast = new Cell();

        board.beltNorthLayer.setCell(1,2,beltNorth);
        board.beltNorthLayer.setCell(1,3,beltNorth);
        board.beltNorthLayer.setCell(1,4,beltNorth);

        board.beltWestLayer.setCell(4,1,beltWest);
        board.beltWestLayer.setCell(5,1,beltWest);

        board.beltSouthLayer.setCell(2,2,beltSouth);
        board.beltSouthLayer.setCell(2,3,beltSouth);
        board.beltSouthLayer.setCell(2,4,beltSouth);

        board.beltEastLayer.setCell(4,2,beltEast);
        board.beltEastLayer.setCell(5,2,beltEast);
        board.beltEastLayer.setCell(6,2,beltEast);
    }

    @Test
    public void testConveyorBeltNorth(){
        setUpConveyorBelts();
        player.move(new Vector2(1,2));
        board.updatePlayer(player);
        Vector2 expectedPos = new Vector2(1,3);
        assertEquals(expectedPos, player.getPosition());
    }

    @Test
    public void testConveyorBeltWest(){
        setUpConveyorBelts();
        player.move(new Vector2(4,1));
        board.updatePlayer(player);
        Vector2 expectedPos = new Vector2(3,1);
        assertEquals(expectedPos, player.getPosition());
    }

    @Test
    public void testConveyorBeltSouth(){
        setUpConveyorBelts();
        player.move(new Vector2(2,2));
        board.updatePlayer(player);
        Vector2 expectedPos = new Vector2(2,1);
        assertEquals(expectedPos, player.getPosition());
    }

    @Test
    public void testConveyorBeltEast(){
        Cell laser = new Cell();
        board.laserLayer.setCell(1,1,laser);
        player.move(new Vector2(1,1));
        board.updatePlayer(player);
        int expectedHP = player.getMaxHP()-1;
        assertEquals(expectedHP, player.getCurrentHP());
    }

    @Test
    public void testLoseLifeWhenHitByLaser(){
        setUpConveyorBelts();
        player.move(new Vector2(1,2));
        board.updatePlayer(player);
        Vector2 expectedPos = new Vector2(1,3);
        assertEquals(expectedPos, player.getPosition());
    }

    @Test
    public void testLose1LifeWhenOnHole(){
        setUp();

        // Create a hole and set it on the map
        Cell hole = new Cell();
        board.holeLayer.setCell(1,1,hole);

        // Move player to hole
        player.move(new Vector2(1,1));

        // Update the board once
        board.updatePlayer(player);

        assertEquals(2, player.getLife());
    }

    @Test
    public void testLoseAllLifePoints(){
        //setUp();
        Cell hole = new Cell();
        board.holeLayer.setCell(1,1, hole);
        player.move(1,1);

        int nLife = player.getLife();
        for(int i=0; nLife>i; i++) {
            board.updatePlayer(player);
            player.move(1,1);
        }
        assertEquals(0, player.getLife());
    }

    @Test
    public void testLoseWhenLostAllLifePoints(){
        setUp();
        Cell hole = new Cell();
        board.holeLayer.setCell(1,1, hole);
        player.move(1,1);

        int nLife = player.getLife();
        for(int i=0; nLife>i; i++) {
            board.updatePlayer(player);
            player.move(1,1);
        }
        assertEquals(true, player.playerLost());
    }

    @Test
    public void testUpdatingCheckPoint(){
        setUpCheckPoints();
        player.move(2,2);
        board.updatePlayer(player);
        player.move(3,3);

        Vector2 expectedCP = new Vector2(2,2);
        assertEquals(expectedCP, player.getCheckPoint());
    }

    @Test
    public void testUpdatingCheckPoint3(){
        setUpCheckPoints();
        player.move(2,2);
        board.updatePlayer(player);
        player.move(4,4);
        board.updatePlayer(player);
        player.move(6,6);
        board.updatePlayer(player);

        Vector2 expectedPos = new Vector2(6,6);
        assertEquals(expectedPos, player.getCheckPoint());
    }

    @Test
    public void testMoveToCheckPointAfterDeath(){
        setUpCheckPoints();
        player.move(2,2);
        board.updatePlayer(player);
        player.move(3,3);
        board.updatePlayer(player);
        player.setLife(0);
        board.updatePlayer(player);

        Vector2 expectedPos = new Vector2(2,2);
        assertEquals(expectedPos, player.getCheckPoint());
    }

    @Test
    public void testWinAfterVisitingAllFlags(){
        setUpCheckPoints();
        player.move(2,2);
        board.updatePlayer(player);
        player.move(4,4);
        board.updatePlayer(player);
        player.move(6,6);
        board.updatePlayer(player);

        assertEquals(true, player.playerWon());
    }
}
