package inf112.skeleton.app;

public class RenderSinglePlayer extends RenderServer{

    @Override
    public void createGame(){
        // Setup player cell states, including textures
        player1.setTexture("assets/player.png");
        player1.setPlayerState();

        // Game logic
        gameLogic = new GameLogic(null, player1, null, board);

        board.updatePlayer(player1);
    }

    @Override
    public void simulateRound(){
    }

    @Override
    public boolean keyUp(int keyCode){
        gameLogic.moveAndUpdate(player1, keyCode);
        return false;
    }
}
