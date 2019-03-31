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


    boolean verify(){

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (ColumnOfSudokuFields[i] != null && ColumnOfSudokuFields[i].getFieldValue()==(ColumnOfSudokuFields[j].getFieldValue())) {
                    return false;
                }
            }
        }

        // no duplicate found
        return true;

    }
}


