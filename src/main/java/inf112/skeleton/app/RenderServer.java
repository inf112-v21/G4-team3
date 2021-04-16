package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.Network.Networking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class RenderServer extends InputAdapter implements ApplicationListener {

    // For text
    public SpriteBatch batch;
    public BitmapFont font;

    // Displaying player
    private OrthographicCamera camera;
    private OrthogonalTiledMapRenderer renderer;
    public static final int widthPixels = 300;
    public static final int heightPixels = 300;
    public boolean pause = false;

    // Players start position
    public Player player1 = new Player(new Vector2(1,6), 90,"assets/player.png");
    public Player player2 = new Player(new Vector2(1,3), 90,"assets/player2.png");
    public Board board = new Board();

    private boolean pickingCards = true;
    public ArrayList<Enum> cardsToPickFrom;
    public Networking server = new Networking("Server");
    public Networking connection = new Networking("Client");
    public GameLogic gameLogic;
    public Integer n = 0;

    @Override
    public void create() {
        setUpText();

        // Load in map layers from tmx file
        board.createMap();

        setUpCamera();

        setUpRender();

        createGame();

        // Get key input
        Gdx.input.setInputProcessor(this);
    }

    public void createGame(){
        // Setup player cell states, including textures
        player1.setTexture("assets/player.png");
        player2.setTexture("assets/player2.png");
        player1.setPlayerState();
        player2.setPlayerState();

        // Setup server/ client
        setUpGame();

        // Game logic
        gameLogic = new GameLogic(connection, player1, player2, board);

        board.updateBoard(player1);
        board.updateBoard(player2);
    }

    public void setUpGame() {
        server.start();
        System.out.println("Server online");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        connection.connectIP("127.0.0.1", 4000);
        connection.start();
    }

    public void setUpCamera(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, board.MAP_SIZE_X, board.MAP_SIZE_Y+2);
        camera.position.x = board.MAP_SIZE_X/2f;
        camera.position.y = (board.MAP_SIZE_Y-2)/2f;
        camera.update();
    }

    public void setUpText(){
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);
    }

    public void setUpRender(){
        renderer = new OrthogonalTiledMapRenderer(board.map, 1F/widthPixels);
        renderer.setView(camera);
    }

    public void showCardsOnScreen(){
        if (!gameLogic.pickingCards && !pause) {
            batch.begin();
            font.getData().setScale((float) 1.2, (float) 1.2);
            font.draw(batch, "Available cards:", 0, 120);
            font.getData().setScale((float) 0.8, (float) 0.8);
            if (Main.debugmode) {
                font.draw(batch, "1 : MOVE1; 2 : MOVE2; 3 : MOVE3; 4 : BACKUP; 5 : ROTATELEFT; 6 : ROTATERIGHT; 7 : UTURN", 0, 100);
                font.draw(batch, "Left arrowkey: ROTATELEFT; Up arrowkey: MOVE1; Right arrowkey: ROTATERIGHT; Down arrowkey: BACKUP", 0, 75);
            } else {
                font.draw(batch, cardsToPickFrom.toString(), 0, 100);
            }
            font.draw(batch, "Picked cards: " + player1.getCurrentCards(), 0, 50);
            batch.end();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        renderer.render();
        pause = gameLogic.pause;
        if (pause == false){
            simulateRound();
        }
        showCardsOnScreen();
        if (!gameLogic.pickingCards && !pause || Main.debugmode) {
            showCardsOnScreen();
        }
        showHPandLives(player1);
        checkWinCondition();
    }

    public void simulateRound(){
        try {
            gameLogic.doRound();
            cardsToPickFrom = gameLogic.cardsToPickFrom;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkWinCondition() {
        if (player1.winCondition || player2.loseCondition){
            endGame();
            // End win screen
            batch.begin();
            font.getData().setScale(4, 4);
            font.draw(batch, "You won", 240, 250);
            batch.end();
        }
        else if (player2.winCondition || player1.loseCondition){
            endGame();
            // End win screen
            batch.begin();
            font.getData().setScale(4, 4);
            font.draw(batch, "You lost", 240, 250);
            batch.end();
        }
    }

    public void endGame(){
        pause = true;
        gameLogic.readyTurn = false; // Stop the round
    }
    @Override
    public void resize(int width, int height) {

    }
    @Override
    public void pause() {
        pause = true;
    }
    @Override
    public void resume() {
        pause = false;
    }

    @Override
    public boolean keyUp(int keyCode){
        if(!pause) {
            gameLogic.selectCardsFromKeyboardInput(keyCode);
        }
        return true;
    }

    public void showHPandLives(Player player) {
        batch.begin();
        font.getData().setScale(2, 2);
        font.draw(batch, "Player 1 ", 900, 150);
        font.draw(batch, "HP: " + player.getCurrentHP(), 900, 100);
        font.draw(batch, "Lives:" + player.getLife(), 900, 50);
        batch.end();
    }


}
