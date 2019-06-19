package pl.comp.model.ForTest;
import pl.comp.model.sudoku.*;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;


public class SudokuFieldTest {

    @Test
    public   void setFieldValue() {
        SudokuField sudokuField = new SudokuField();
        sudokuField.setFieldValue(5);
        assertEquals(5, sudokuField.getFieldValue());

    }

    @Test
    public    void getFieldValue() {
        SudokuField sudokuField = new SudokuField();
        sudokuField.setFieldValue(5);
        assertEquals(5, sudokuField.getFieldValue());
    }

    @Test
    public  void checkOverrideEquals()
    {
        SudokuField sudokuField = new SudokuField();
        sudokuField.setFieldValue(5);
        SudokuField sudokuField2 = new SudokuField();
        sudokuField2.setFieldValue(5);
        assertEquals(true, sudokuField.equals(sudokuField2));
    }

    @Test
    public  void checkOverrideEqualsWrong()
    {
        SudokuField sudokuField = new SudokuField();
        sudokuField.setFieldValue(5);
        SudokuField sudokuField2 = new SudokuField();
        sudokuField2.setFieldValue(7);
        assertEquals(false, sudokuField.equals(sudokuField2));
    }

    @Test
    public   void checkOverrideEqualsTheSame()
    {
        SudokuField sudokuField = new SudokuField();
        sudokuField.setFieldValue(5);
        assertEquals(true, sudokuField.equals(sudokuField));
    }

    @Test
    public  void checkToString()
    {
        SudokuField sudokuField = new SudokuField();
        System.out.println(sudokuField.toString());
    }












}