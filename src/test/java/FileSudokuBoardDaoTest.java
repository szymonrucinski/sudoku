import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;




public class FileSudokuBoardDaoTest {

    @Test
    public void read() {

        SudokuBoard sudokuBoard = new SudokuBoard();
        BackTrackingSudokuSolver sudoku = new BackTrackingSudokuSolver();
        sudoku.solve(sudokuBoard);

        FileSudokuBoardDao fileSudokuBoardDao = new FileSudokuBoardDao("file.dat");
        fileSudokuBoardDao.write(sudokuBoard);

        SudokuBoard sudokuBoard1 = new SudokuBoard();
        sudokuBoard1 = fileSudokuBoardDao.read();


    }


}