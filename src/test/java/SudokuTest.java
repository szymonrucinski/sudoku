
import org.junit.Test;
import static org.junit.Assert.*;

public class SudokuTest {


    @Test
    public void TestIfCorrect() {

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

        SudokuBoard quiz = new SudokuBoard(solution);
        quiz.getcheckBoard();





        assertEquals(true,quiz.getcheckBoard());

    };


    @Test
    public void TestIfNotCorrect() {
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


        SudokuBoard quiz = new SudokuBoard(boardToSolve);
        quiz.getcheckBoard();

        assertEquals(false,quiz.getcheckBoard());

    };



    @Test
    public void DisplayaRRAY() {
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


        SudokuBoard quiz = new SudokuBoard(boardToSolve);
        quiz.getcheckBoard();
        int k;


        for(int i =0; i<quiz.ListOfSudokuColumn.size();i++)
        {
             k = quiz.ListOfSudokuColumn.get(i).getFieldValue();
             System.out.println(k);
             if(i%9==8) System.out.println("Column no."+((i+1)/9)+"------------");

        }

        for(int i =0; i<quiz.ListOfSudokuRows.size();i++)
        {
            k = quiz.ListOfSudokuRows.get(i).getFieldValue();
            System.out.println(k);
            if(i%9==8) System.out.println("Row no."+((i+1)/9)+"------------");

        }


        assertEquals(false,quiz.getcheckBoard());

    };



    public static void main(String[] args){



    }

}
