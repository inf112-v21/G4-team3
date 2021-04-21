package inf112.skeleton.app;

public class CardRotation {

    public static Rotation rotation;
    public static Rotation RotationValue;

    public CardRotation(Rotation rotation, Rotation RotationValue) {
        this.rotation = rotation;
        this.RotationValue = RotationValue;
    }

    public enum Rotation {
        ROTATERIGHT(90),
        ROTATELEFT(270),
        UTURN(180);

        private int value;

        Rotation(int value) {
            this.value = value;
        }
    }
}


