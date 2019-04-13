import java.lang.reflect.Array;
import java.util.*;

public class SudokuBoard {

    SudokuField[][] board = new SudokuField[9][9];                     //2D array of Sudoku fields
    SudokuRow[] rowsOfSudokuFields = new SudokuRow[9];                  //Array of Sudoku fields representing row
    SudokuColumn[] columnsOfSudokuFields = new SudokuColumn[9];         //Array of Sudoku fields representing column
    SudokuBox[] boxesOfSudokufields = new SudokuBox[9];                 //2D array of Sudoku fields representing BOXES


    public ArrayList<SudokuField> ListOfSudokuColumn = new ArrayList<SudokuField>();
    public ArrayList<SudokuField> ListOfSudokuRows = new ArrayList<SudokuField>();
    public ArrayList<SudokuField> ListOfSudokuFields = new ArrayList<SudokuField>();


    public SudokuBoard(int[][] BoardtoSolve) {                          //constructor that assigns copied values from table to objects
        //counter used late to link 3x3 box index
        int counter = 0;

        for (int i = 0; i < 9; i++) {
            rowsOfSudokuFields[i] = new SudokuRow();
            columnsOfSudokuFields[i] = new SudokuColumn();
            boxesOfSudokufields[i] = new SudokuBox();

            for (int j = 0; j < 9; j++) {

                board[i][j] = new SudokuField();
                board[i][j].setFieldValue(BoardtoSolve[i][j]);           //assign Matrix from main to object
                rowsOfSudokuFields[i].setRow(j, board[i][j]);            //rows


                ListOfSudokuFields.add(new SudokuField());
                




                ListOfSudokuRows.add(board[i][j]);      //add Row to lisit

                //assign BOX
                if (j % 3 == 2 && i < 9 && i % 3 == 2) {                  //fancy way of creating 3x3 objects
                    //we want to get every last element in the 3x3 grid
                    // Then we decrement indexes to get them back (We have got for example 2:2 -> 2:1 -> 2:0 -> 1:2 -> 1:1 -> 1:0

                    for (int k = j; k >= j - 2; k--) {
                        for (int l = i; l >= i - 2; l--) {
                            boxesOfSudokufields[(counter / 3) % 9].setBoxOfSudokuFields(l % 3, k % 3, board[k][l]);           //linking boards with counter and translating board indexes into grid indexes

                        }
                        counter++;       //counter

                    }
                }
            }
        }

        for(int v=0;v<9;v++){
            assigncolumn(v);

        }
    }


    void assigncolumn(int x) {
        for (int h = 0; h < 9; h++) {
            columnsOfSudokuFields[x].setColumn(h, board[h][x]);
            ListOfSudokuColumn.add(board[h][x]);

        }
    }

    void getColumn(int whichOne) {
       columnsOfSudokuFields[whichOne].show();
    }

    SudokuRow getRow(int whichOne) {
        return rowsOfSudokuFields[whichOne];
    }

    SudokuBox getBox(int whichOne) {
        return boxesOfSudokufields[whichOne];
    }

    private boolean checkBoard() {
        boolean verdict = true;
        for(int i =0;i<9;i++) {
             verdict=(rowsOfSudokuFields[i].verify() && columnsOfSudokuFields[i].verify() && boxesOfSudokufields[i].verify() );
             if(verdict==false){ System.out.println("Sudokboard does not meet game requirements.");return false;}
        }
        System.out.println("Sudokboard meets game requirements.");
return verdict;
    }

    boolean getcheckBoard(){
        return checkBoard();
    }


/////////////////////////////////////////////////////////// CheckBoard





};

