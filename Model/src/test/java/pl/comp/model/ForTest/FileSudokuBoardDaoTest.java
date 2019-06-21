package pl.comp.model.ForTest;

import org.junit.Test;
import pl.comp.model.exceptions.DaoException;
import pl.comp.model.logger.FileAndConsoleLoggerFactory;
import pl.comp.model.sudoku.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class FileSudokuBoardDaoTest {
    private static final Logger logger = FileAndConsoleLoggerFactory.getConfiguredLogger(FileSudokuBoardDaoTest.class.getName());


    @Test
    public void testCreateDaoWithNullName() {
        assertThrows(DaoException.class, () -> new FileSudokuBoardDao(null));
    }

    @Test
    public void testWriteToNonExistingFile() {
        try (FileSudokuBoardDao dao = new FileSudokuBoardDao("testWriteToNonExistingFile.dat")) {
            SudokuBoard sudokuBoard = new SudokuBoard();
            assertDoesNotThrow(() -> dao.write(sudokuBoard));
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

   /* @Test
    public void testReadFromNonExistingFile() {
        try (FileSudokuBoardDao dao = new FileSudokuBoardDao("testReadFromNonExistingFile.dat")) {
            assertThrows(DaoException.class, () -> dao.read());
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }*/

    @Test
    public void testWriteNullBoard() {
        try (FileSudokuBoardDao dao = new FileSudokuBoardDao("testReadFromNonExistingFile.dat")) {
            assertThrows(DaoException.class, () -> dao.write(null));
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readAndWriteFileTest() {
        SudokuBoard sudokuBoard1 = new SudokuBoard();
        BackTrackingSudokuSolver solver = new BackTrackingSudokuSolver();
        solver.solve(sudokuBoard1);
        SudokuBoardDaoFactory sudokuBoardDaoFactory = new SudokuBoardDaoFactory();
        try (FileSudokuBoardDao dao = (FileSudokuBoardDao) sudokuBoardDaoFactory.getFileDao("testReadFromNonExistingFile.dat")) {
            dao.write(sudokuBoard1);
            SudokuBoard sudokuBoard2 = dao.read();
            assertEquals(sudokuBoard1, sudokuBoard2);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getDatabase() {
        SudokuBoardDaoFactory sudokuBoardDaoFactory = new SudokuBoardDaoFactory();
        try(JdbcSudokuBoardDao dao = (JdbcSudokuBoardDao) sudokuBoardDaoFactory.getDatabaseDao("sudoku")) {
            logger.log(Level.INFO, "Connected to DB");

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteNullBoardToBase() {
        try (JdbcSudokuBoardDao dao = new JdbcSudokuBoardDao("sudoku")) {
            assertThrows(DaoException.class, () -> dao.write(null));
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteBoardToBase() {
        try (JdbcSudokuBoardDao dao = new JdbcSudokuBoardDao("sudoku")) {
            SudokuBoard sudokuBoard = new SudokuBoard();
            BackTrackingSudokuSolver solver = new BackTrackingSudokuSolver();
            solver.solve(sudokuBoard);
            dao.write(sudokuBoard);
            SudokuBoard sudokuBoard2 = dao.read();
            sudokuBoard.display();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readAndWriteBoardTest() {
        SudokuBoard sudokuBoard1 = new SudokuBoard();
        BackTrackingSudokuSolver solver = new BackTrackingSudokuSolver();
        solver.solve(sudokuBoard1);

        SudokuBoardDaoFactory sudokuBoardDaoFactory = new SudokuBoardDaoFactory();
        try (JdbcSudokuBoardDao dao = (JdbcSudokuBoardDao) sudokuBoardDaoFactory.getDatabaseDao("sudoku")) {
            dao.write(sudokuBoard1);
            SudokuBoard sudokuBoard2 = dao.read();
            assertEquals(sudokuBoard1, sudokuBoard2);
            sudokuBoard1.display();
            System.out.println("------------------------");
            sudokuBoard2.display();
            dao.delete();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}