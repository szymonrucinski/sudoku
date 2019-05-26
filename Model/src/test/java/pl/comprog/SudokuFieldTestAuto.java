package pl.comprog;

import org.junit.Test;


public class SudokuFieldTestAuto {

    @Test
    public void DeepCopy() {
        SudokuBoard quiz = new SudokuBoard();
        SudokuBoard test = (SudokuBoard)quiz.clone();


        BackTrackingSudokuSolver solver = new BackTrackingSudokuSolver();
        solver.solve(test);
        SudokuField field = new SudokuField();
        SudokuColumn column = (SudokuColumn) quiz.getColumn(5).clone();
        System.out.println(field.getFieldValue());


        test.display();
        quiz.display();


    }
}