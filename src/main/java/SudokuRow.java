

public class SudokuRow extends SudokuElement {


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

    boolean verify(int number){

        for (int i = 0; i < 9; i++) {
            if (RowOfSudokuFields[i] == null && RowOfSudokuFields[i].getFieldValue()==number);return false;
            //Jezeli kolumna pol sudoku jest rozna od nulla i columnapolsudoku jest rozna od liczby
        }

        // no duplicates found
        return true;

    }


    };
