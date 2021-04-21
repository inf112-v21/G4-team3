package inf112.skeleton.app;

import com.badlogic.gdx.math.Vector2;
import org.junit.Before;
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
        player = new Player(new Vector2(0,0), 0,null);
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

    public void setUpWalls(){
        Cell wallNorth = new Cell();
        Cell wallWest = new Cell();
        Cell wallEast = new Cell();
        Cell wallSouth = new Cell();
        Cell wallNorthEast = new Cell();
        Cell wallNorthWest = new Cell();
        Cell wallSouthEast = new Cell();
        Cell wallSouthWest = new Cell();

    }
    // Example test
    @Test
    public void testLose1LifeWhenOnHole(){
        setUp();

        // Create a hole and set it on the map
        Cell hole = new Cell();
        board.holeLayer.setCell(1,1,hole);

        // Move player to hole
        player.move(1,1);

        // Update the board once
        board.updateBoard(player);

        assertEquals(2, player.getLife());
    }

    @Test
    public void testConveyorBeltNorth(){
        setUpConveyorBelts();
        player.move(new Vector2(1,2));
        board.updateBoard(player);
        Vector2 expectedPos = new Vector2(1,3);
        assertEquals(expectedPos, player.getPosition());
    }

    @Test
    public void testConveyorBeltWest(){
        setUpConveyorBelts();
        player.move(new Vector2(4,1));
        board.updateBoard(player);
        Vector2 expectedPos = new Vector2(3,1);
        assertEquals(expectedPos, player.getPosition());
    }

    @Test
    public void testConveyorBeltSouth(){
        setUpConveyorBelts();
        player.move(new Vector2(2,2));
        board.updateBoard(player);
        Vector2 expectedPos = new Vector2(2,1);
        assertEquals(expectedPos, player.getPosition());
    }

    @Test
    public void testConveyorBeltEast(){
        Cell laser = new Cell();
        board.laserLayer.setCell(1,1,laser);
        player.move(new Vector2(1,1));
        board.updateBoard(player);
        int expectedHP = player.getMaxHP()-1;
        assertEquals(expectedHP, player.getCurrentHP());
    }

    @Test
    public void testLoseLifeWhenHitByLaser(){
        setUpConveyorBelts();
        player.move(new Vector2(1,2));
        board.updateBoard(player);
        Vector2 expectedPos = new Vector2(1,3);
        assertEquals(expectedPos, player.getPosition());
    }

    @Test
    public void testLoseAllLifePoints(){
        //setUp();
        Cell hole = new Cell();
        board.holeLayer.setCell(1,1, hole);
        player.move(1,1);

        int nLife = player.getLife();
        for(int i=0; nLife>i; i++) {
            board.updateBoard(player);
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
            board.updateBoard(player);
            player.move(1,1);
        }
        assertEquals(true, player.playerLost());
    }

    @Test
    public void testUpdatingCheckPoint(){
        setUpCheckPoints();
        player.move(2,2);
        board.updateBoard(player);
        player.move(3,3);

        Vector2 expectedCP = new Vector2(2,2);
        assertEquals(expectedCP, player.getCheckPoint());
    }

    @Test
    public void testUpdatingCheckPoint3(){
        setUpCheckPoints();
        player.move(2,2);
        board.updateBoard(player);
        player.move(4,4);
        board.updateBoard(player);
        player.move(6,6);
        board.updateBoard(player);

        Vector2 expectedPos = new Vector2(6,6);
        assertEquals(expectedPos, player.getCheckPoint());
    }

    @Test
    public void testMoveToCheckPointAfterDeath(){
        setUpCheckPoints();
        player.move(2,2);
        board.updateBoard(player);
        player.move(3,3);
        board.updateBoard(player);
        player.setLife(0);
        board.updateBoard(player);

        Vector2 expectedPos = new Vector2(2,2);
        assertEquals(expectedPos, player.getCheckPoint());
    }

    @Test
    public void testMoveToCheckPointAfterHole(){
        Cell hole = new Cell();
        board.holeLayer.setCell(2,4,hole);
        Vector2 expectedPos = player.getPosition();

        player.move(2,4);
        board.updateBoard(player);

        System.out.println(expectedPos);
        assertEquals(expectedPos, player.getPosition());
    }

    @Test
    public void testWinAfterVisitingAllFlags(){
        setUpCheckPoints();
        player.move(2,2);
        board.updateBoard(player);
        player.move(4,4);
        board.updateBoard(player);
        player.move(6,6);
        board.updateBoard(player);

        assertEquals(true, player.playerWon());
    }

    @Test
    public void testFixerRestoreFullHealth(){
        Cell fixer = new Cell();
        board.holeLayer.setCell(2,1, fixer);
        player.setHP(1);
        board.updateBoard(player);
        player.move(2,1);
        board.updateBoard(player);
        assertEquals(player.getMaxHP(), player.getCurrentHP());
    }

    @Test
    public void testNorthFacingWallsWhilePlayerIsFacingNorth(){
        Cell wallNorth = new Cell();
        board.wallNorthLayer.setCell(1,1, wallNorth);
        player.move(1,1);
        player.dir = 0;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testNorthEastFacingWallsWhilePlayerIsFacingNorth(){
        Cell wallNorthEast = new Cell();
        board.wallNorthEastLayer.setCell(1,1, wallNorthEast);
        player.move(1,1);
        player.dir = 0;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testNorthWestFacingWallsWhilePlayerIsFacingNorth(){
        Cell wallNorthWest = new Cell();
        board.wallNorthWestLayer.setCell(1,1, wallNorthWest);
        player.move(1,1);
        player.dir = 0;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testSouthFacingWallsWhilePlayerIsFacingNorth(){
        Cell wallSouth = new Cell();
        board.wallSouthLayer.setCell(1,1, wallSouth);
        player.move(1,1);
        player.dir = 0;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(1,2), player.getPosition());
    }

    @Test
    public void testSouthEastFacingWallsWhilePlayerIsFacingNorth(){
        Cell wallSouthEast = new Cell();
        board.wallSouthEastLayer.setCell(1,1, wallSouthEast);
        player.move(1,1);
        player.dir = 0;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(1,2), player.getPosition());
    }

    @Test
    public void testSouthWestFacingWallsWhilePlayerIsFacingNorth(){
        Cell wallSouthWest = new Cell();
        board.wallSouthWestLayer.setCell(1,1, wallSouthWest);
        player.move(1,1);
        player.dir = 0;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(1,2), player.getPosition());
    }

    @Test
    public void testWestFacingWallsWhilePlayerIsFacingNorth(){
        Cell wallWest = new Cell();
        board.wallWestLayer.setCell(1,1, wallWest);
        player.move(1,1);
        player.dir = 0;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(1,2), player.getPosition());
    }

    @Test
    public void testEastFacingWallsWhilePlayerIsFacingNorth(){
        Cell wallEast = new Cell();
        board.wallEastLayer.setCell(1,1, wallEast);
        player.move(1,1);
        player.dir = 0;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(1,2), player.getPosition());
    }

    @Test
    public void testNorthFacingWallsWhilePlayerIsFacingEast(){
        Cell wallNorth = new Cell();
        board.wallNorthLayer.setCell(1,1, wallNorth);
        player.move(1,1);
        player.dir = 90;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(2,1)), player.getPosition());
    }

    @Test
    public void testNorthEastFacingWallsWhilePlayerIsFacingEast(){
        Cell wallNorthEast = new Cell();
        board.wallNorthEastLayer.setCell(1,1, wallNorthEast);
        player.move(1,1);
        player.dir = 90;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testNorthWestFacingWallsWhilePlayerIsFacingEast(){
        Cell wallNorthWest = new Cell();
        board.wallNorthWestLayer.setCell(1,1, wallNorthWest);
        player.move(1,1);
        player.dir = 90;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(2,1)), player.getPosition());
    }

    @Test
    public void testSouthFacingWallsWhilePlayerIsFacingEast(){
        Cell wallSouth = new Cell();
        board.wallSouthLayer.setCell(1,1, wallSouth);
        player.move(1,1);
        player.dir = 90;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(2,1), player.getPosition());
    }

    @Test
    public void testSouthEastFacingWallsWhilePlayerIsFacingEast(){
        Cell wallSouthEast = new Cell();
        board.wallSouthEastLayer.setCell(1,1, wallSouthEast);
        player.move(1,1);
        player.dir = 90;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(1,1), player.getPosition());
    }

    @Test
    public void testSouthWestFacingWallsWhilePlayerIsFacingEast(){
        Cell wallSouthWest = new Cell();
        board.wallSouthWestLayer.setCell(1,1, wallSouthWest);
        player.move(1,1);
        player.dir = 90;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(2,1), player.getPosition());
    }

    @Test
    public void testWestFacingWallsWhilePlayerIsFacingEast(){
        Cell wallWest = new Cell();
        board.wallWestLayer.setCell(1,1, wallWest);
        player.move(1,1);
        player.dir = 90;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(2,1), player.getPosition());
    }

    @Test
    public void testEastFacingWallsWhilePlayerIsFacingEast(){
        Cell wallEast = new Cell();
        board.wallEastLayer.setCell(1,1, wallEast);
        player.move(1,1);
        player.dir = 90;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(1,1), player.getPosition());
    }

    @Test
    public void testNorthFacingWallsWhilePlayerIsFacingSouth(){
        Cell wallNorth = new Cell();
        board.wallNorthLayer.setCell(1,1, wallNorth);
        player.move(1,1);
        player.dir = 180;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,0)), player.getPosition());
    }

    @Test
    public void testNorthEastFacingWallsWhilePlayerIsFacingSouth(){
        Cell wallNorthEast = new Cell();
        board.wallNorthEastLayer.setCell(1,1, wallNorthEast);
        player.move(1,1);
        player.dir = 180;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,0)), player.getPosition());
    }

    @Test
    public void testNorthWestFacingWallsWhilePlayerIsFacingSouth(){
        Cell wallNorthWest = new Cell();
        board.wallNorthWestLayer.setCell(1,1, wallNorthWest);
        player.move(1,1);
        player.dir = 180;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,0)), player.getPosition());
    }

    @Test
    public void testSouthFacingWallsWhilePlayerIsFacingSouth(){
        Cell wallSouth = new Cell();
        board.wallSouthLayer.setCell(1,1, wallSouth);
        player.move(1,1);
        player.dir = 180;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(1,1), player.getPosition());
    }

    @Test
    public void testSouthEastFacingWallsWhilePlayerIsFacingSouth(){
        Cell wallSouthEast = new Cell();
        board.wallSouthEastLayer.setCell(1,1, wallSouthEast);
        player.move(1,1);
        player.dir = 180;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(1,1), player.getPosition());
    }

    @Test
    public void testSouthWestFacingWallsWhilePlayerIsFacingSouth(){
        Cell wallSouthWest = new Cell();
        board.wallSouthWestLayer.setCell(1,1, wallSouthWest);
        player.move(1,1);
        player.dir = 180;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(1,1), player.getPosition());
    }

    @Test
    public void testWestFacingWallsWhilePlayerIsFacingSouth(){
        Cell wallWest = new Cell();
        board.wallWestLayer.setCell(1,1, wallWest);
        player.move(1,1);
        player.dir = 180;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(1,0), player.getPosition());
    }

    @Test
    public void testEastFacingWallsWhilePlayerIsFacingSouth() {
        Cell wallEast = new Cell();
        board.wallEastLayer.setCell(1, 1, wallEast);
        player.move(1, 1);
        player.dir = 180;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(1, 0), player.getPosition());
    }

    @Test
    public void testNorthFacingWallsWhilePlayerIsFacingWest(){
        Cell wallNorth = new Cell();
        board.wallNorthLayer.setCell(1,1, wallNorth);
        player.move(1,1);
        player.dir = 270;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(0,1)), player.getPosition());
    }

    @Test
    public void testNorthEastFacingWallsWhilePlayerIsFacingWest(){
        Cell wallNorthEast = new Cell();
        board.wallNorthEastLayer.setCell(1,1, wallNorthEast);
        player.move(1,1);
        player.dir = 270;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(0,1)), player.getPosition());
    }

    @Test
    public void testNorthWestFacingWallsWhilePlayerIsFacingWest(){
        Cell wallNorthWest = new Cell();
        board.wallNorthWestLayer.setCell(1,1, wallNorthWest);
        player.move(1,1);
        player.dir = 270;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testSouthFacingWallsWhilePlayerIsFacingWest(){
        Cell wallSouth = new Cell();
        board.wallSouthLayer.setCell(1,1, wallSouth);
        player.move(1,1);
        player.dir = 270;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(0,1), player.getPosition());
    }

    @Test
    public void testSouthEastFacingWallsWhilePlayerIsFacingWest(){
        Cell wallSouthEast = new Cell();
        board.wallSouthEastLayer.setCell(1,1, wallSouthEast);
        player.move(1,1);
        player.dir = 270;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(0,1), player.getPosition());
    }

    @Test
    public void testSouthWestFacingWallsWhilePlayerIsFacingWest(){
        Cell wallSouthWest = new Cell();
        board.wallSouthWestLayer.setCell(1,1, wallSouthWest);
        player.move(1,1);
        player.dir = 270;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(1,1), player.getPosition());
    }

    @Test
    public void testWestFacingWallsWhilePlayerIsFacingWest(){
        Cell wallWest = new Cell();
        board.wallWestLayer.setCell(1,1, wallWest);
        player.move(1,1);
        player.dir = 270;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(1,1), player.getPosition());
    }

    @Test
    public void testEastFacingWallsWhilePlayerIsFacingWest() {
        Cell wallEast = new Cell();
        board.wallEastLayer.setCell(1, 1, wallEast);
        player.move(1, 1);
        player.dir = 270;

        player.move(CardMovement.Movement.MOVE1, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals(new Vector2(0, 1), player.getPosition());
    }

    @Test
    public void testNorthFacingWallsWhilePlayerIsMovingTwoSpaces(){
        Cell wallNorth = new Cell();
        board.wallNorthLayer.setCell(1,1, wallNorth);
        player.move(1,0);
        player.dir = 0;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testNorthEastFacingWallsWhilePlayerIsMovingTwoSpacesFacingEast(){
        Cell wallNorthEast = new Cell();
        board.wallNorthEastLayer.setCell(1,1, wallNorthEast);
        player.move(0,1);
        player.dir = 90;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testNorthEastFacingWallsWhilePlayerIsMovingTwoSpacesFacingNorth(){
        Cell wallNorthEast = new Cell();
        board.wallNorthEastLayer.setCell(1,1, wallNorthEast);
        player.move(1,0);
        player.dir = 0;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testNorthWestFacingWallsWhilePlayerIsMovingTwoSpacesFacingNorth(){
        Cell wallNorthWest = new Cell();
        board.wallNorthWestLayer.setCell(1,1, wallNorthWest);
        player.move(1,0);
        player.dir = 0;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testNorthWestFacingWallsWhilePlayerIsMovingTwoSpacesFacingWest(){
        Cell wallNorthWest = new Cell();
        board.wallNorthWestLayer.setCell(1,1, wallNorthWest);
        player.move(2,1);
        player.dir = 270;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testSouthFacingWallsWhilePlayerIsMovingTwoSpaces(){
        Cell wallSouth = new Cell();
        board.wallSouthLayer.setCell(1,1, wallSouth);
        player.move(1,2);
        player.dir = 180;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testSouthEastFacingWallsWhilePlayerIsMovingTwoSpacesFacingSouth(){
        Cell wallSouthEast = new Cell();
        board.wallSouthEastLayer.setCell(1,1, wallSouthEast);
        player.move(1,2);
        player.dir = 180;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testSouthEastFacingWallsWhilePlayerIsMovingTwoSpacesFacingEast(){
        Cell wallSouthEast = new Cell();
        board.wallSouthEastLayer.setCell(1,1, wallSouthEast);
        player.move(0,1);
        player.dir = 90;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testSouthWestFacingWallsWhilePlayerIsMovingTwoSpacesFacingSouth(){
        Cell wallSouthWest = new Cell();
        board.wallSouthWestLayer.setCell(1,1, wallSouthWest);
        player.move(1,2);
        player.dir = 180;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testSouthWestFacingWallsWhilePlayerIsMovingTwoSpacesFacingWest(){
        Cell wallSouthWest = new Cell();
        board.wallSouthWestLayer.setCell(1,1, wallSouthWest);
        player.move(2,1);
        player.dir = 270;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testWestFacingWallsWhilePlayerIsMovingTwoSpaces(){
        Cell wallWest = new Cell();
        board.wallWestLayer.setCell(1,1, wallWest);
        player.move(2,1);
        player.dir = 270;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testEastFacingWallsWhilePlayerIsMovingTwoSpaces() {
        Cell wallEast = new Cell();
        board.wallEastLayer.setCell(1, 1, wallEast);
        player.move(0,1);
        player.dir = 90;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testNorthFacingWallsWhilePlayerIsMovingTreeSpaces(){
        Cell wallNorth = new Cell();
        board.wallNorthLayer.setCell(1,1, wallNorth);
        player.move(1,-1);
        player.dir = 0;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testNorthEastFacingWallsWhilePlayerIsMovingTreeSpacesFacingEast(){
        Cell wallNorthEast = new Cell();
        board.wallNorthEastLayer.setCell(1,1, wallNorthEast);
        player.move(-1,1);
        player.dir = 90;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testNorthEastFacingWallsWhilePlayerIsMovingTreeSpacesFacingNorth(){
        Cell wallNorthEast = new Cell();
        board.wallNorthEastLayer.setCell(1,1, wallNorthEast);
        player.move(1,-1);
        player.dir = 0;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testNorthWestFacingWallsWhilePlayerIsMovingTreeSpacesFacingNorth(){
        Cell wallNorthWest = new Cell();
        board.wallNorthWestLayer.setCell(1,1, wallNorthWest);
        player.move(1,-1);
        player.dir = 0;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testNorthWestFacingWallsWhilePlayerIsMovingTreeSpacesFacingWest(){
        Cell wallNorthWest = new Cell();
        board.wallNorthWestLayer.setCell(1,1, wallNorthWest);
        player.move(3,1);
        player.dir = 270;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testSouthFacingWallsWhilePlayerIsMovingTreeSpaces(){
        Cell wallSouth = new Cell();
        board.wallSouthLayer.setCell(1,1, wallSouth);
        player.move(1,3);
        player.dir = 180;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testSouthEastFacingWallsWhilePlayerIsMovingTreeSpacesFacingSouth(){
        Cell wallSouthEast = new Cell();
        board.wallSouthEastLayer.setCell(1,1, wallSouthEast);
        player.move(1,3);
        player.dir = 180;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testSouthEastFacingWallsWhilePlayerIsMovingTreeSpacesFacingEast(){
        Cell wallSouthEast = new Cell();
        board.wallSouthEastLayer.setCell(1,1, wallSouthEast);
        player.move(-1,1);
        player.dir = 90;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testSouthWestFacingWallsWhilePlayerIsMovingTreeSpacesFacingSouth(){
        Cell wallSouthWest = new Cell();
        board.wallSouthWestLayer.setCell(1,1, wallSouthWest);
        player.move(1,3);
        player.dir = 180;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testSouthWestFacingWallsWhilePlayerIsMovingTreeSpacesFacingWest(){
        Cell wallSouthWest = new Cell();
        board.wallSouthWestLayer.setCell(1,1, wallSouthWest);
        player.move(3,1);
        player.dir = 270;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testWestFacingWallsWhilePlayerIsMovingTreeSpaces(){
        Cell wallWest = new Cell();
        board.wallWestLayer.setCell(1,1, wallWest);
        player.move(3,1);
        player.dir = 270;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }

    @Test
    public void testEastFacingWallsWhilePlayerIsMovingTreeSpaces() {
        Cell wallEast = new Cell();
        board.wallEastLayer.setCell(1, 1, wallEast);
        player.move(-1,1);
        player.dir = 90;

        player.move(CardMovement.Movement.MOVE2, board);


        // Update the board once
        board.updateBoard(player);

        assertEquals( (new Vector2(1,1)), player.getPosition());
    }
}
