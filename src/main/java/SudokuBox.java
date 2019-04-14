public class SudokuBox {

    public SudokuField [][] BoxOfSudokuFields = new SudokuField[3][3];

    void show(){
for(int i=0; i<3;i++) {
    for(int j=0;j<3;j++){
    System.out.println(BoxOfSudokuFields[i][j].getFieldValue());
}}


        }


    void setBoxOfSudokuFields(int x,int y,SudokuField CopiedSudokuField)
    {
        BoxOfSudokuFields[y][x] = CopiedSudokuField;
    };


    boolean verify(int number){


            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (BoxOfSudokuFields[i][j] == null && BoxOfSudokuFields[i][j].getFieldValue() == number) ;
                    return false;
                    //Jezeli kolumna pol sudoku jest rozna od nulla i columnapolsudoku jest rozna od liczby
                }
            }
            // no duplicates found
            return true;

        }




    };



