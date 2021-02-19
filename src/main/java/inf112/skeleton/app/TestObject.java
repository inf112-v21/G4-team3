package inf112.skeleton.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestObject implements Serializable {

    public Integer value = 0;
    public ArrayList<String> listCards = new ArrayList<>();

    public void changeValue(){
        value = 1;
    }
    public void setCards(){
        listCards = new ArrayList<>(Arrays.asList("Forwards", "Forwards", "Forwards", "Forwards", "Forwards", "Forwards", "Forwards", "Forwards", "Forwards"));
    }

}
