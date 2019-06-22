package pl.comp.model.ForTest;

import org.junit.jupiter.api.Test;
import pl.comp.model.exceptions.DaoException;
import pl.comp.model.sudoku.*;
import static org.junit.jupiter.api.Assertions.*;


class JdbcSudokuBoardDaoTest {

    @Test
    public void testCreateDaoWithNullName() {
        assertThrows(DaoException.class, () -> new JdbcSudokuBoardDao(null));
    }

    @Test
    public void testWriteNullBoard() {
        try (JdbcSudokuBoardDao dao = new JdbcSudokuBoardDao("sudoku")) {
            assertThrows(DaoException.class, () -> dao.write(null));
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readAndWriteBoardTest() {
        SudokuBoard sudokuBoard1 = new SudokuBoard();
        SudokuSolver solver = new BackTrackingSudokuSolver();
        solver.solve(sudokuBoard1);

        SudokuBoardDaoFactory sudokuBoardDaoFactory = new SudokuBoardDaoFactory();
        try (JdbcSudokuBoardDao dao = (JdbcSudokuBoardDao) sudokuBoardDaoFactory.getDatabaseDao("sudoku")) {
            dao.write(sudokuBoard1);
            SudokuBoard sudokuBoard2 = dao.read();
            assertEquals(sudokuBoard1, sudokuBoard2);
            dao.delete();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }


}