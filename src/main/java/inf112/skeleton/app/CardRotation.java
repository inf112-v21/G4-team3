package inf112.skeleton.app;

public class CardRotation {

    public static Rotation rotation;
    public static Rotation RotationValue;

    public CardRotation(Rotation rotation, Rotation RotationValue) {
        this.rotation = rotation;
        this.RotationValue = RotationValue;
    }

    public void setRotation(Rotation rotation) {
        this.rotation = rotation;
    }

    public Rotation getRotation(Rotation rotation) {
        return rotation;
    }

    public void setRotationValue(Rotation RotationValue) {
        this.RotationValue = RotationValue;
    }

    public Rotation getRotationValue(Rotation RotationValue) {
        return RotationValue;
    }


    public enum Rotation {
        ROTATERIGHT(90),
        ROTATELEFT(270),
        UTURN(180);

        private int value;

        private Rotation(int value) {
            this.value = value;
        }
    }


    }


