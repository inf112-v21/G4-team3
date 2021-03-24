package inf112.skeleton.app;

import com.badlogic.gdx.math.Vector2;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class GameLogicTest {


    // Initiate class instances
    public Player player1 = new Player(new Vector2(1,1), 0, null);
    public Player player2 = new Player(new Vector2(1,1), 0, null);
    public Board board = new Board();
    public GameLogic gameLogic;

    // Different types of movement
    public Enum move1 = CardMovement.Movement.MOVE1;
    public Enum move2 = CardMovement.Movement.MOVE2;
    public Enum move3 = CardMovement.Movement.MOVE3;
    public Enum backUp = CardMovement.Movement.BACKUP;
    public Enum rotateRight = CardRotation.Rotation.ROTATERIGHT;
    public Enum rotateLeft = CardRotation.Rotation.ROTATELEFT;
    public Enum uturn = CardRotation.Rotation.UTURN;



    public void setUp(){
        player1.playerPos = new Vector2(0,0);
        player2.playerPos = new Vector2(0,0);
        player1.dir = 0;
        player2.dir = 0;
        gameLogic = new GameLogic(null, player1, player2, board);
    }

    @Test
    public void testSimulateTurns() throws InterruptedException {

        setUp();

        // Player 1 cards
        player1.pickedCards.add(move1);
        player1.pickedCards.add(move2);
        player1.pickedCards.add(rotateRight);
        player1.pickedCards.add(uturn);
        player1.pickedCards.add(backUp);

        // Player 2 cards
        gameLogic.receivedCards.add(rotateRight);
        gameLogic.receivedCards.add(move2);
        gameLogic.receivedCards.add(rotateLeft);
        gameLogic.receivedCards.add(move3);
        gameLogic.receivedCards.add(rotateRight);


        int nCards = player1.pickedCards.size();
        System.out.println(nCards);
        for (int i=0; i<nCards; i++){
            gameLogic.simulateTurns();
        }

        Vector2 expectedPosPlayer1 = new Vector2(1,3);
        int expectedDirPlayer1 = 270;
        Vector2 expectedPosPlayer2 = new Vector2(2,3);
        int expectedDirPlayer2 = 90;

        assertEquals(expectedDirPlayer1, player1.dir);
        assertEquals(expectedDirPlayer2, player2.dir);
        assertEquals(expectedPosPlayer1, player1.playerPos);
        assertEquals(expectedPosPlayer2, player2.playerPos);
    }
}
