
public class Sudoku {

    private  int[][] board = {                                                             //sudoku board
            {9,0,0,1,0,0,0,0,5},
            {0,0,5,0,9,0,2,0,1},
            {8,0,0,0,4,0,0,0,0},
            {0,0,0,0,8,0,0,0,0},
            {0,0,0,7,0,0,0,0,0},
            {0,0,0,0,2,6,0,0,9},
            {2,0,0,3,0,0,0,0,6},
            {0,0,0,2,0,0,9,0,0},
            {0,0,1,9,0,4,5,7,0},
    };

    public int[][] boardCopy = {                                                             //sudoku board
            {9,0,0,1,0,0,0,0,5},
            {0,0,5,0,9,0,2,0,1},
            {8,0,0,0,4,0,0,0,0},
            {0,0,0,0,8,0,0,0,0},
            {0,0,0,7,0,0,0,0,0},
            {0,0,0,0,2,6,0,0,9},
            {2,0,0,3,0,0,0,0,6},
            {0,0,0,2,0,0,9,0,0},
            {0,0,1,9,0,4,5,7,0},
    };






int get(int row, int column, int value){
    //get method
    if(value==0) return board[row][column];
    else return boardCopy[row][column];
}

    void set(int row, int column, int value){
         board[row][column]=value;
    }
    public int[][] getBoard() {
        return board;
    }

    public int[][] getBoardCopy() {
        return board;
    }
/////////////////////////////////////////////////////////// CheckBoard
    private boolean columnOk(int column, int number) {
        for (int i = 0; i < 9; i++)
            if (board[i][column] == number)
                return true;

        return false;
    }

    private boolean rowsOk(int rows, int number) {
        for (int i = 0; i < 9; i++)
            if (board[rows][i] == number)
                return true;

        return false;
    }



    private boolean GridOk(int rows, int column, int number) {
        int r = rows - rows % 3;
        int c = column - column % 3;

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (board[i][j] == number)
                    return true;

        return false;
    }

    private boolean checkBoard(int rows, int column, int number) {
        return !(rowsOk(rows, number)  ||  columnOk(column, number)  ||  GridOk(rows, column, number));
    }
/////////////////////////////////////////////////////////////////////////////////////////////

public boolean getcheckBoard(int rowsToCheck,int columnsToCheck,int numbersToCheck){
        return checkBoard(rowsToCheck,columnsToCheck,numbersToCheck);
    };








}