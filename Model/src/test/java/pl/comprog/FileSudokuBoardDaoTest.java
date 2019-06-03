package pl.comprog;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;




public class FileSudokuBoardDaoTest {

    @Test
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


}