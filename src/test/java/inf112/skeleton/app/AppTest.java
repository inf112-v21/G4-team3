package inf112.skeleton.app;

import static org.junit.Assert.assertTrue;
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

    //@Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

}
