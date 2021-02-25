package inf112.skeleton.app;

import java.io.IOException;
import java.util.ArrayList;

public class GameLogic {

    public ArrayList<Enum> pickedCards = new ArrayList<>();
    public ArrayList<Enum> clientCards = new ArrayList<>();
    public ArrayList<Enum> cardsToPickFrom = new ArrayList<>();
    public boolean pickingCards = true;
    public boolean showCards = true;
    public int nCards = 3;
    public Server server;
    public Client client;
    public Player player1;
    public Player player2;
    public Board board;


    public GameLogic(Client client, Player player1, Player player2, Board board){
        this.client = client;
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
    }
    public GameLogic(Server server, Player player1, Player player2, Board board){
        this.server = server;
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
    }



    // One round starts with picking cards or powering down, then does five turns
    public void doRound() throws IOException, ClassNotFoundException, InterruptedException {
        if (pickingCards){
            // Wait for client input
            System.out.println("\n-Wait for client cards-\n");
            clientCards = (ArrayList<Enum>) server.clientInput();
            System.out.println("\nPlayer2 picked the cards:");
            System.out.println(clientCards);

            System.out.println("\nYour turn to pick cards");
            pickCards();
            showCards = true;
        }

        // Do turns for the players
        if (pickedCards.size()==nCards) {
            System.out.println("You picked "+pickedCards);
            System.out.println("Doing turns");
            for (int i = 0; i < nCards; i++) {
                turn(player1, pickedCards);
                turn(player2, clientCards);
                System.out.println(player1.playerPos);

            }
            // Send information to client
            ArrayList<Player> playerStates = new ArrayList<Player>();
            playerStates.add(player1);
            playerStates.add(player2);
            System.out.println("-Sending game state to client-");
            server.sendGameState(playerStates);
            pickingCards=true;
        }
    }

    // Display 9 cards and let the player pick 5
    public void pickCards(){
        CardDeck fullDeck = new CardDeck();
        for (int i = 0; i <= 8; i++) {
            Enum draw = fullDeck.deck.get(i);
            cardsToPickFrom.add(draw);
        }
        if (showCards){
            System.out.println("Available cards:");
            System.out.println(cardsToPickFrom);
            showCards=false;
        }
        pickedCards = new ArrayList<>();
        pickingCards = false;
    }


    public void selectCards(int keyCode){

        if(pickedCards.size()<nCards) {

            Enum card = null;
            if (keyCode == 8){
                card = cardsToPickFrom.remove(0);
            } else if (keyCode == 9) {
                card = cardsToPickFrom.remove(1);
            } else if (keyCode == 10) {
                card = cardsToPickFrom.remove(2);
            } else if (keyCode == 11) {
                card = cardsToPickFrom.remove(3);
            } else if (keyCode == 12) {
                card = cardsToPickFrom.remove(4);
            } else if (keyCode == 13) {
                card = cardsToPickFrom.remove(5);
            } else if (keyCode == 14) {
                card = cardsToPickFrom.remove(6);
            } else if (keyCode == 15) {
                card = cardsToPickFrom.remove(7);
            } else if (keyCode == 16) {
                card = cardsToPickFrom.remove(8);
            }
            pickedCards.add(card);
            System.out.println("Available cards:");
            System.out.println(cardsToPickFrom);
        }

    }

    // Do one turn of player actions
    public void turn(Player player, ArrayList<Enum> cards){
        // Delete previous player texture before moving
        board.playerLayer.setCell((int) player.playerPos.x, (int) player.playerPos.y, null);
        player.move(cards.remove(0));
    }


    public ArrayList<Player> doRoundClient() throws IOException, ClassNotFoundException {

        ArrayList<Player> playerStates = new ArrayList<Player>();
        playerStates.add(player1);
        playerStates.add(player2);

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
            ArrayList<Player> playerStatesNew = client.receiveGameState();
            player1 = playerStatesNew.get(0);
            player2 = playerStatesNew.get(1);
            board.playerLayer.setCell((int) player1.playerPos.x, (int) player1.playerPos.y, null);
            board.playerLayer.setCell((int) player2.playerPos.x, (int) player2.playerPos.y, null);
            return playerStates;
        }
        return playerStates;
    }
}
