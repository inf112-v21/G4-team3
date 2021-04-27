package inf112.skeleton.app;

import inf112.skeleton.app.Network.Networking;
import inf112.skeleton.app.Network.WaitThread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
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
    public Board board;
    public boolean pause = false;
    private WaitThread thread1;
    private boolean startThread = true;
    public int nCards = 5;  // How many cards each player can pick
    private int nTurn = 5;
    private boolean firstTurn = true;
    public boolean random = true;
    public boolean wait = true;

    public GameLogic(Networking connection, Player player1, Player player2, Board board){
        this.connection = connection;
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
    }

    public void sendCardsToOtherPlayer() throws IOException {
        // Send cards to other player
        System.out.println("You picked " + player1.getCurrentCards());
        System.out.println("\n-Sending cards-\n");
        connection.sendCards(player1.getCurrentCards());
    }

    // One round starts with picking cards or powering down, then does five turns
    public void doRound() throws IOException, ClassNotFoundException, InterruptedException {
        if (pickingCards) {
            pickCards();
        }
        if (player1.getCurrentCards().size()==nCards && readyTurn == false) {

            // Wait for cards in one thread
            if(startThread) {
                thread1 = new WaitThread("thread-1", connection);
                sendCardsToOtherPlayer();
                savedCards = (ArrayList<Enum>) player1.getCurrentCards().clone();
                thread1.start();
                startThread = false;
                System.out.println("Waiting on cards from other player");
            }
            receivedCards = thread1.cards;
            if(receivedCards.size() > 1){
                System.out.println("Received cards now");
                readyTurn = true;
            }
        }
        if (readyTurn){
            simulateTurns();
        }
    }

    public void doRoundTesting() throws InterruptedException {
        if (pickingCards) {
            pickCards();
        }
        if (player1.getCurrentCards().size()>=nCards) {
            savedCards = (ArrayList<Enum>) player1.getCurrentCards().clone();
            readyTurn = true;
        }
        if (readyTurn){
            simulateTurns();
        }
    }

    public void simulateTurns() throws InterruptedException {
        // Do turns for the players
        nTurn--;
        if (player2 != null) {
            player2.pickedCards = receivedCards;
            // Chose who goes first at random
            Random rand = new Random();
            int upperLim = 2;
            int rand_int;
            if (random) {
                rand_int = rand.nextInt(upperLim);
            }else {
                rand_int = 1;
            }
            if (rand_int == 1) {
                turn(player1, player2);
                turn(player2, player1);
            } else {
                turn(player2, player1);
                turn(player1, player2);
            }
            board.updateBoard(player2);
        }else{
            turn(player1, null);
        }
        board.updateBoard(player1);

        // Wait in order to show the robots actions round by round
        if (wait) {
            TimeUnit.SECONDS.sleep(1);
        }
        if (nTurn == 0) {
            pickingCards = true;
            readyTurn = false;
            startThread = true;
            nTurn = 5;
            lockCardsBasedOnHP(player1);
        }
    }

    // Do one turn of player actions
    public void turn(Player player1, Player player2){
        board.deletePlayerTexture(player1);
        player1.move(player1.pickedCards.remove(0), board);
        checkCollision(player1, player2);
    }

    private void checkCollision(Player player1, Player player2){
        if(player2 != null && player1.playerPos.equals(player2.playerPos)){
            board.setPlayer(player2);
            player2.moveInDir(player1.dir, 1, board);
            if(player1.playerPos.equals(player2.playerPos)){
                board.setPlayer(player1);
                player1.moveBack1();
            }
        }
    }

    public void moveAndUpdate(Player player, int keyCode){
        board.deletePlayerTexture(player);
        player.move(debugMovement(keyCode), board);
        board.updateBoard(player);
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
        System.out.println("The host is TV robot");
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
