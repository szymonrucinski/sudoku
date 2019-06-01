package gui;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import java.awt.*;

public class inputBox {

     int value =0;
     static TextField inside;

    public static TextField createBox(int x, int y, int sudokuValue){

        javafx.scene.control.TextField field = new javafx.scene.control.TextField("" + sudokuValue);

        int maxDigits = 1;
        field.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (newValue.length() == 4 && oldValue.length() != 5) {
                field.setText(newValue + "/");
            } else if (newValue.length() == 7 && oldValue.length() != 8 || newValue.length() == 10 && oldValue.length() != 13) {
                field.setText(newValue + ".");
            }
            if (newValue.length() > maxDigits) {
                field.setText(oldValue);
            }

            int newValueConverted = Integer.parseInt(newValue);
            System.out.println(newValueConverted+":"+x+":"+y);
        });

        inside=field;
        return field;
    }
    public  String get() {
    return inside.textProperty().getValue();
    }



}
