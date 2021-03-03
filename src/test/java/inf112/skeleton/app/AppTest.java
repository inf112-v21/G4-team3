package inf112.skeleton.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import org.junit.Before;
import org.junit.Test;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;


/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */

    // Initiate class instances
    public Player player = new Player(new Vector2(1,1), null);
    public Board board = new Board();

    @Before
    public void setPlayerPosition(){
        player.playerPos = new Vector2(0,0);
        player.dir = 0;
    }


/*
    @Test
    public void testIfPlayerIsOnMap(){
        Board board = new Board();
        board.MAP_SIZE_X = 4;
        board.MAP_SIZE_Y = 4;
        player.playerPos = new Vector2(3,1);
        assertTrue(board.validPlayerMapPos(player.playerPos));
    }

    @Test
    public void testIfPlayerIsNotOnMap(){
        Board board = new Board();
        board.MAP_SIZE_X = 4;
        board.MAP_SIZE_Y = 4;
        player.playerPos = new Vector2(-1,-1);
        assertTrue(!board.validPlayerMapPos(player.playerPos));
    }

    @Test
    public void testCardsHandedOut() {
        CardDeck testDeck = new CardDeck();
        ArrayList<Enum> cardsToPickFrom = new ArrayList<>();


        for (int i = 0; i <= 8; i++) {
            Enum draw = testDeck.deck.get(i);
            cardsToPickFrom.add(draw);
        }
        assertEquals(9, cardsToPickFrom.size());
    }

    @Test
    public void testPickedFiveCards() {
        CardDeck testDeck = new CardDeck();
        ArrayList<Enum> cardsToPickFrom = new ArrayList<>();
        ArrayList<Enum> pickedCards = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            Enum draw = testDeck.deck.get(i);
            cardsToPickFrom.add(draw);
        }


    }
*/


    // Open application for testing purposes
    public static void openApplication() {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("Lukk vinduet for at testen skal kjøre");
        cfg.setWindowedMode(500, 500);
        new Lwjgl3Application(new RenderServer(), cfg);
    }

    // Testen åpner et vindu som må lukkes før testen kjører, fungerer ellers. [WIP]
    //@Test
    public void testIfGameRegisterIfRobotLosesOfStandingOnHole(){
        openApplication();

        // Using the layer setup from Testmap.tmx
        player.playerPos = new Vector2(2,2); // Hole position;
        //board.updatePlayer(player);
        assertTrue(player.loseCondition);
    }

    // Testen åpner et vindu som må lukkes før testen kjører, fungerer ellers. [WIP]
    //@Test
    public void testIfGameRegisterRobotWinsByVisitingFlag(){
        openApplication();

        // Using the layer setup from Testmap.tmx
        player.playerPos = new Vector2(4,4); // Flag position
        //board.updatePlayer(player);
        assertTrue(player.winCondition);
    }


}


