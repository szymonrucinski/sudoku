import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SudokuBoard {

                        //LISTS
    public ArrayList<ArrayList<SudokuField>> ListOfSudokuFields = new ArrayList<ArrayList<SudokuField>>();
    public ArrayList<SudokuColumn> ListOfSudokuColumn = new ArrayList<SudokuColumn>();
    public ArrayList<SudokuRow> ListOfSudokuRows = new ArrayList<SudokuRow>();
    public ArrayList<SudokuBox>  ListOfSudokuBoxes = new ArrayList<SudokuBox>();


            //constructor that assigns copied values from table to objects
    public SudokuBoard(int[][] BoardtoSolve) {
        //counter used late to link 3x3 box index
        int counter = 0;

        for (int i = 0; i < 9; i++) {




            ListOfSudokuColumn.add(new SudokuColumn());
            ListOfSudokuFields.add(new ArrayList<SudokuField>()); //LINK LIST
            ListOfSudokuRows.add(new SudokuRow());
            ListOfSudokuBoxes.add(new SudokuBox());



            for (int j = 0; j < 9; j++) {

                    ListOfSudokuFields.get(i).add(new SudokuField());
                    ListOfSudokuFields.get(i).get(j).setFieldValue(BoardtoSolve[i][j]);
                    ListOfSudokuRows.get(i).setRow(j,ListOfSudokuFields.get(i).get(j));



                //assign BOX


                    }
                }
                for(int j =0;  j<9; j++) {
            for(int i=0;i<9;i++) {
                if (j % 3 == 2 && i < 9 && i % 3 == 2)                        //fancy way of creating 3x3 objects
                {                                    //we want to get every last element in the 3x3 grid
                    //Then we decrement indexes to get them back (We have got for example 2:2 -> 2:1 -> 2:0 -> 1:2 -> 1:1 -> 1:0

                    for (int k = j; k >= j - 2; k--) {

                        for (int l = i; l >= i - 2; l--) {
                            //linking boards with counter and translating board indexes into grid indexes
                            ListOfSudokuBoxes.get((counter / 3) % 9).setBoxOfSudokuFields(l % 3, k % 3, ListOfSudokuFields.get(k).get(l));

                        }
                        counter++;
                    }
                }
            }
}
assigncolumn();

        }

    void assigncolumn() {

        for(int k=0;k<9;k++) {
            for (int l = 0; l < 9; l++) {
                    ListOfSudokuColumn.get(k).setColumn(l, ListOfSudokuFields.get(l).get(k));

                }
            }


}

    void getColumn(int whichOne) {
       ListOfSudokuColumn.get(whichOne);
    }

    SudokuRow getRow(int whichOne) {
        return ListOfSudokuRows.get(whichOne);
    }

    SudokuBox getBox(int whichOne) {
        return ListOfSudokuBoxes.get(whichOne);
    }

    private boolean checkBoard(int i,int number) {
        boolean verdict = true;
             verdict=(ListOfSudokuRows.get(i).verify(number) && ListOfSudokuColumn.get(i).verify(number) && ListOfSudokuBoxes.get(i).verify(number) );
             //v
             if(verdict==false){return false;}

return verdict;
    }

    boolean getcheckBoard(){
        boolean getcheck = true;

        for(int i =0;i<9;i++)
        {
            getcheck=getcheck&&checkBoard(i,i);
        }
        return getcheck;
    };




/////////////////////////////////////////////////////////// CheckBoard

};
