package inf112.skeleton.app;

public class RenderTesting extends RenderServer{

    @Override
    public void createGame(){
        // Setup player cell states, including textures
        player1.setPlayerState();
        player1.setName("Player 1");

        // Game logic
        gameLogic = new GameLogic(null, player1, null, board);

        board.updateBoard(player1);
    }

    @Override
    public void showCardsOnScreen(){
        batch.begin();
        font.getData().setScale((float)0.8, (float)0.8);
        font.draw(batch, "1 : MOVE1; 2 : MOVE2; 3 : MOVE3; 4 : BACKUP; 5 : ROTATELEFT; 6 : ROTATERIGHT; 7 : UTURN", 0, 100);
        font.draw(batch, "Left arrowkey: ROTATELEFT; Up arrowkey: MOVE1; Right arrowkey: ROTATERIGHT; Down arrowkey: BACKUP", 0, 75);
        if(Main.debugmode) {
            font.draw(batch, "Picked cards: " + player1.getCurrentCards(), 0, 50);
        }
        batch.end();
    }

    @Override
    public void simulateRound(){
        if (Main.debugmode){
            try {
                gameLogic.doRoundTesting();
                cardsToPickFrom = gameLogic.cardsToPickFrom;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean keyUp(int keyCode){
        if(!pause) {
            if (!Main.debugmode) {
                gameLogic.moveAndUpdate(player1, keyCode);              // Single step game
            }else{
                gameLogic.selectCardsFromKeyboardInput(keyCode);        // Round based game
            }
        }
        return false;
    }
}
