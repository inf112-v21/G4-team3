package inf112.skeleton.app;

public class CardMovement{

    public static Movement movement;
    public static Movement MovementValue;

    public CardMovement(Movement movement, Movement MovementValue){
        this.movement = movement;
        this.MovementValue = MovementValue;
    }

    public void setMovement(Movement movement){
        this.movement = movement;
    }

    public Movement getMovement(){
        return movement;
    }

    public void setMovementValue(Movement MovementValue) {
        this.MovementValue = MovementValue;
    }

    public static Movement getMovementValue() {
        return MovementValue;
    }

    public enum Movement{
        MOVE1(1),
        MOVE2(2),
        MOVE3(3),
        BACKUP(-1);

        private int value;
        private Movement(int value){
            this.value = value;
        }


    }


}
