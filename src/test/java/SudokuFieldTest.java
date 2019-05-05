import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;


class SudokuFieldTest {

    @Test
    void setFieldValue() {
        SudokuField sudokuField = new SudokuField();
        sudokuField.setFieldValue(5);
        assertEquals(5, sudokuField.getFieldValue());

    }

    @Test
    void getFieldValue() {
        SudokuField sudokuField = new SudokuField();
        sudokuField.setFieldValue(5);
        assertEquals(5, sudokuField.getFieldValue());
    }

    @Test
    void checkOverrideEquals()
    {
        SudokuField sudokuField = new SudokuField();
        sudokuField.setFieldValue(5);
        SudokuField sudokuField2 = new SudokuField();
        sudokuField2.setFieldValue(5);
        assertEquals(true, sudokuField.equals(sudokuField2));
    }

    @Test
    void checkOverrideEqualsWrong()
    {
        SudokuField sudokuField = new SudokuField();
        sudokuField.setFieldValue(5);
        SudokuField sudokuField2 = new SudokuField();
        sudokuField2.setFieldValue(7);
        assertEquals(false, sudokuField.equals(sudokuField2));
    }

    @Test
    void checkOverrideEqualsTheSame()
    {
        SudokuField sudokuField = new SudokuField();
        sudokuField.setFieldValue(5);
        assertEquals(true, sudokuField.equals(sudokuField));
    }

    @Test
    void checkToString()
    {
        SudokuField sudokuField = new SudokuField();
        System.out.println(sudokuField.toString());
    }

}