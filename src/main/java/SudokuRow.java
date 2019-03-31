
import java.util.ArrayList;

public class SudokuRow {


    SudokuField[] RowOfSudokuFields = new SudokuField[9];

    void show() {

        for (int i = 0; i < 9; i++) {
            System.out.println(RowOfSudokuFields[i].getFieldValue());

        }
    }


    void setRow(int ElementNumber, SudokuField CopiedSudokuField) {
        RowOfSudokuFields[ElementNumber] = CopiedSudokuField;
    }

    ;


    boolean verify() {
        {

            for (int i = 0; i < 9; i++) {
                for (int j = i + 1; j < 9; j++) {
                    if (RowOfSudokuFields[i] != null && RowOfSudokuFields[i].getFieldValue() == (RowOfSudokuFields[j].getFieldValue())) {
                        return false;
                    }
                }
            }

            // no duplicate found
            return true;

        }
    }

}