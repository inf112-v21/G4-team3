package inf112.skeleton.app;

import java.io.IOException;
import java.util.ArrayList;

public class GameLogicClient extends GameLogic {


    public GameLogicClient(Client client, Player player1, Player player2, Board board) {
        super(client, player1, player2, board);
    }

    @Override
    public void round() throws IOException, ClassNotFoundException {

        if (pickingCards) {
            showCards=true;
            pickCards();
        }

        if (pickedCards.size()==nCards) {
            System.out.println("Sending " + pickedCards);
            client.sendCards(pickedCards);
            pickingCards=true;

            // Delete previous player textures before moving
            board.playerLayer.setCell((int) player1.playerPos.x, (int) player1.playerPos.y, null);
            board.playerLayer.setCell((int) player2.playerPos.x, (int) player2.playerPos.y, null);
            System.out.println("\n-Wait to receive game state-\n");
            ArrayList<Player> playerStates = client.receiveGameState();
            player1 = playerStates.get(0);
            player2 = playerStates.get(1);

        }
    }

}
