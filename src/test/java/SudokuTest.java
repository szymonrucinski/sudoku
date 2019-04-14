
import org.junit.Test;
import static org.junit.Assert.*;

public class SudokuTest {

    int[][] solution = {
            {9, 3, 4, 1, 7, 2, 6, 8, 5},
            {7, 6, 5, 8, 9, 3, 2, 4, 1},
            {8, 1, 2, 6, 4, 5, 3, 9, 7},
            {4, 2, 9, 5, 8, 1, 7, 6, 3},
            {6, 5, 8, 7, 3, 9, 1, 2, 4},
            {1, 7, 3, 4, 2, 6, 8, 5, 9},
            {2, 9, 7, 3, 5, 8, 4, 1, 6},
            {5, 4, 6, 2, 1, 7, 9, 3, 8},
            {3, 8, 1, 9, 6, 4, 5, 7, 2},
    };

    int[][] boardToSolve = {
            {9, 0, 0, 1, 0, 0, 0, 0, 5},
            {0, 0, 5, 0, 9, 0, 2, 0, 1},
            {8, 0, 0, 0, 4, 0, 0, 0, 0},
            {0, 0, 0, 0, 8, 0, 0, 0, 0},
            {0, 0, 0, 7, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 2, 6, 0, 0, 9},
            {2, 0, 0, 3, 0, 0, 0, 0, 6},
            {0, 0, 0, 2, 0, 0, 9, 0, 0},
            {0, 0, 1, 9, 0, 4, 5, 7, 0},
    };

    @Test
    public void TestIfCorrect() {
        SudokuBoard quiz = new SudokuBoard(solution);
        quiz.fillBoard();
        quiz.getcheckBoard();
        assertEquals(true,quiz.getcheckBoard());

    };


    @Test
    public void TestIfNotCorrect() {
        SudokuBoard quiz = new SudokuBoard(boardToSolve);
        quiz.getcheckBoard();

        assertEquals(false,quiz.getcheckBoard());
    };



    @Test
    public void DisplayaRRAY() {

        SudokuBoard quiz = new SudokuBoard(boardToSolve);
        quiz.getcheckBoard();
        int k;


        assertEquals(false,quiz.getcheckBoard());

    };

    @Test
    public void DisplaySudokFieldsList() {


        SudokuBoard quiz = new SudokuBoard(boardToSolve);
        quiz.fillBoard();
        quiz.getcheckBoard();
        int k;



    System.out.println(quiz.ListOfSudokuColumn.size());
        System.out.println(quiz.ListOfSudokuRows.size());
        System.out.println(quiz.ListOfSudokuFields.size());
        System.out.println(quiz.ListOfSudokuRows.size());




        assertEquals(false,quiz.getcheckBoard());

    };


    @Test
    public void DisplaySudokuRowsList() {


        SudokuBoard quiz = new SudokuBoard(boardToSolve);
        int k;

        quiz.fillBoard();

        for(int i =0; i<quiz.ListOfSudokuFields.size();i++)
        {

            for(int j=0;j<quiz.ListOfSudokuFields.size();j++)
            {


                k = quiz.ListOfSudokuRows.get(i).RowOfSudokuFields[j].getFieldValue();
                System.out.println(k);
                if(j==8) System.out.println("Row number"+ i);

            }
        }






        assertEquals(false,quiz.getcheckBoard());

    };


    @Test
    public void DisplaySudokuColumnsList() {



        SudokuBoard quiz = new SudokuBoard(boardToSolve);
        quiz.getcheckBoard();
        int k;


for(int j=0;j<9;j++) {
    quiz.ListOfSudokuColumn.get(j).show();
}





        System.out.println(quiz.ListOfSudokuColumn.size());
        System.out.println(quiz.ListOfSudokuRows.size());
        System.out.println(quiz.ListOfSudokuFields.size());
        System.out.println(quiz.ListOfSudokuRows.size());




        assertEquals(false,quiz.getcheckBoard());

    };


    @Test
    public void DisplayBoxesList() {


        SudokuBoard quiz = new SudokuBoard(boardToSolve);
        quiz.getcheckBoard();
        int k;

        quiz.ListOfSudokuBoxes.get(0).show();
        quiz.ListOfSudokuBoxes.get(1).show();
        quiz.ListOfSudokuBoxes.get(2).show();






        System.out.println(quiz.ListOfSudokuColumn.size());
        System.out.println(quiz.ListOfSudokuRows.size());
        System.out.println(quiz.ListOfSudokuFields.size());
        System.out.println(quiz.ListOfSudokuRows.size());




        assertEquals(false,quiz.getcheckBoard());

    };







    public static void main(String[] args){



    }

}
