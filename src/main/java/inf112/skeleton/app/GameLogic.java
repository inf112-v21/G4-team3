package inf112.skeleton.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GameLogic {

    public ArrayList<Enum> receivedCards = new ArrayList<>();
    public ArrayList<Enum> savedCards = new ArrayList<>();
    public ArrayList<Enum> startCards = new ArrayList<>();
    public ArrayList<Enum> cardsToPickFrom = new ArrayList<>();
    public boolean pickingCards = true;
    public boolean readyTurn = false;
    public Networking connection;
    public Player player1;
    public Player player2;
    public static Board board;

    // How many cards each player can pick
    public int nCards = 5;
    private boolean firstTurn = true;

    public GameLogic(Networking connection, Player player1, Player player2, Board board){
        this.connection = connection;
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
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
        System.out.println(player1.getCurrentCards());
        System.out.println(savedCards);
        if (player2 != null) {
            turn(player2, receivedCards);
        }
        TimeUnit.SECONDS.sleep(1);
        if (player1.pickedCards.size() == 0) {
            pickingCards = true;
            readyTurn = false;
            lockCardsBasedOnHP(player1);
        }
    }

    // One round starts with picking cards or powering down, then does five turns
    public void doRound() throws IOException, ClassNotFoundException, InterruptedException {
        if (pickingCards){
            getCardsFromOtherPlayer();
            pickCards();
        }
        if (player1.pickedCards.size()==nCards) {
            sendCardsToOtherPlayer();
            savedCards = (ArrayList<Enum>) player1.getCurrentCards().clone();
            readyTurn = true;
        }
        if (readyTurn){
            simulateTurns();
        }
    }
    public void doRoundClient() throws IOException, ClassNotFoundException, InterruptedException {
        if (pickingCards) {
            pickCards();
        }
        if (player1.getCurrentCards().size()==nCards) {
            sendCardsToOtherPlayer();
            getCardsFromOtherPlayer();
            savedCards = (ArrayList<Enum>) player1.getCurrentCards().clone();
            readyTurn = true;
        }
        if (readyTurn){
            simulateTurns();
        }
    }

    public void doRoundTesting() throws InterruptedException {
        if (pickingCards) {
            pickCards();
        }
        if (player1.getCurrentCards().size()==nCards) {
            savedCards = (ArrayList<Enum>) player1.getCurrentCards().clone();
            readyTurn = true;
        }
        if (readyTurn){
            simulateTurns();
        }
    }

    // Do one turn of player actions
    public void turn(Player player, ArrayList<Enum> cards){
        board.deletePlayerTexture(player);
        player.move(cards.remove(0), board);
        board.updateBoard(player);
    }

    public void moveAndUpdate(Player player, int keyCode){
        board.deletePlayerTexture(player);
        player.move(debugMovement(keyCode), board);
        board.updateBoard(player);
        //nPickedCard++;
    }

    private void lockCardsBasedOnHP(Player player){
        int diffHP = player.getMaxHP() - player.getCurrentHP();
        for (int i=0; i<diffHP; i++){
            startCards.add(savedCards.get(i));
        }
    }

    // Display 9 cards and let the player pick 5
    public void pickCards(){
        System.out.println("\nYour turn to pick cards");
        System.out.println("Use numbers 1 to 9 to pick cards");
        System.out.println("The host is the black character");
        CardDeck fullDeck = new CardDeck();
        cardsToPickFrom.clear();
        player1.pickedCards = startCards;
        pickingCards = false;
        firstTurn = true;

        for (int i = 0; i <= 8; i++) {
            Enum draw = fullDeck.deck.get(i);
            cardsToPickFrom.add(draw);
        }
    }
    
    private void powerDown(Player player){
        player.setHP(player.getMaxHP());
        // Set all cards to null (no actions this round)
        player1.pickedCards.clear();
        for(int i=0; i<nCards; i++){
            player.pickedCards.add(null);
        }
    }

    public void selectCardsFromKeyboardInput(int keyCode) {
        if (player1.getCurrentCards().size() < nCards && (!readyTurn || Main.debugmode)){
            if (firstTurn && keyCode == 44) {
                powerDown(player1);
            }
            else{
                Enum card;
                if (Main.debugmode){
                    card = debugMovement(keyCode);
                } else{
                    card = cardActions(keyCode);
                }
                if (card != null) {
                    player1.pickedCards.add(card);
                    firstTurn = false;
                    if (Main.debugmode) {
                        System.out.println("Available cards:");
                        System.out.println(cardsToPickFrom);
                    }
                }
            }
        }
    }

    private Enum cardActions(int keyCode){
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
        return card;
    }

    public Enum debugMovement(int keyCode){
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
        return card;
    }
}
