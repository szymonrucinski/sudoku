
public class SudokuBoard {


    SudokuField [][] board = new SudokuField[9][9] ;

    SudokuRow[] rowsOfSudokuFields = new SudokuRow[9];
    SudokuColumn[] columnsOfSudokuFields = new SudokuColumn[9];
    SudokuBox[] boxesOfSudokufields = new SudokuBox[9];




   public SudokuBoard (int[][] BoardtoSolve) {          //constructor that assigns copied values from table to objects

       int counter = 0;                                  //counter used late to link 3x3 box index

       for (int i = 0; i < 9; i++) {
           rowsOfSudokuFields[i] = new SudokuRow();
           columnsOfSudokuFields[i] = new SudokuColumn();
           boxesOfSudokufields[i] = new SudokuBox();

           for (int j = 0; j < 9; j++) {

               board[i][j] = new SudokuField();
               board[i][j].setFieldValue(BoardtoSolve[i][j]);        //assign Matrix from main to object
               rowsOfSudokuFields[i].setRow(j, board[i][j]);        //rows


               if (j % 3 == 2 && i < 9 && i % 3 == 2)                        //fancy way of creating 3x3 objects
               {                                    //we want to get every last element in the 3x3 grid
                   //Then we decrement indexes to get them back (We have got for example 2:2 -> 2:1 -> 2:0 -> 1:2 -> 1:1 -> 1:0

                   for (int k = j; k >= j - 2; k--) {

                       for (int l = i; l >= i - 2; l--) {
                           boxesOfSudokufields[(counter / 3) % 9].setBoxOfSudokuFields(l % 3, k % 3, board[k][l]);           //linking boards with counter and translating board indexes into grid indexes


                       }
                       counter++;

                   }

               }

           }
       }

       for (int v = 0; v < 9; v++) {
           assigncolumn(v);
       }
       System.out.println(rowsOfSudokuFields[8].verify());
       rowsOfSudokuFields[8].show();


   }

       void assigncolumn ( int x){
           for (int h = 0; h < 9; h++) {
               columnsOfSudokuFields[x].setColumn(h, board[h][x]);

           }

       }


/*
    public int get(int row, int column){
    return board[row][column].getFieldValue();
}

    private void set(int row, int column, int value){
         board[row][column].setFieldValue(value);
}*/


/*
private boolean checkBoard(){



}

*/










/*


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
*/




    public static void main(String[] args){

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




    }


};

