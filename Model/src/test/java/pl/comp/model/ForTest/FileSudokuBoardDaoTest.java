package pl.comp.model.ForTest;

import org.junit.Test;
import pl.comp.model.exceptions.DaoException;
import pl.comp.model.sudoku.*;


import static org.junit.jupiter.api.Assertions.assertThrows;


public class FileSudokuBoardDaoTest {

 /*   @Test
    public void read() {

        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.set(0,0,0);
        BackTrackingSudokuSolver sudoku = new BackTrackingSudokuSolver();
        sudoku.solve(sudokuBoard);

        FileSudokuBoardDao fileSudokuBoardDao = new FileSudokuBoardDao("saveTest.dat");
        fileSudokuBoardDao.write(sudokuBoard);

        SudokuBoard sudokuBoard1 = new SudokuBoard();
        sudokuBoard1 = fileSudokuBoardDao.read();

        sudokuBoard1.display();

        assertEquals(true,sudokuBoard1.equals(sudokuBoard));

    }
*/
 @Test
 public void testCreateDaoWithNullName() {
     assertThrows(DaoException.class, () -> new FileSudokuBoardDao(null));
 }

}