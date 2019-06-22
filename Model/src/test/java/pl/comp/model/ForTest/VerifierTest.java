package pl.comp.model.ForTest;

import pl.comp.model.sudoku.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class VerifierTest {

    @Test
    public void addField() {

        SudokuColumn sudokuColumn = new SudokuColumn();

        for (int i = 0; i < 9; i++) {
            SudokuField sudokuField = new SudokuField();
            sudokuField.setFieldValue(i);
            sudokuColumn.addField(sudokuField);
        }
        assertEquals(true, sudokuColumn.verify());
    }


    @Test
    public void checkOverrideEquals() {
        SudokuColumn sudokuColumn = new SudokuColumn();
        SudokuColumn sudokuColumn1 = new SudokuColumn();
        for (int i = 0; i < 9; i++) {
            SudokuField sudokuField = new SudokuField();
            sudokuField.setFieldValue(i);
            sudokuColumn.addField(sudokuField);
            sudokuColumn1.addField(sudokuField);
        }
        assertEquals(true, sudokuColumn.equals(sudokuColumn1));
    }

    @Test
    public void checkOverrideEqualsWrong() {
        SudokuColumn sudokuColumn = new SudokuColumn();
        SudokuColumn sudokuColumn1 = new SudokuColumn();
        for (int i = 0; i < 9; i++) {
            SudokuField sudokuField = new SudokuField();
            sudokuField.setFieldValue(i);
            sudokuColumn.addField(sudokuField);

            SudokuField sudokuField1 = new SudokuField();
            sudokuField1.setFieldValue(3);
            sudokuColumn1.addField(sudokuField1);
        }
        assertEquals(false, sudokuColumn.equals(sudokuColumn1));
    }

    @Test
    public void checkOverrideEqualsTheSame() {
        SudokuColumn sudokuColumn = new SudokuColumn();

        for (int i = 0; i < 9; i++) {
            SudokuField sudokuField = new SudokuField();
            sudokuField.setFieldValue(i);
            sudokuColumn.addField(sudokuField);
        }
        assertEquals(true, sudokuColumn.equals(sudokuColumn));
    }

    @Test
    public void checkToString() {
        SudokuColumn sudokuColumn = new SudokuColumn();
        System.out.println(sudokuColumn.toString());
    }
}