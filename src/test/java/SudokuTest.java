
import org.junit.Test;
import static org.junit.Assert.*;

public class SudokuTest {


    @Test
    public void TestIfCorrect() {
        int[][] solution = {
                {9,3,4,1,7,2,6,8,5},
                {7,6,5,8,9,3,2,4,1},
                {8,1,2,6,4,5,3,9,7},
                {4,2,9,5,8,1,7,6,3},
                {6,5,8,7,3,9,1,2,4},
                {1,7,3,4,2,6,8,5,9},
                {2,9,7,3,5,8,4,1,6},
                {5,4,6,2,1,7,9,3,8},
                {3,8,1,9,6,4,5,7,2},
        };

        Sudoku quiz = new Sudoku();
        TypeSudokuSolver BacktrackingSudokuSolver = new TypeSudokuSolver();
        BacktrackingSudokuSolver.solve(quiz);
        assertEquals(solution,quiz.getBoard());

    };

    public static void main(String[] args){
        Sudoku quiz = new Sudoku();
        TypeSudokuSolver BacktrackingSudokuSolver = new TypeSudokuSolver();
        BacktrackingSudokuSolver.solve(quiz);
    }

}