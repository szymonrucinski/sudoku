package pl.comp.model.ForTest;
import pl.comp.model.sudoku.*;
import org.junit.Test;

public class lvdTest {

    @Test
    public void Test(){
        LevelDifficulty lvd = new LevelDifficulty();
        BackTrackingSudokuSolver solver = new BackTrackingSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard();

        SudokuBoard copy = (SudokuBoard) sudoku.clone();

        solver.solve(sudoku);
        lvd.selectLevel(sudoku,2);
        sudoku.display();

    }
}
