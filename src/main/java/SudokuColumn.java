public class SudokuColumn{

    public SudokuField [] ColumnOfSudokuFields = new SudokuField[9];

    void show(){

        for(int i=0;i<9;i++){
            if(i==0)            System.out.println("start");

            System.out.println(ColumnOfSudokuFields[i].getFieldValue()+"|");
            if(i==8)            System.out.println("finish");

        }
    }

    void setColumn(int ElementNumber,SudokuField CopiedSudokuField)
    {
        ColumnOfSudokuFields[ElementNumber] = CopiedSudokuField;
    };


    boolean verify(int number){

        for (int i = 0; i < 9; i++) {
                if (ColumnOfSudokuFields[i] == null && ColumnOfSudokuFields[i].getFieldValue()==number);return false;
                //Jezeli kolumna pol sudoku jest rozna od nulla i columnapolsudoku jest rozna od liczby
                }

        // no duplicates found
        return true;

    }
}


