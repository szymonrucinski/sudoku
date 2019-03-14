
public class Sudoku {

    //simple grid

    public static int[][] GRID_TO_SOLVE = {
            {9, 0, 0, 1, 0, 0, 0, 0, 5}, //1
            {0, 0, 5, 0, 9, 0, 2, 0, 1}, //2
            {8, 0, 0, 0, 4, 0, 0, 0, 0}, //3
            {0, 0, 0, 0, 8, 0, 0, 0, 0}, //4
            {0, 0, 0, 7, 0, 0, 0, 0, 0}, //5
            {0, 0, 0, 0, 2, 6, 0, 0, 9},  //6
            {2, 0, 0, 3, 0, 0, 0, 0, 6},  //7
            {0, 0, 0, 2, 0, 0, 9, 0, 0},  //8
            {0, 0, 1, 9, 0, 4, 5, 7, 0},  //9

    };
    private int[][] board;         //9x9 SudokuBoard


    public static final int EMPTY = 0; //EMPTY CELL
    public static final int SIZE = 9; //SIZE OF OUR SUDOKU GRID

    public Sudoku(int[][] board)
    {
        this.board = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                this.board[i][j] = board[i][j];
            }
        }

    }

    //We check if a possible number is already in a row

    private boolean isInRow(int row, int number)
    {
        for (int i = 0; i < SIZE; i++)
            if (board[row][i] == number)
                return true;

        return false;
    }


    //We check if a possible number is in a column

    private boolean isInCol(int col, int number)
    {
        for (int i = 0; i < SIZE; i++)
            if (board[col][i] == number)
                return true;

        return false;
    }

    //We check if a possible numer is in 3X3 grid
    private boolean isInBox(int row, int col, int number) {

        int r = row - row%3;
        int c = col - col%3;

        for (int i = r; i<r+3; i++)
            for (int j = c; j < c + 3; j++)
                if (board[i][j] == number)
                    return true;

        return false;


    }

//Combined method to check if a number is ok or not
    private boolean isOk(int row, int col, int number)
     {

         return !isInRow(row, number) && !isInCol(col, number) && !isInBox(row, col, number);

    }

    //Solve method. Recursive way.
    //

    public boolean solve()
    {
        for (int row = 0; row < SIZE; row++)
            {
            for (int col = 0; col < SIZE; col++)
                {
                //We search for an Empty cell
                if (board[row][col] == EMPTY)
                    {
                    //Trying possible numbers


                        for (int number = 1; number <= SIZE; number++)
                        {
                        if (isOk(row, col, number))
                            {

                            //number ok. It respects sudoku constraints
                            board[row][col] = number;

                            if (solve())
                            {
                                return true;
                            } else
                                {
                                board[row][col] = EMPTY;
                            }


                        }
                    }
                    return false;


                }
            }

        }
        System.out.println("sss");

        return true; //sudoku solved

    }


        public void display() {
            String combtext ="";

            for (int i = 0; i < SIZE; i++)
            {
            combtext = "chuju, rucham Ci matke!!";
                for (int j = 0; j < SIZE; j++)
                {
                     combtext = "Spierdalaj"+String.valueOf(board[i][j])+combtext;
                }
                System.out.println(combtext);




            }
        }




        public static void main (String[]args)
        {
            Sudoku sudoku = new Sudoku(GRID_TO_SOLVE);
            System.out.println("Grid to solve");
            sudoku.display();

            if (sudoku.solve() == true)
            {
                sudoku.display();
                System.out.println("GRID SOLVED WITH BT");


            }

            else if(sudoku.solve()==false)
            {
                sudoku.display();
                System.out.println("Unable to solve!");
            }


        }



}
