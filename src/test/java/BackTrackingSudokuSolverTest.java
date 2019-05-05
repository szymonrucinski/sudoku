import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;


public class BackTrackingSudokuSolverTest
{

    public BackTrackingSudokuSolverTest() {

    }

    @Test
    public void testFillEmptyBoard() {

        SudokuBoard sudokuBoard = new SudokuBoard();
        BackTrackingSudokuSolver sudoku = new BackTrackingSudokuSolver();
        sudoku.solve(sudokuBoard);
        assertEquals(true, sudokuBoard.checkBoard());
       // sudokuBoard.display();
    }

    @Test
    public void testFillExampleSudoku() {
        SudokuBoard sudoku = new SudokuBoard();

        //column 1
        sudoku.set(0, 0, 4);
        sudoku.set(1, 0, 7);
        sudoku.set(2, 0, 1);
        sudoku.set(3, 0, 9);
        sudoku.set(4, 0, 3);
        //column 2
        sudoku.set(5, 1, 7);
        //column 3
        sudoku.set(0, 2, 9);
        sudoku.set(2, 2, 8);
        sudoku.set(6, 2, 7);
        //column 4
        sudoku.set(0, 3, 8);
        sudoku.set(1, 3, 6);
        sudoku.set(4, 3, 4);
        sudoku.set(5, 3, 9);
        //column 5
        sudoku.set(0, 4, 1);
        sudoku.set(8, 4, 9);
        //column 6
        sudoku.set(3, 5, 8);
        sudoku.set(4, 5, 1);
        sudoku.set(7, 5, 6);
        sudoku.set(8, 5, 3);
        //column 7
        sudoku.set(2, 6, 4);
        sudoku.set(6, 6, 6);
        sudoku.set(8, 6, 2);
        //column 8
        sudoku.set(3, 7, 6);
        //column 9
        sudoku.set(4, 8, 2);
        sudoku.set(5, 8, 5);
        sudoku.set(6, 8, 8);
        sudoku.set(7, 8, 4);
        sudoku.set(8, 8, 7);

        BackTrackingSudokuSolver sudokuSolver = new BackTrackingSudokuSolver();
        sudokuSolver.solve(sudoku);
        //sudoku.display();
        assertEquals(true, sudoku.checkBoard());

        //row 1
        assertEquals(4, sudoku.get(0, 0));
        assertEquals(3, sudoku.get(0, 1));
        assertEquals(9, sudoku.get(0, 2));
        assertEquals(8, sudoku.get(0, 3));
        assertEquals(1, sudoku.get(0, 4));
        assertEquals(7, sudoku.get(0, 5));
        assertEquals(5, sudoku.get(0, 6));
        assertEquals(2, sudoku.get(0, 7));
        assertEquals(6, sudoku.get(0, 8));
        //row 2
        assertEquals(7, sudoku.get(1, 0));
        assertEquals(2, sudoku.get(1, 1));
        assertEquals(5, sudoku.get(1, 2));
        assertEquals(6, sudoku.get(1, 3));
        assertEquals(4, sudoku.get(1, 4));
        assertEquals(9, sudoku.get(1, 5));
        assertEquals(1, sudoku.get(1, 6));
        assertEquals(8, sudoku.get(1, 7));
        assertEquals(3, sudoku.get(1, 8));
        //row 3
        assertEquals(1, sudoku.get(2, 0));
        assertEquals(6, sudoku.get(2, 1));
        assertEquals(8, sudoku.get(2, 2));
        assertEquals(2, sudoku.get(2, 3));
        assertEquals(3, sudoku.get(2, 4));
        assertEquals(5, sudoku.get(2, 5));
        assertEquals(4, sudoku.get(2, 6));
        assertEquals(7, sudoku.get(2, 7));
        assertEquals(9, sudoku.get(2, 8));
        //row 6
        assertEquals(8, sudoku.get(5, 0));
        assertEquals(7, sudoku.get(5, 1));
        assertEquals(1, sudoku.get(5, 2));
        assertEquals(9, sudoku.get(5, 3));
        assertEquals(6, sudoku.get(5, 4));
        assertEquals(2, sudoku.get(5, 5));
        assertEquals(3, sudoku.get(5, 6));
        assertEquals(4, sudoku.get(5, 7));
        assertEquals(5, sudoku.get(5, 8));
        //row 9
        assertEquals(6, sudoku.get(8, 0));
        assertEquals(8, sudoku.get(8, 1));
        assertEquals(4, sudoku.get(8, 2));
        assertEquals(5, sudoku.get(8, 3));
        assertEquals(9, sudoku.get(8, 4));
        assertEquals(3, sudoku.get(8, 5));
        assertEquals(2, sudoku.get(8, 6));
        assertEquals(1, sudoku.get(8, 7));
        assertEquals(7, sudoku.get(8, 8));
    }

    @Test
    public void testIfSudokuIsRandom() {

        SudokuBoard sudokuBoard1 = new SudokuBoard();
        BackTrackingSudokuSolver backTrackingSudokuSolver = new BackTrackingSudokuSolver();
        backTrackingSudokuSolver.solve(sudokuBoard1);
        SudokuBoard sudokuBoard2 = new SudokuBoard();
        backTrackingSudokuSolver.solve(sudokuBoard2);

        boolean isDifferent = false;

        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (sudokuBoard1.get(j, i) != sudokuBoard2.get(j, i)) {
                    isDifferent = true;
                    break;
                }
            }
        }
        assertEquals(true, isDifferent);

    }

}