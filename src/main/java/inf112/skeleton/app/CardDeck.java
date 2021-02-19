package inf112.skeleton.app;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
    public static ArrayList<Enum> deck = new ArrayList<>();
    public CardMovement.Movement MovementValue;
    public CardRotation.Rotation RotationValue;

    public CardDeck() {
        for (int i = 0; i <= 41; i++) {
            if (i <= 17) {
                this.MovementValue = CardMovement.Movement.MOVE1;
            } else if (i <= 29) {
                this.MovementValue = CardMovement.Movement.MOVE2;
            } else if (i <= 35) {
                this.MovementValue = CardMovement.Movement.MOVE3;
            } else if (i <= 41) {
                this.MovementValue = CardMovement.Movement.BACKUP;
            }
            this.deck.add(MovementValue);
        }

        for (int i = 41; i <= 82; i++) {
            if (i <= 58) {
                this.RotationValue = CardRotation.Rotation.ROTATERIGHT;
            } else if (i <= 76) {
                this.RotationValue = CardRotation.Rotation.ROTATELEFT;
            } else if (i <= 82) {
                this.RotationValue = CardRotation.Rotation.UTURN;
            }
            this.deck.add(RotationValue);
        }
        Collections.shuffle(this.deck);

    }
}

