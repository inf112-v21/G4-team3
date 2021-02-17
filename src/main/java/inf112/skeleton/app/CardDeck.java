package inf112.skeleton.app;

import java.util.ArrayList;
import java.util.HashMap;



public class CardDeck {
    //HashMap<> CardDeck = new HashMap();
    private ArrayList deck;

    int amountOfMove1 = 0; //18
    int amountOfMove2 = 0; //12
    int amountOfMove3 = 0; //6
    int amountOfMoveBackUp = 0; //6

    public Deck() {
        this.deck = new ArrayList();
/*
        CardMovement cardMovement = new CardMovement();
        cardMovement.movement = cardMovement.getMovement();
        cardMovement.MovementValue = cardMovement.getMovementValue();
        */

        for (int i = 0; i <= 42; i++) {
            int card;
            if (i <= 18) {
                CardMovement.Movement value = CardMovement.Movement.MOVE1;
            } else if (i <= 30) {
                CardMovement.Movement value = CardMovement.Movement.MOVE2;
            } else if (i <= 36) {
                CardMovement.Movement value = CardMovement.Movement.MOVE3;
            } else {
                CardMovement.Movement value = CardMovement.Movement.BACKUP;
            }
            CardMovement cardMovement = new CardMovement;
            this.deck.add(i, value);
        }
        System.out.println(deck);

    }
}

