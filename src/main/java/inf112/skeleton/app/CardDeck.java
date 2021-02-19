package inf112.skeleton.app;

import java.util.ArrayList;

public class CardDeck {
    public static ArrayList<Enum> deck = new ArrayList<>();
    public CardMovement.Movement MovementValue;
    public CardRotation.Rotation RotationValue;

    int amountOfMove1 = 0; //18
    int amountOfMove2 = 0; //12
    int amountOfMove3 = 0; //6
    int amountOfMoveBackUp = 0; //6

    int amountOfRotateRight = 0; //18
    int amountOfRotateLeft = 0; //18
    int amountOfUTurn = 0; //6

    public CardDeck() {
        for (int i = 0; i <= 41; i++) {
            if (i <= 17) {
                this.MovementValue = CardMovement.Movement.MOVE1;
                amountOfMove1 += 1;
            } else if (i <= 29) {
                this.MovementValue = CardMovement.Movement.MOVE2;
                amountOfMove2 += 1;
            } else if (i <= 35) {
                this.MovementValue = CardMovement.Movement.MOVE3;
                amountOfMove3 += 1;
            } else if (i <= 41) {
                this.MovementValue = CardMovement.Movement.BACKUP;
                amountOfMoveBackUp += 1;
            }
            this.deck.add(MovementValue);
        }

        for (int i = 41; i <= 83; i++) {
            if (i <= 59) {
                this.RotationValue = CardRotation.Rotation.ROTATERIGHT;
                amountOfRotateRight += 1;
            } else if (i <= 77) {
                this.RotationValue = CardRotation.Rotation.ROTATELEFT;
                amountOfRotateLeft += 1;
            } else if (i <= 83) {
                this.RotationValue = CardRotation.Rotation.UTURN;
                amountOfUTurn += 1;
            }
            this.deck.add(RotationValue);
        }
        System.out.println(amountOfMove1);
        System.out.println(amountOfMove2);
        System.out.println(amountOfMove3);
        System.out.println(amountOfMoveBackUp);

        System.out.println(amountOfRotateRight);
        System.out.println(amountOfRotateLeft);
        System.out.println(amountOfUTurn);

    }
}

