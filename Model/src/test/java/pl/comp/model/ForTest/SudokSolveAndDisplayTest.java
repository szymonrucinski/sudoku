package pl.comp.model.ForTest;
import pl.comp.model.sudoku.*;
import org.junit.Test;

public class SudokSolveAndDisplayTest {

    @Test
    public void TestSudokuAndDisplay() {
        for (int i = 0; i < 5; i++) {
            SudokuBoard sudoku = new SudokuBoard();
            BackTrackingSudokuSolver solver = new BackTrackingSudokuSolver();
            solver.solve(sudoku);
            sudoku.display();
        }
    }
}
