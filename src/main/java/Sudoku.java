
public class Sudoku {
    int counter =0;
    String outputArray="";

    public String getOutputArray() {
        return outputArray;
    }

    public int[][] getBoard() {
        return board;
    }

    private  int[][] board = {
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

    private  int[][] boardCopy=
            {
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

    private  int[][] Secondboard =
                    {{ 0, 0, 4,   0, 0, 0,   0, 6, 7 },
                    { 3, 0, 0,   4, 7, 0,   0, 0, 5 },
                    { 1, 5, 0,   8, 2, 0,   0, 0, 3 },

                    { 0, 0, 6,   0, 0, 0,   0, 3, 1 },
                    { 8, 0, 2,   1, 0, 5,   6, 0, 4 },
                    { 4, 1, 0,   0, 0, 0,   9, 0, 0 },

                    { 7, 0, 0,   0, 8, 0,   0, 4, 6 },
                    { 6, 0, 0,   0, 1, 2,   0, 0, 0 },
                    { 9, 3, 0,   0, 0, 0,   7, 1, 0 }
                    };

    private  int[][] SecondboardCopy =
            {{ 0, 0, 4,   0, 0, 0,   0, 6, 7 },
                    { 3, 0, 0,   4, 7, 0,   0, 0, 5 },
                    { 1, 5, 0,   8, 2, 0,   0, 0, 3 },

                    { 0, 0, 6,   0, 0, 0,   0, 3, 1 },
                    { 8, 0, 2,   1, 0, 5,   6, 0, 4 },
                    { 4, 1, 0,   0, 0, 0,   9, 0, 0 },

                    { 7, 0, 0,   0, 8, 0,   0, 4, 6 },
                    { 6, 0, 0,   0, 1, 2,   0, 0, 0 },
                    { 9, 3, 0,   0, 0, 0,   7, 1, 0 }
            };




    public int[][] getBoard(int [][]board) {
        return board;
    }

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

    private boolean isOk(int rows, int column, int number) {
        return !(rowsOk(rows, number)  ||  columnOk(column, number)  ||  GridOk(rows, column, number));
    }

    public boolean fillBoard() {
if(counter==0){board=board; boardCopy=boardCopy;}
else {board=Secondboard; boardCopy=SecondboardCopy; outputArray ="";}




        for (int rows = 0; rows < 9; rows++) {
            for (int column = 0; column < 9; column++) {
                if (board[rows][column] == 0) {
                    for (int number = 1; number <= 9; number++) {
                        if (isOk(rows, column, number)) {
                            board[rows][column] = number;


                            if (fillBoard()) {
                                return true;
                            } else {
                                board[rows][column] = 0;
                            }
                        }
                    }

                    return false;
                }
            }
        }
        //display Sudoku puzzle
        System.out.print("     INPUT ---------------------OUTPUT");
        System.out.println();


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(" " + boardCopy[i][j]);
            }
            System.out.print("         ");
            for (int j = 0; j < 9; j++) {
                System.out.print(" "+ board[i][j]);
                outputArray = outputArray + (" "+ board[i][j]);     //Comapring Digits
            }

            System.out.println();
        }

        System.out.println();
        counter = 1;
        return true;
    }

}