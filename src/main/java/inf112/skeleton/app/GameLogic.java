package inf112.skeleton.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GameLogic {

    //public ArrayList<Enum> pickedCards = new ArrayList<>();
    public ArrayList<Enum> receivedCards = new ArrayList<>();
    public ArrayList<Enum> savedCards = new ArrayList<>();
    public ArrayList<Enum> startCards = new ArrayList<>();
    public ArrayList<Enum> cardsToPickFrom = new ArrayList<>();
    public boolean pickingCards = true;
    public boolean readyTurn = false;
    public Networking connection;
    public Player player1;
    public Player player2;
    public Board board;

    // How many cards each player can pick
    public int nCards = 5;

    public GameLogic(Networking connection, Player player1, Player player2, Board board){
        this.connection = connection;
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
    }

    // One round starts with picking cards or powering down, then does five turns
    public void doRound() throws IOException, ClassNotFoundException, InterruptedException {
        if (pickingCards){
            getCardsFromOtherPlayer();
            pickCards();
        }
        if (player1.pickedCards.size()==nCards) {
            sendCardsToOtherPlayer();
            readyTurn = true;
        }
        if (readyTurn){
            simulateTurns();
        }
    }

    public void getCardsFromOtherPlayer() throws IOException, ClassNotFoundException {
        // Wait for client input
        System.out.println("\n-Wait to receive the other player's cards-");
        receivedCards = (ArrayList<Enum>) connection.receiveCards();
        System.out.println("\nYour opponent picked the cards:");
        System.out.println(receivedCards);
    }

    public void sendCardsToOtherPlayer() throws IOException {
        // Send cards to other player
        System.out.println("You picked " + player1.getCurrentCards());
        System.out.println("\n-Sending cards-\n");
        connection.sendCards(player1.getCurrentCards());
    }

    public void simulateTurns() throws InterruptedException {
        // Do turns for the players
        System.out.println("Doing turn");
        turn(player1, player1.pickedCards);
        turn(player2, receivedCards);
        TimeUnit.SECONDS.sleep(1);
        if (player1.pickedCards.size() == 0) {
            pickingCards = true;
            readyTurn = false;
            lockCardsBasedOnHP(player1);
        }
    }

    public void doRoundClient() throws IOException, ClassNotFoundException, InterruptedException {
        if (pickingCards) {
            pickCards();
        }
        if (player1.getCurrentCards().size()==nCards) {
            sendCardsToOtherPlayer();
            getCardsFromOtherPlayer();
            savedCards=player1.getCurrentCards();
            readyTurn = true;
        }
        if (readyTurn){
            simulateTurns();
        }
    }

    // Do one turn of player actions
    public void turn(Player player, ArrayList<Enum> cards){
        board.deletePlayerTexture(player);
        player.move(cards.remove(0));
        board.updateBoard(player);
    }

    public void moveAndUpdate(Player player, int keyCode){
        board.deletePlayerTexture(player);
        player.move(debugMovement(keyCode));
        board.updateBoard(player);
    }

    private void lockCardsBasedOnHP(Player player){
        int diffHP = player.getMaxHP() - player.getCurrentHP();
        nCards = nCards - diffHP;
        for (int i=0; i<diffHP; i++){
            startCards.add(savedCards.get(i));
        }
    }

    // Display 9 cards and let the player pick 5
    public void pickCards(){
        System.out.println("\nYour turn to pick cards");
        System.out.println("Use numbers 1 to 9 to pick cards");
        System.out.println("The player that is hosting the game is the black character");
        CardDeck fullDeck = new CardDeck();
        cardsToPickFrom.clear();
        //player1.getCurrentCards().clear();
        player1.pickedCards = startCards;
        pickingCards = false;

        for (int i = 0; i <= 8; i++) {
            Enum draw = fullDeck.deck.get(i);
            cardsToPickFrom.add(draw);
        }
        if(Main.debugmode)
            System.out.println("1 : MOVE1; 2 : MOVE2; 3 : MOVE3; 4 : BACKUP; 5 : ROTATELEFT; 6 : ROTATERIGHT; 7 : UTURN");
        else{
            System.out.println("Available cards:");
            System.out.println(cardsToPickFrom);
        }
    }

    public Enum debugMovement(int keyCode){
       //& !readyTurn) {
        // p = 44
        Enum card = null;
        if (keyCode == 8) {
            card = CardMovement.Movement.MOVE1;
        } else if (keyCode == 9) {
            card = CardMovement.Movement.MOVE2;
        } else if (keyCode == 10) {
            card = CardMovement.Movement.MOVE3;
        } else if (keyCode == 11) {
            card = CardMovement.Movement.BACKUP;
        } else if (keyCode == 12) {
            card = CardRotation.Rotation.ROTATELEFT;
        } else if (keyCode == 13) {
            card = CardRotation.Rotation.ROTATERIGHT;
        } else if (keyCode == 14) {
            card = CardRotation.Rotation.UTURN;
        } else if (keyCode == 21) { //left
            card = CardRotation.Rotation.ROTATELEFT;
        } else if (keyCode == 19) { //up
            card = CardMovement.Movement.MOVE1;
        }else if (keyCode == 22) { //Right
            card = CardRotation.Rotation.ROTATERIGHT;
        }else if (keyCode == 20) { //Down
            card = CardMovement.Movement.BACKUP;
        }

        System.out.println("1 : MOVE1; 2 : MOVE2; 3 : MOVE3; 4 : BACKUP; 5 : ROTATELEFT; 6 : ROTATERIGHT; 7 : UTURN");

        return card;
    }

    public void selectCardsFromKeyboardInput(int keyCode) {
        if (Main.debugmode)
            player1.getCurrentCards().add(debugMovement(keyCode));
        else {
            if (player1.getCurrentCards().size() < nCards && !readyTurn) {
                // p = 44
                Enum card = null;
                if (keyCode == 8) {
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
                player1.pickedCards.add(card);
                System.out.println("Available cards:");
                System.out.println(cardsToPickFrom);
            }
        }
    }
}
